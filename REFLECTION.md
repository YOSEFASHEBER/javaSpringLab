1 Why should the ProductRequest DTO have @Valid instead of the Product entity?

- because dto hapens before entity its like an interface for the entity and user, so before we messed up the database we should sanitize it.

2 What is the Location header in a 201 Created response?

- tell the resource location.

3 Difference between @ControllerAdvice and @ExceptionHandler

exception handler handles one specific exception but controllerAdvice is global exception handler which allows to handle errors for all controllers in the application 

4 What happens if we remove @Transactional from the test class?

it will keep the data from previous test so it cause error for the next test 

5 What does RFC 9457 define?

is standard format for api errors or exceptions 

6 Difference between Integration Test (MockMvc) and Unit Test (Mockito).

MockMvc tests the whole system but unit test tests one class only
use unit tast to tast single business logic and use Integrate test to check the system integration works fine and to test api end points .
