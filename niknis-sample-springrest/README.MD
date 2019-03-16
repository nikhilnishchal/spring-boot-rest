# niknis-sample-springrest
Part 1: It contains a sample demo project for Rest Api configuration, hateoas and internationalization using spring boot.


### Basic Information
**Base package:** com.niknis.sample.niknissamplespringrest<br/>
**Model :** com.niknis.sample.niknissamplespringrest.model.*<br/>
**Controller:** com.niknis.sample.niknissamplespringrest.controller.*<br/>
**Exception :** com.niknis.sample.niknissamplespringrest.exception.*<br/><br/>
**Service (Dao Service) :** com.niknis.sample.niknissamplespringrest.service.*<br/>
**Application property:** resources\application.properties<br/>
**Internationalization message:** resources\message\*<br/>
**Log config:** resources\log4j2.xml

### SpringBootApp: NiknisSampleSpringrestApplication.java
This is the springBootApplication class. We can define Locale resolver and messageBundle source (this can be done by application property) from this file. We can use interceptor in this for real time implementation.  

### model  : Student.java
Student model is as POJO for this sample project.
In which some constraints for dob and name field is used.

### Service: StudentDaoService.java
This is DAO service , It is not connected to any DB level.It uses static list to demonstrate the REST. All service method is defined here. It can be used as interface and implementation based structure.

### Controller: com.niknis.sample.niknissamplespringrest.controller
In this package following three rest controller defined:
* 1. DemoMessageResource : to demonstrate the message internationalization
* 2. StudentResource : To demonstrate the normal operations of view, add and list of stdent record.
* 3. MyResponseEntityExceptionHandler : To manage different type of exception and errors

### Exception : com.niknis.sample.niknissamplespringrest.exception
Different exception for this project defined here.


