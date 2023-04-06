package com.sanjay.insurancemgmt.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long claimNum;
    private String description, claimStatus;
    private LocalDate claimDate;

    public Claim(){}

    public Claim(String description,LocalDate claimDate, String claimStatus) {
        this.description = description;
        this.claimStatus = claimStatus;
        this.claimDate = claimDate;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claim")
    private List<Policy> policyList;

    public List<Policy> getInsurancePolicyList() {
        return policyList;
    }

    public void setInsurancePolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public long getClaimNum() {
        return claimNum;
    }

    public void setClaimNum(long claimNum) {
        this.claimNum = claimNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

}
