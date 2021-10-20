
### SpringBoot API workshop with MongoDB Exercise - Backend Bootcamp 2021 ###
#### Group 2 ####

*Small API to test the knowledge acquired on the third week of the bootcamp.*

Name of the project: **BusWorkshop**


This API aims to simulate a bus workshop, were the entities are the buses, maintenance tasks and teh teams that perform this 
maintenances. We try to used several datatypes, from Strings, to integers, to booleans and LocalDateTime.
Each bus has as an attribute the day of the last maintenance, so as to keep a log of the interventations.
Each maitenance team has an attribute of being available or not...depending of how much time passed since their last intervention.
The maintenance types, being routine and fixed things were designed as enums. Were the name of each tasks is defined and the amount
of time it takes to perform (in hours) is also stored in the enum. 
Some exceptions were implemented, in order to gain some experience with their use.

This API consists of 4 models, of whom 2 are classes and 1 is an enum:

* Models:
  * Classes
    * Bus
    * MaintenanceTeam                                                                
   * Enum:
    * BusType
    
 This API has 2 2 repositories, that extend the MongoDB repository.
* Repositories
  * BusRepository
  * MaintenanceTeamRepository
  
  Similarly, this API has 2 services and 2 controllers
    Several endpoints exist, to perform basic CRUD operations. Namely
* Services
  * BusService
  * MaitenanceTeamService
* Controllers
  * Bus Controller & MaintenanceTeam  Controller
    * Endpoints:
      * Get: all buses or maintenance teams
      * Get: get a bus or maintenance team by ID or by Name
      * Put: update a bus by its ID or its Name
 * Exceptions
   * ResourceNotFound, *if the requested bus or maitenance team does not exist in the DB
   * TeamNotAvailable, *if the maintenance team availability is set to 0
