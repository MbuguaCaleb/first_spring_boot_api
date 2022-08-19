**Rest API**

```yaml


@RestController
The rest controller annotation makes the class serve rest endpoints.



We can use the LomBok Library/Package to remove all boiler plate code.


```

**How to Structure our Work**

```yaml

1.API Layer.

2.Service Layer.

3.Data Access Layer.


API Layer talks to service layer 

service layer talks to data access Layer


controller calls my service...


service is where i write the business logic/do my fetching.


```

**Controller**

```yaml

Request Mapping is like grouping my controller routes
@Controller
@RequestMapping("api/v1/student")

All controller endpoints will be prefixed with the mapping.


```
**Service**

```yaml

@Service annotation makes the class injectable.i.e


Under the hood it makes it a bean component...and is more soecific.


@Autowired Automatically instantiates the class for us.


```