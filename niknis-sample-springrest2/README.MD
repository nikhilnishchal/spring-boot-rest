# niknis-sample-springrest2
Part 2: This demo is continuous upgradation on previous part 1 ([niknis-sample-springrest](https://github.com/nikhilnishchal/spring-boot-rest/tree/master/niknis-sample-springrest)).
Previously used rest controller have, exception and internationalization code.
https://github.com/nikhilnishchal/spring-boot-rest/tree/master/niknis-sample-springrest

Now, It uses swagger api documentation, actuator and filter for the REST api.


### Basic Information
Previous from: <br/>
https://github.com/nikhilnishchal/spring-boot-rest/tree/master/niknis-sample-springrest#basic-information<br/>


**Pom Update:** Added Dependency for Swagger, swaggerUi and actuator<br/>
*SwaggerConfig:** com.niknis.sample.niknissamplespringrest.config.SwaggerConfigrator.java<br/>
**Filter:** Here following type of filter used:<br/>
* As dynamic for specific controller <br/>
* Static filter (using @JsonIgnoreProperties and @JsonIgnore)<br/>

For static filter used model is :  StudentExt.java<br/>
For Dynamic filter used model is:  StudentExtDyn.java and filter name "studentExtDynFilter"<br/>
Both type filter is handled in controller : StudentExtFilterController.java

#### Url (other than defined in all rest controller ):
* http://localhost:8080/actuator/
* http://localhost:8080//v2/api-docs
* http://localhost:8080/swagger-ui.html
* http://localhost:8080/browser/index.html#/


#### Versioning in REST
Versioning related model and controller defined in **com.niknis.sample.niknissamplespringrest.version**
<br/>
There is two model : StudentModelV1 as for version 1 (in this one field for name )<br/>
StudentModelV1 as version 2 (in this two field for name as firstName and lastName)<br/>
Controller created StudentVerController<br/>
In this different approach is used to get the version feature as:<br/>
* URI Versioning
* Request Parameter Versioning
* Media type/Accept header /content negotiation versioning
* (Custom) Header versioning

#### Basic Authentication : To add basic authentication security we need to add spring-boot-starter-security dependency in pom.
It will apply auto besic authentication on all rest api. So, to call service need to provide basic authentication details. details:<br/>
default username : user
password : It will shown in console it time on application up.<br/>
Custom user name and password can be set from application.properties.<br/>


#### JPA and REST
Related to JPA for sample all examples is under package: **com.niknis.sample.niknissamplespringrest.jpa.*** <br/>
jpa and h2 dependency is added there in pom.xml. Log enabled through application.properties<br/>
Model used as StudentDBModel in which JPA annotation is used to create table.<br/>
The created table is as below from log:<br/>
    
    Hibernate: drop table student if exists<br/>
    Hibernate: drop sequence if exists hibernate_sequence<br/>
    Hibernate: create sequence hibernate_sequence start with 1 increment by 1<br/>
    Hibernate: create table student (id integer not null, school varchar(255), dob date, name varchar(255), role integer, primary key (id))<br/>
    
 
There is added data.sql to insert some data in this table on system up.To view data h2-console is there.<br/>
Note: we can use default h2-console to test the data in table. Need to comment **"spring-boot-starter-security"** for getting h2-console view default.
In this configured a class **SecurityConfiguration** for security authentication to bypass h2-console.So It will ignore the http://localhost:8080/h2-console/** path and apply security on our rest api only.<br/>
Table can be viewed on path http://localhost:8080/h2-console/ <br/>
Configuration: JDBC url > jdbc:h2:mem:testdb; driver class> org.h2.Driver; setting name > Generic H2 (Embedded); username > sa, password blank<br/>
In case want to test rest without security, it can be achieved by removing its dependency and config.<br/>



