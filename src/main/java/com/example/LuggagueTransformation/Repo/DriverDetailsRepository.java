package com.example.LuggagueTransformation.Repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.LuggagueTransformation.models.DriverDetails;
import com.example.LuggagueTransformation.models.User;

@EnableJpaRepositories
@Repository
public interface DriverDetailsRepository extends CrudRepository<DriverDetails, Long> {

	  
}
