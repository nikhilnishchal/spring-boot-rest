package com.niknis.sample.niknissamplespringrest.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVerController {

	/*
	 URI based version mapping. In this different URI used for different version of responce.
	 */
	@GetMapping("v1/student")
	public StudentModelV1 getStudentV1() {
		return new StudentModelV1("Nikhil Nishchal", 1234);
	}
	
	@GetMapping("v2/student")
	public StudentModelV2 getStudentV2() {
		return new StudentModelV2(new Name("Nikhil"," Nishchal"), 1234);
	}
	
	/*
	 Request Param:
	 Parameter based version mapping. In  this we pass version as parameter in url
	 as /student/param?version=1 and /student/param?version=2
	 */
	@GetMapping(value="/student/param", params="version=1")
	public StudentModelV1 getStudentParamV1() {
		return new StudentModelV1("Nikhil Nishchal", 1234);
	}
	
	@GetMapping(value="/student/param", params="version=2")
	public StudentModelV2 getStudentParamV2() {
		return new StudentModelV2(new Name("Nikhil"," Nishchal"), 1234);
	}
	
	/*
	 * Header Param :
	 Header based version mapping. In  this we pass version in header as "Accept" as key value (key:Accept, value=1 or 2)
	 on url /student/header
	 */
	@GetMapping(value="/student/header", headers="X-API-VERSION=1")
	public StudentModelV1 getStudentHeadV1() {
		return new StudentModelV1("Nikhil Nishchal", 1234);
	}
	
	@GetMapping(value="/student/header", headers="X-API-VERSION=2")
	public StudentModelV2 getStudentHeadV2() {
		return new StudentModelV2(new Name("Nikhil"," Nishchal"), 1234);
	}
	
	/*
	 * Accept Header type or mime type:
	 produces based version mapping.In  this we pass version in header as "Accept" .
	 and value "application/vnd.company.app-v1+json" or "application/vnd.company.app-v2+json" on url : /student/produces
	 */
	@GetMapping(value="/student/produces", produces="application/vnd.company.app-v1+json")
	public StudentModelV1 getStudentProdV1() {
		return new StudentModelV1("Nikhil Nishchal", 1234);
	}
	
	@GetMapping(value="/student/produces", produces="application/vnd.company.app-v2+json")
	public StudentModelV2 getStudentProdV2() {
		return new StudentModelV2(new Name("Nikhil"," Nishchal"), 1234);
	}
	
}
