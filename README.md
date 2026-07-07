# Rewards API

## Description

Spring Boot REST API that calculates reward points for customers based on transaction amounts.

## Technology

- Java 17
- Spring Boot
- Maven
- JUnit 5
- Mockito

## API

GET /api/rewards

Response

{
"customerId":1,
"totalPoints":120
}

GET /api/rewards/{customerId}

Response

{
"customerId":1,
"monthlyRewards":{
"January":90,
"February":50
},
"totalRewards":140
}