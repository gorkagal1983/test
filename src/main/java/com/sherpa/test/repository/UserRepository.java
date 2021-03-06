package com.sherpa.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sherpa.test.domain.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {


}
