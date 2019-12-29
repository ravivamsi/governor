# governor



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
- [] User API

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

[CGovern](www.cgovern.com)

## Notes

### Variables
1. Variables can be at root, project, plan, stage, job and task levels.
2. Root level variables will only be provided to the administrator role.
3. Variables can be refer in the values as below.

```
 ${this.<level>.<variablekey>}
```


### Actions
1. Run and Stop are the current actions supported.
2. Actions can be triggered on Pipelines and Plans.
3. Support for Stages, Jobs yet to be planned.


### DImages and Workers

#### DImages
1. DImages can only be modified by the administrator.
2. Free subscribers can get the basic DImages default.
3. Premium subscribers can get the advanced DImages along with basic DImages and support.

#### Workers
1. Workers can be configured by the administrator.
2. Workers will be connected to the governor and governor constantly listens to the worker heartbeat.
