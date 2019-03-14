package com.niknis.sample.niknissamplespringrest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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
import com.niknis.sample.niknissamplespringrest.model.Student;
import com.niknis.sample.niknissamplespringrest.service.StudentDaoService;

/**
 * 
 * Controller for Student
 * 
 * @author Nikhil Nishchal
 *
 */
@RestController
public class StudentResource {

	private static final Logger logger = LogManager.getLogger(StudentResource.class);
	@Autowired
	private StudentDaoService studentService;
	
	//@RequestMapping(value={"/students", "/all*","students/*"})
	//@RequestMapping("/students")
	@GetMapping("/student")
	public List<Student> fetchAllStudents(){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentResource : fetchAllStudents() called.....");
		}
		return studentService.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student fetchStudent(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentResource : fetchStudent() called.....");
		}
		Student student = studentService.getStudent(id);
		if(student == null) 
			throw new StudentNotFoundException("Id : "+id);
			
		return student;
	}
	
	//HATEOAS Driven
	@GetMapping("/student-hateoas/{id}")
	public Resource<Student> fetchStudentHateoas(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentResource : fetchStudentHateoas() called.....");
		}
		Student student = studentService.getStudent(id);
		if(student == null) 
			throw new StudentNotFoundException("Id : "+id);
		Resource<Student> resource = new Resource<Student>(student);
		//ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(controller, parameters))
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).fetchAllStudents());
		resource.add(linkTo.withRel("all-students"));
		return resource;
	}
	
	@PostMapping("/student")
	//public Student createStudent(@RequestBody Student student) {
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {	
		Student newStudent = studentService.saveStudent(student);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newStudent.getId()).toUri();
		//return new ResponseEntity(newStudent,HttpStatus.OK).created(location).build();
		return  ResponseEntity.created(location).body(newStudent);
		//return newStudent;
	}
	
	@DeleteMapping("/student/{id}")
	public boolean deleteStudent(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentResource : deleteStudent() called.....");
		}
		boolean isDeleted = studentService.deleteStudent(id);
		if(isDeleted == false) 
			throw new StudentNotFoundException("Id : "+id);
			
		return isDeleted;
	}
	
}
