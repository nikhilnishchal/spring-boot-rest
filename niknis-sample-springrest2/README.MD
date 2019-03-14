# niknis-sample-springrest2
Part 2: This demo is continuous upgradation on previous part 1 ([niknis-sample-springrest](https://github.com/nikhilnishchal/spring-boot-rest/tree/master/niknis-sample-springrest)).
Previously we used rest controller , exception and internationalization.
https://github.com/nikhilnishchal/spring-boot-rest/tree/master/niknis-sample-springrest

Now, we will use swagger api documentation, actuator and filter for the REST api.


### Basic Information
Previous from: <br/>
https://github.com/nikhilnishchal/spring-boot-rest/tree/master/niknis-sample-springrest#basic-information<br/>


**Pom Update:** Added Dependency for Swagger, swaggerUi and actuator<br/>
*SwaggerConfig:** com.niknis.sample.niknissamplespringrest.config.SwaggerConfigrator.java<br/>
**Filter:** For filter we used both type dynamic for specific controller and static one also using @JsonIgnoreProperties and @JsonIgnore<br/>
For static filter we used model StudentExt.java<br/>
For Dynamic filet used the model StudentExtDyn.jav and filter name "studentExtDynFilter"<br/>
Both type filter is handled in controller : StudentExtFilterController.java

#### Url (other than defined in all rest controller ):
http://localhost:8080/actuator/
http://localhost:8080//v2/api-docs
http://localhost:8080/swagger-ui.html
http://localhost:8080/browser/index.html#/



