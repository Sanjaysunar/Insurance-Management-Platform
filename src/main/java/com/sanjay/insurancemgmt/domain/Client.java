package com.sanjay.insurancemgmt.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, address;
    private LocalDate dateOfBirth;

    private int contactInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy")
    private Policy policy;

    public Client(){}

    public Client(String name, String address, LocalDate dateOfBirth,  int contactInfo, Policy policy) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
        this.policy = policy;
    }

    public Policy getInsurancePolicy() {
        return policy;
    }

    public void setInsurancePolicy(Policy policy) {
        this.policy = policy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(int contactInfo) {
        this.contactInfo = contactInfo;
    }
}
