package com.niknis.sample.niknissamplespringrest.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niknis.sample.niknissamplespringrest.jpa.model.StudentDBModel;

@Repository
public interface StudentDBRepository extends JpaRepository<StudentDBModel, Integer>{

}
