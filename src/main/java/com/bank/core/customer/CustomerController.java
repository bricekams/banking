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
    public List<Customer> getAllCustomers(String customerId,
                                            String firstName,
                                          String lastName,
                                          String birthDate,
                                          String nicId,
                                          Boolean hasActiveAccount
            , HttpServletRequest httpServletRequest) {

        if (httpServletRequest.getParameterMap().values().toArray().length < 1) {
            //no params
            return customerRepository.findAll();
        }

        // we wrote the specification, let's use them

        Specification<Customer> specification = Specification
                .where(customerId==null?null:customerIdEqual(customerId))
                .and(firstName == null ? null : firstNameEqual(firstName))
                .and(lastName == null ? null : lastNameEqual(lastName))
                .and(birthDate == null ? null : birthDateEqual(birthDate))
                .and(nicId == null ? null : nicIdEqual(nicId))
                .and(hasActiveAccount == null ? null : hasActiveAccountEqual(hasActiveAccount));

        return customerRepository.findAll(specification);
    }


    public void registerCustomer(NewCusomerRecord newCusomerRecord) {
        Customer customer = new Customer();
        customer.setCustomerId(newCusomerRecord.customerId());
        customer.setFirstName(newCusomerRecord.firstName());
        customer.setLastName(newCusomerRecord.lastName());
        customer.setBirthDate(Helpers.stringToLocalDate(newCusomerRecord.birthDate()));
        customer.setNicId(newCusomerRecord.nicId());
        customer.setHasActiveAccount(false);
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Entity already exist");
        }
    }

    public void updateCustomerData(String customerId, HashMap<String, Object> data) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresentOrElse(e -> {
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "firstName" -> e.setFirstName((String) value);
                    case "lastName" -> e.setLastName((String) value);
                    case "birthDate" -> e.setBirthDate(Helpers.stringToLocalDate((String) value));
                    case "nicId" -> e.setNicId((String) value);
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
