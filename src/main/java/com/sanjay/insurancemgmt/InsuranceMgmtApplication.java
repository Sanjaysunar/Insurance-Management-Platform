package com.sanjay.insurancemgmt;

import com.sanjay.insurancemgmt.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.time.LocalDate;

@SpringBootApplication
public class InsuranceMgmtApplication implements CommandLineRunner {

    @Autowired
    private ClientRespository clientRespository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public static void main(String[] args) {
        SpringApplication.run(InsuranceMgmtApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //Add Claim object and save these to db
        Claim claim1 = new Claim("Health related issue", LocalDate.of(2023,06,03), "process");
        Claim claim2 = new Claim("Accident related issue",LocalDate.of(2023,03,01), "complete");
        Claim claim3 = new Claim("Delete Issue",LocalDate.of(2023,04,01), "progress");
        claimRepository.saveAll(Arrays.asList(claim1, claim2, claim3));

        //Add InsurancePolicy and link to Claim and save these to db
        Policy policy1 = new Policy("Monthly","No", 2500,
                LocalDate.of(2023,05,05),LocalDate.of(2023,10,05), claim2);
        Policy policy2 = new Policy("Quaterly","Yes", 5000,
                LocalDate.of(2022,12,05),LocalDate.of(2023,12,05), claim1);
        Policy policy3 = new Policy("Yearly","Yes", 7000,
                LocalDate.of(2023,01,24),LocalDate.of(2024,01,23), claim3);
        policyRepository.saveAll(Arrays.asList(policy1, policy2, policy3));

        //Add client object and save these to db
        Client client1 = new Client("Sanjay","Bangalore",LocalDate.of(2002,01,03),123456, policy1);
        Client client2 = new Client("Sam","Mysore",LocalDate.of(2001,02,05),258963, policy2);
        Client client3 = new Client("Anup","Mangalore",LocalDate.of(2004,05,24),234583, policy3);
        clientRespository.saveAll(Arrays.asList(client1,client2,client3));
    }
}
