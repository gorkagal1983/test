package com.sherpa.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sherpa.test.domain.Address;

@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, Long> {


}
