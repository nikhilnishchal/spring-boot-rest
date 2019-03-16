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

#### To add basic authentication security we need to add spring-boot-starter-security dependency in pom.
It will apply auto besic authentication on all rest api. So, to call service need to provide basic authentication details. details:<br/>
default username : user
password : It will shown in console it time on application up.<br/>
Custom user name and password can be set from application.properties.<br/>



