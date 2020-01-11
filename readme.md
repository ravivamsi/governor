# Governor

![alt text](assets/auditlogo4.png)


## Build

```
$ mvn clean install
```

## Run

```
$ java -jar target/governor-X.X.X-SNAPSHOT.jar -Dspring.profiles.active=prod
```

## Priority

- [] Projects API
- [] Pipelines API 
- [] Plans API 
- [] Stages API 
- [] Jobs API 
- [] Tasks API 
- [] User API
- [] Workers API 
- [] Notifications API 
- [] DImages API 
- [] Roles API 
- [] Groups API 
- [] Triggers API 


## To-Do

- [] Swagger Updates - In Progress
- [] Mongo Database - In Progress
- [] Application Properties - In Progress
- [] API Implementation - In Progress
- [] Upload File
- [] Download File
- [] Execution Logs asList
- [] Workspace Operations
- [] Folder Structure in Worker
- [] Generic SFTP Implementation
- [] Scheduler


## Swagger

Refer to swagger.yaml in following location.

[Swagger](https://github.com/ravivamsi/governor/blob/master/swagger.yaml)

Refer to this Webpage for Springboot Implementation with Mongo DB

[MongoBD Springboot](https://www.journaldev.com/18156/spring-boot-mongodb)


## Domain

Hosting Domain

[www.cgovern.com](www.cgovern.com)

## Notes

### Variables
1. Variables can be at root, project, plan, stage, job, task and pipeline levels.
2. Root level variables will only be provided to the administrator role.
3. Variables can be refer in the values as below.

```
 ${this.<level>.<variablekey>}
```
4. Variables with the same name will be overridden as per the priority below:
 
| Priority  	| Level			|
| ------------- | ------------- |
| 1			  	| Root		    |
| 2				| Project	 	|
| 3				| Plan		 	|
| 4				| Stage		 	|
| 5				| Job		 	|
| 6				| Task		 	|
| 7				| Pipeline	 	|


### Actions
1. Run, Re-run and Stop are the current actions supported.
2. Actions can be triggered on Pipelines, Plans and Stages.
3. Role permissions to trigger an action: admin and run 


### DImages and Workers

#### DImages
1. DImages can only be modified by the admin role user only.
2. Free subscribers can get the basic DImages default.
3. Premium subscribers can get the advanced DImages along with basic DImages and support.

#### Workers
1. Workers can be configured by the administrator.
2. Workers will be connected to the governor and governor constantly listens to the worker heartbeat.


### Free Subscribers vs Enterprise Subscribers

|	Component  		|	Free			|	Enterprise			|
|  ---------------- |  ---------------- | ---------------------	|
|	DImages			|	Basic		    |	Premium				|
|	Support 		|	Community		|	CGovern Support		|
|	Workers			|	1				|	Any					|
|	Execution		|	Series			|	Parallel			|
|	





