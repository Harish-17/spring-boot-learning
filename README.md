# spring-boot-learning
First Project to learn basics of spring boot

## Learnings :
- Maven is used to find and install dependencies from the mvnrepository
- Dependencies needed are specified in pom.xml
- Dependency injection is spring trying to find the dependency at runtime
- To find a dependency use `@AutoWired` on the field
Eg.,
```
  @Autowired private ToDoRepository toDoRepo;
```
- Application.properties can be used to configure stuff like tomcat server.port, db, db_user name
- `@RestController` = @Controller + @ResponseBody
- @Controller is used to consume requests
- @ResponseBody is used to denote that the response is not a view rather the response itself
- `@GetMapping("{resources}"), @GetMapping("{resources}/{id}"), @PostMapping("{resources}"), @PutMapping("{resources}"), @DeleteMapping("{resources}/{id}")` should be used for corresponding rest requests
- consumes="application/json" & produces="application/json" can be used to denote that the server consumes only json and produces only json resp.
- Example: `@GetMapping(path="{resources}", consumes="application/json")`
- `@RequestBody` is used to specify that parameter is received as a json.
- `@PathVariable("id")` is used to denote that the param is part of the url [Eg., todos/123 -> id = 123]
- To throw custom exception messages use `ResponseStatusException`
Eg.,
```
  try {
			return toDoRepo.findById(id).orElseThrow(IllegalArgumentException :: new);
		}catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, id+" not found");
		}
```
*Note:add `server.error.include-message=always` in application.properties*
- To create a JPA entity use `@Entity` on the class and `@Id` on the field that you need to specify primary key
- Use `@Table(name="")` for specifying table name to JPA
- To perform CRUD operation in db create a repository interface by extending CRUDRepository<Entity, Primary_Key_Datatype> or              JPARepository<Entity,Primary_Key_Datatype>
	Eg.,
	```
		public interface ToDoRepository extends JpaRepository<ToDo,Integer>
	```
- If you need to query by using columns other than pk, then declare a method with the following convention : `findBy + {variableName}`, Need not provide any implementation
- To write your own query, then declare a method with any suitable name with @Query(query) annotations. 
Eg.,
```
@Query(select(count(pk)) from todo) 
int getCount()
```
- > Lombok is awesome

### Dependencies used:
web, mysql-connector, jpa
> For more info, refer pom.xml


## TODO:
1. Need to find way to specify column name
2. Learn and integrate spring security
3. Dive deep
