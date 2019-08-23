# Coding Challenge - The Survey App

## 1. Getting Started

For getting started I provided a Dockerfile for building the Spring Boot backend and a 
docker-compose.yml for starting a mongoDb container along with it. So:
`docker-compose up` should be all you need to run everything and then the service should be up on 
`http://localhost:8080`

  Pro-Tip:
  I added HTML5 validation so all 25 Answers are required, if you just want to quickly make
  a post to the backend, you can use this little hack. Paste this in the chrome dev console:
  `var buttons = document.getElementsByTagName('input');` and then this to click every button ;-) `for(var i = 0; i <= buttons.length; i++)  
                                                     buttons[i].click();`
  Of course I have never used this during development 😇

## 2. The Backend
The Backend is a simple 
- JUnit5 
- Spring Boot
- MongoDB 
- Java12  
Application. I provided some Unit tests and an extra component/integration test package. For 
integration testing I like to use the testcontainers library because it allows me to easily spin
up docker containers for my tests. I always prefer having an actual Service (f.ex. MongoDB)
in a clean state over using some kind of In Memory DB or Mock Service for component testing. 

### 2.1 Running the Backend
The project uses maven, so `mvn package` , `mvn test` etc. should be all you need. 

### 2.2 Todos
- I am missing a full end to end test for this
- I do not validate the predicate for question 3 on the backend
- I do not have any profiles defined, so you can only run it in docker or use the tests currently, for running a local version from the IDE you would need to make code changes

## 3. The Frontend
The frontend code is definitely my weak spot. I have never used react.js before and my last
real JavaScript coding experience was years ago. That is why my frontend code is currently not really 
tested that well :-/ I am learning how to write tests for react components currently. 

### 3.1 Running the Frontend
I used a basic npm setup, so you should be able to get everything going by running 
`npm run mock:api` which will start the following apis: 
```
Resources
http://localhost:4000/categories
http://localhost:4000/surveys
```

and then run `npm start` and get the frontend on `http://localhost:3000`

### 3.2 Todos
- learn react component testing




