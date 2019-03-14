package com.niknis.sample.niknissamplespringrest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.niknis.sample.niknissamplespringrest.model.Student;

@Component
public class StudentDaoService {

	//List object for holding data
	private static List<Student> students = new ArrayList<Student>();
	private static int studentsCount = 3;
	static {
		students.add(new Student(1, "Nikhil", 111, "DAV", LocalDate.parse("2015-02-20")));
		students.add(new Student(2, "Nishchal", 222, "ABC", LocalDate.of(2005, 01, 21)));
		students.add(new Student(3, "Nishchal", 333, "XYZ", LocalDate.now()));
	}
	
	public List<Student> findAll(){
		return students;
		
	}
	
	public Student saveStudent(Student student){
		if(student.getId() == null) {
			student.setId(++studentsCount);
		}
		 students.add(student);
		return student;
	}
	
	public Student getStudent(int id){
		/*for(Student student : students) {
		}*/
		Student st = students.stream()					//converted collection to steam
        .filter(student -> student.getId() == id)		//we want specific student based on id
        .findAny()                                      // If 'findAny' then return found
        .orElse(null);									// IF not found return 'null'
		
		return st;
	}
	public boolean deleteStudent(int id){
		/*for(Student student : students) {
		}*/
		boolean isRemoved = students.removeIf(student -> (student.getId() == id));
		
		return isRemoved;
	}
	
}
