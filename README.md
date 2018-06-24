# hackatonSkipTheDishes
The project is to show the usage of different technologies from the stack.

The idea is to have an api where Front-End can consume and access the GoogleApi Nearby Places directly and the api will store this search on database (a few fields) and send it to a queue where it can be consumed by another service (such as a ETL, data storage service).

#Technical points

There are two controllers on the api, one which performs operations related to security and another with a call to access Google Nearby Places API.

The UserController (related to security) uses the spring security implementation to perform two action: 
  1 - Register a user passing username and password on a POST request to add the user to the database, with a random generated token assigned to it. Request example: http://localhost:8080/public/users/register?username=user&password=pass
  2 - Make the login of the user using the same username and password registered and returns the token used to access the secured endpoints. Request example: http://localhost:8080/public/users/login?username=user&password=pass / return "66a93ab2-a6be-4fb4-a6e1-bbc2a44902c4"
  
This token should be passed as a header param with name "Authorization" on calls to secured endpoints to be executed.
  
Points to improve:
 - Generate a JWT token (or other type) to take in consideration expiration time of the token, as it doesn't take it now.
 - Protect the secured based on ROLES (authorities) for each user and endpoint.
 
 
The GoogleConsultController is the interface to abstract the request to Google API without needing to manage Google API Keys and the full response from their API. Request example: http://localhost:8080/google/consult/summarized?location=-23.5833345,-46.6795029&radius=5000&type=restaurant
Along with that, the endpoint will also save the response converted to internal format in the database and send the object as a Json to a queue, to be consumed by other systems.

My Initial Idea: Every time a search is made, you take only the important information and send to a QUEUE, which will be consumed by a Elastic Search Storage and allow Data Enginneers to work with these data.


There is also the enabled configuration to register on an Eureka Server and allow service discovery making it easier to manage connections.


IMPORTANT: I was planning to use MongoDb on the solution, but I had some technical difficulties on my machine to run it so I took a diiferent approach to not waste time trying to work on something that wouldn't be "visible". I used H2 instead as a second alternative.
