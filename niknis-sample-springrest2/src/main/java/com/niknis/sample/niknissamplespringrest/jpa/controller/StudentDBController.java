package com.niknis.sample.niknissamplespringrest.jpa.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.niknis.sample.niknissamplespringrest.exception.StudentNotFoundException;
import com.niknis.sample.niknissamplespringrest.jpa.model.StudentDBModel;
import com.niknis.sample.niknissamplespringrest.jpa.repository.StudentDBRepository;
import com.niknis.sample.niknissamplespringrest.model.Student;
import com.niknis.sample.niknissamplespringrest.service.StudentDaoService;

/**
 * 
 * Controller for StudentDBModel
 * 
 * @author Nikhil Nishchal
 *
 */
@RestController
public class StudentDBController {

	private static final Logger logger = LogManager.getLogger(StudentDBController.class);
	@Autowired
	private StudentDBRepository studentDBRepository;
	
	//@RequestMapping(value={"/students", "/all*","students/*"})
	//@RequestMapping("/students")
	@GetMapping("/db/student")
	public List<StudentDBModel> fetchAllStudents(){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : fetchAllStudents() called.....");
		}
		return studentDBRepository.findAll();
	}
	
	@GetMapping("/db/student/{id}")
	public Optional<StudentDBModel> fetchStudent(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : fetchStudent() called.....");
		}
		Optional<StudentDBModel> student = studentDBRepository.findById(id);
		if(!student.isPresent()) 
			throw new StudentNotFoundException("Id : "+id);
			
		return student;
	}
	
	
	@PostMapping("/db/student")
	//public Student createStudent(@RequestBody Student student) {
	public ResponseEntity<StudentDBModel> createStudent(@Valid @RequestBody StudentDBModel student) {	
		StudentDBModel newStudent = studentDBRepository.save(student);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newStudent.getId()).toUri();
		//return new ResponseEntity(newStudent,HttpStatus.OK).created(location).build();
		return  ResponseEntity.created(location).body(newStudent);
		//return newStudent;
	}
	
	@DeleteMapping("/db/student/{id}")
	public void deleteStudent(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : deleteStudent() called.....");
		}
		studentDBRepository.deleteById(id);
	}
	
}
