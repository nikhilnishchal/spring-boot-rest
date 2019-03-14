package com.niknis.sample.niknissamplespringrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.niknis.sample.niknissamplespringrest.model.StudentExt;
import com.niknis.sample.niknissamplespringrest.model.StudentExtDyn;

@RestController
public class StudentExtFilterController {
	//*******Static filter based*******/
	@GetMapping("/student-ext")
	public StudentExt getStudentExt() {
		return new StudentExt("password", 1234, "Father Name", "Mother Name", "Address here","Mumbai","srt1","434343");
	}

	@GetMapping("/student-ext-list")
	public List<StudentExt> getStudentExtList() {
		return Arrays.asList(new StudentExt("password", 1234, "Father Name", "Mother Name", "Address here","Mumbai","srt1","434343"),
				new StudentExt("password1", 4321, "Father Name1", "Mother Name1", "Address here1","Pune","srt2","435454"));
	}
	
	//*******Dynamic filter based*******/
	@GetMapping("/student-ext-dyn")
	public MappingJacksonValue getStudentExtDynFlt() {
		StudentExtDyn studentExtDyn = new StudentExtDyn("password", 1234, "Father Name", "Mother Name", "Address here","Mumbai","srt1","434343");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("street","city","password");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("studentExtDynFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(studentExtDyn);
		mapping.setFilters(filterProvider);
		return mapping;
	}

	@GetMapping("/student-ext-dyn-list")
	public MappingJacksonValue getStudentExtDynListFlt() {
		List<StudentExtDyn> list =  Arrays.asList(new StudentExtDyn("password", 1234, "Father Name", "Mother Name", "Address here","Mumbai","srt1","434343"),
				new StudentExtDyn("password1", 4321, "Father Name1", "Mother Name1", "Address here1","Pune","srt2","435454"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("street","city","password");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("studentExtDynFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
	}
}
