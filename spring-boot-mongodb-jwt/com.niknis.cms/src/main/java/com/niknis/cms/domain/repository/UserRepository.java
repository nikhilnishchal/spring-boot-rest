package com.niknis.cms.domain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.niknis.cms.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, Long> {

	public Optional<UserEntity> findById(String idStudent);
	
	//Supports native JSON query string
//    @Query("{'class':'0'}")
	public Optional<UserEntity> findByEmail(String email);
	
}
