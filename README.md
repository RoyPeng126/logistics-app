# Logistics App

This is a simple Spring Boot project for managing shipments and users.

## Building and Running

Ensure you have JDK 17 and Maven installed. Then run:

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

## API Endpoints

- `POST /api/auth/register` — register a new user.
- `POST /api/auth/login` — authenticate a user (returns a mock JWT token).
- `POST /api/shipments` — create a shipment.
- `GET /api/shipments` — list all shipments.

Security is currently disabled, so the endpoints are accessible without authentication.
