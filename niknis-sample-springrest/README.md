#niknis-sample-springrest 
Part 1: It contains a sample demo project for Rest Api configuration and internationalization using spring boot.


###Basic Information
Base package: com.niknis.sample.niknissamplespringrest
Model : com.niknis.sample.niknissamplespringrest.model.*
Controller: com.niknis.sample.niknissamplespringrest.controller.*
Exception : com.niknis.sample.niknissamplespringrest.exception.*
Service (Dao Service) : com.niknis.sample.niknissamplespringrest.service.*
Application property: resources\application.properties
Internationalization message: resources\message\*
Log config: resources\log4j2.xml

###SpringBootApp: NiknisSampleSpringrestApplication.java
This is the springBootApplication class. We can define Locale resolver and messageBundle source (this can be done by application property) from this file. We can also use interceptor for this.  
###model  : Student.java
We use Student model as POJO for this sample project.
In which we used some constraints for dob and name field.

###Service: StudentDaoService.java
This is DAO service , we are not connected this with any DB level.We used this with static list to demonstrate the REST. Se we used all service method in this. We can use this as interface and implementation based.

###Controller: com.niknis.sample.niknissamplespringrest.controller
In this package we define three rest controller 
1. DemoMessageResource : to demonstrate the message internationalization
2. StudentResource : To demonstrate the normal operations of view, add and list of stdent record.
3. MyResponseEntityExceptionHandler : To manage different type of exception and errors

###Exception : com.niknis.sample.niknissamplespringrest.exception
Here we defined different exception for this project


