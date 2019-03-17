package com.niknis.sample.niknissamplespringrest.jpa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.niknis.sample.niknissamplespringrest.exception.StudentNotFoundException;
import com.niknis.sample.niknissamplespringrest.jpa.model.BlogPost;
import com.niknis.sample.niknissamplespringrest.jpa.model.StWritterDBModel;
import com.niknis.sample.niknissamplespringrest.jpa.repository.BlogPostDBRepository;
import com.niknis.sample.niknissamplespringrest.jpa.repository.StudentWritterDBRepository;

/**
 * 
 * Controller for StWritterDBModel
 * 
 * @author Nikhil Nishchal
 *
 */
@RestController
public class StudentWritterDBController {

	private static final Logger logger = LogManager.getLogger(StudentWritterDBController.class);
	@Autowired
	private StudentWritterDBRepository studentWritterDBRepository;
	
	@Autowired
	private BlogPostDBRepository blogPostDBRepository;
	
	//@RequestMapping(value={"/students", "/all*","students/*"})
	//@RequestMapping("/students")
	@GetMapping("/db/student-writter")
	public List<StWritterDBModel> fetchAllStudents(){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : fetchAllStudents() called.....");
		}
		return studentWritterDBRepository.findAll();
	}
	
	@GetMapping("/db/student-writter/{id}")
	public Optional<StWritterDBModel> fetchStudent(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : fetchStudent() called.....");
		}
		Optional<StWritterDBModel> student = studentWritterDBRepository.findById(id);
		if(!student.isPresent()) 
			throw new StudentNotFoundException("Id : "+id);
			
		return student;
	}
	
	
	@PostMapping("/db/student-writter")
	//public Student createStudent(@RequestBody Student student) {
	public ResponseEntity<StWritterDBModel> createStudent(@Valid @RequestBody StWritterDBModel student) {	
		StWritterDBModel newStudent = studentWritterDBRepository.save(student);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newStudent.getId()).toUri();
		//return new ResponseEntity(newStudent,HttpStatus.OK).created(location).build();
		return  ResponseEntity.created(location).body(newStudent);
		//return newStudent;
	}
	
	@PostMapping("/db/student-writter/{id}/bpost")
	//public Student createBPost(@PathVariable int id, @RequestBody Student student) {
	public ResponseEntity<BlogPost> createStudentPost(@PathVariable int id, @Valid @RequestBody BlogPost bPost) {	
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : fetchStudent() called.....");
		}
		Optional<StWritterDBModel> student = studentWritterDBRepository.findById(id);
		if(!student.isPresent()) 
			throw new StudentNotFoundException("Id : "+id);
		bPost.setStWritterDBModel(student.get());
		BlogPost newPost = blogPostDBRepository.save(bPost);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPost.getId()).toUri();
		//return new ResponseEntity(newStudent,HttpStatus.OK).created(location).build();
		return  ResponseEntity.created(location).body(newPost);
		//return newStudent;
	}
	
	@GetMapping("/db/student-writter/{id}/bpost")
	public List<BlogPost> fetchStudentPost(@PathVariable int id){
		if(logger.isDebugEnabled()) {
			logger.debug("StudentDBController : fetchStudent() called.....");
		}
		Optional<StWritterDBModel> student = studentWritterDBRepository.findById(id);
		if(!student.isPresent()) 
			throw new StudentNotFoundException("Id : "+id);
			
		return student.get().getBlogPosts();
	}
	
}
