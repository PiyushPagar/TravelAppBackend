package com.example.LuggagueTransformation.Repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.LuggagueTransformation.models.ERole;
import com.example.LuggagueTransformation.models.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {

	Optional<Role> findByName(ERole roleUser);

}
