package com.bank.core.branch;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.bank.core.account.Account;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "branches")
public class Branch {
    @Id
    @SequenceGenerator(
            name = "branch_id_sequence",
            sequenceName = "branch_id_sequence",
            allocationSize = 33
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_id_sequence"
    )

    private Long branchId;
    private String name;
    private String town;
    @JsonManagedReference
    @OneToMany(mappedBy = "creationBranch")
    private List<Account> branchAccountsList;

    public Branch(Long branchId, String name, String town, List<Account> branchAccountsList) {
        this.branchId = branchId;
        this.name = name;
        this.town = town;
        this.branchAccountsList = branchAccountsList;
    }

    public Branch() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return branchId.equals(branch.branchId) && name.equals(branch.name) && town.equals(branch.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, name, town);
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public List<Account> getBranchAccountsList() {
        return branchAccountsList;
    }

    public void setBranchAccountsList(List<Account> branchAccountsList) {
        this.branchAccountsList = branchAccountsList;
    }
}
