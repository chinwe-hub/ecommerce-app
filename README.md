# Ecommerce App (In Progress)

This is a full-stack e-commerce app I am building step-by-step in
Spring Boot, PostgreSQL, JWT auth, and React. It is not finished yet.
This README reflects what currently works, and what is still planned.

## Tech stack
- Backend: Java, Spring Boot, Spring Data JPA, Spring Security, PostgreSQL
- Auth: JWT (JSON Web Tokens)
- Frontend: React (not started yet)

## Status: what's working right now

- [x] Product entity + full CRUD (GET, POST, PUT, DELETE) via `/api/products`
- [x] Category entity + create/list via `/api/categories`
- [x] Product ↔ Category relationship (many-to-one)
- [x] User entity with hashed passwords (BCrypt)
- [x] Registration endpoint (`POST /api/auth/register`)
- [x] Login endpoint returns a JWT (`POST /api/auth/login`)
- [x] JWT validation filter — protected endpoints require a valid token
- [ ] Role-based access (admin-only endpoints)
- [ ] Cart entity + add/update/remove items
- [ ] Order entity + checkout flow
- [ ] React frontend
- [ ] Auto-seeded sample data on startup

## How to run it (backend only, for now)

1. Create the database: `CREATE DATABASE ecommerce_db;`
2. Update `application.properties` with your Postgres credentials
3. Run: `./mvnw spring-boot:run`
4. Hibernate auto-creates all tables on startup (`ddl-auto=update`) —
   no manual SQL needed

## API endpoints so far

| Method | Endpoint | Auth required? | Description |
|---|---|---|---|
| GET | /api/products | No | List all products |
| POST | /api/products | No (should be admin-only later) | Create a product |
| PUT | /api/products/{id} | No (should be admin-only later) | Update a product |
| DELETE | /api/products/{id} | No (should be admin-only later) | Delete a product |
| GET | /api/categories | No | List categories |
| POST | /api/categories | No (should be admin-only later) | Create a category |
| POST | /api/auth/register | No | Register a new customer |
| POST | /api/auth/login | No | Log in, returns a JWT |
| GET | /api/auth/me | Yes | Test endpoint — confirms JWT auth works |
