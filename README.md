# Rewards API

## Problem Statement

Calculate reward points for customer transactions.

## Reward Rules

- Spend > $100 = 2 points per dollar
- Spend between $50-$100 = 1 point per dollar

Example:

Purchase = $120

Reward = 90 points

## Tech Stack

- Java 21
- Spring Boot 3
- Maven
- JUnit 5

## API

GET /api/rewards/{customerId}?months=3

## Run

mvn spring-boot:run

## Test

mvn test