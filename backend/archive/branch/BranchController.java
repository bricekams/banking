package com.bank.core.branch;

import com.bank.core.branch.utils.NewBranchRecord;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

import static com.bank.core.branch.BranchSpecification.*;

public class BranchController {
    private final BranchRepository branchRepository;

    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getBranches(
            String town,
            Long numberOfAccountMoreThan,
            Long numberOfAccountLessThan,
            HttpServletRequest httpServletRequest
    ) {

        if (httpServletRequest.getParameterMap().values().toArray().length < 1) {
            //no params
            return branchRepository.findAll();
        }

        Specification<Branch> specification = Specification
                .where(town == null ? null : townEqual(town))
                .and(numberOfAccountLessThan == null ? null : numberOfAccountsLessThan(numberOfAccountLessThan))
                .and(numberOfAccountMoreThan == null ? null : numberOfAccountGreaterThan(numberOfAccountMoreThan));

        return branchRepository.findAll(specification);
    }

    public void createBranch(NewBranchRecord newBranchRecord) {
        Branch newBranch = new Branch();
        newBranch.setName(newBranchRecord.branchName()); //todo: implements logic
        newBranch.setTown(newBranchRecord.town());
        newBranch.setBranchAccountsList(List.of());
        branchRepository.save(newBranch);
    }

    public Branch getBranchById(Long branchId) {
        return branchRepository.findById(branchId).orElse(null);
    }
}
