package com.bank.core.customer;


import com.bank.core.Helpers;
import com.bank.core.customer.utils.NewCusomerRecord;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;


import static com.bank.core.customer.CustomerSpecification.*;


public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    // This function return an array of users. The result can be tuned/filtered depending on the query parameters in the url
    public List<Customer> getAllCustomers(String firstName,
                                          String lastName,
                                          String birthDate,
                                          String cityOfBirth,
                                          String nicId,
                                          String email,
                                          Integer phoneNumber,
                                          Boolean hasActiveAccount
            , HttpServletRequest httpServletRequest) {

        if (httpServletRequest.getParameterMap().values().toArray().length < 1) {
            //no params
            return customerRepository.findAll();
        }

        // we wrote the specification, let's use them

        Specification<Customer> specification = Specification
                .where(firstName == null ? null : firstNameContains(firstName))
                .and(lastName == null ? null : lastNameContains(lastName))
                .and(birthDate == null ? null : birthDateContains(birthDate))
                .and(cityOfBirth == null ? null : cityOfBirthContains(cityOfBirth))
                .and(nicId == null ? null : nicIdContains(nicId))
                .and(email == null ? null : emailContains(email))
                .and(phoneNumber == null ? null : phoneNumberContains(phoneNumber))
                .and(hasActiveAccount == null ? null : hasActiveAccountContains(hasActiveAccount));

        return customerRepository.findAll(specification);
    }


    public void registerCustomer(NewCusomerRecord newCusomerRecord) {
        Customer customer = new Customer();
        customer.setFirstName(newCusomerRecord.firstName());
        customer.setLastName(newCusomerRecord.lastName());
        customer.setBirthDate(Helpers.stringToLocalDate(newCusomerRecord.birthDate()));
        customer.setCityOfBirth(newCusomerRecord.cityOfBirth());
        customer.setNicId(newCusomerRecord.nicId());
        customer.setEmail(Helpers.checkAndReturnEmail(newCusomerRecord.email()));
        customer.setPhoneNumber(newCusomerRecord.phoneNumber());
        customer.setHasActiveAccount(false);
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Entity already exist");
        }
    }

    public void updateCustomerData(Long customerId, HashMap<String, Object> data) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresentOrElse(e -> {
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "firstName" -> e.setFirstName((String) value);
                    case "lastName" -> e.setLastName((String) value);
                    case "birthDate" -> e.setBirthDate(Helpers.stringToLocalDate((String) value));
                    case "cityOfBirth" -> e.setCityOfBirth((String) value);
                    case "nicId" -> e.setNicId((String) value);
                    case "email" -> e.setEmail(Helpers.checkAndReturnEmail((String) value));
                    case "phoneNumber" -> e.setPhoneNumber((Long) value);
                    case "hasActiveAccount" -> e.setHasActiveAccount((Boolean) value);
                    default -> {
                        System.out.println("put request bad format");
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unrecognized field");
                    }
                }
            }
            customerRepository.save(e);
        },()->{
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Account does not exist");
        });
    }
}
