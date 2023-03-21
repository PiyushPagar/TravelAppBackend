package com.example.LuggagueTransformation.Repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.LuggagueTransformation.models.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	  Optional<User> findByEmail(String email);
	  Boolean existsByEmail(String email);
	  @Transactional
	  @Modifying
//	  @Query(value = "UPDATE users u SET u.password =:password WHERE u.email = :email",nativeQuery = true)
//	  void updatepasswordwithemail(@Param("email") String email,@Param("password")String password);
	  User findUserByEmail(String email);
	  User findUserById(long id);
	  <T> Page<User> findAll(Specification<T> example, Pageable page);
}
