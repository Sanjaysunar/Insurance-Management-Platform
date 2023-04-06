package com.sanjay.insurancemgmt.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long policyNum;
    private String type, premium;
    private int coverageAmount;
    private LocalDate startDate, endDate;



    public Policy(){}

    public Policy(String type, String premium, int coverageAmount, LocalDate startDate, LocalDate endDate, Claim claim) {
        this.type = type;
        this.premium = premium;
        this.coverageAmount = coverageAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.claim = claim;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policy")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "claim")
    private Claim claim;


    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public long getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(long policyNum) {
        this.policyNum = policyNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


}
