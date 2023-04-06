package com.sanjay.insurancemgmt.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="policies")
public interface PolicyRepository extends CrudRepository<Policy, Long> {
}
