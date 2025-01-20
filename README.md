# Restaurant Management System
A platform for users to browse the menu, place orders, and for restaurants to manage their menu and orders.


## Table of Contents
- Overview
- Features
- Installation
- Usage
- Technologies Used
- Acknowledgments

---

## Overview
The Restaurant Management System is designed to streamline food ordering and restaurant menu management. It allows users to view the menu, place orders, and track order status, while enabling restaurants to manage their menus and orders efficiently.  
The system is divided into two main components:
- **Menu Service**: Manages the food menu items, including adding, updating, and checking availability of food items.
- **Order Service**: Handles customer orders and tracks their status.

The system ensures smooth communication between services using **Feign Client** for real-time inventory checks and **Eureka Server** for dynamic service discovery.

---

## Features

### Food Menu Management:
- **Add, Retrieve, and View Food Items**: Restaurants can add, retrieve, and update food items with details such as name, description, price, and quantity.
- **Food Item Availability**: The system checks the availability of food items based on the requested quantity before confirming an order.

### Order Management:
- **Place Orders**: Users can place orders, and the system ensures that the ordered food items are available.
- **Order Status Management**: Restaurants can track and update the status of orders (e.g., "pending" or "completed").

### Microservice Communication:
- **Feign Client**: The Order Service communicates with the Menu Service to verify food item availability in real-time.
- **Eureka Server**: Facilitates dynamic registration and discovery of services for scaling and fault tolerance.

### Centralized Service Registry:
- Monitor and manage the health and availability of services using the **Eureka Dashboard**.

### Database Integration:
- **MySQL Database**:
  - `restaurant_db` for storing menu and order data.

### Testing and Validation:
- Use **Postman** to test service endpoints and validate functionality.
- Handle errors like insufficient food item quantity during order placement.

### Modular and Scalable:
- Independent services that are easy to scale, with potential for adding future features like payment integration.

---

## Installation
Follow these steps to set up the project locally:

### 1. Set Up MySQL Databases
- Open phpMyAdmin or any MySQL client.
- Create the database:
  ```sql
  CREATE DATABASE restaurant_db;
  USE restaurant_db;
  INSERT INTO menu (name, price) VALUES
  ('Burger', 5.99),
  ('Pizza', 8.99),
  ('Pasta', 7.49),
  ('Salad', 4.49),
  ('Soda', 1.99);
  INSERT INTO orders (menu_id, status) VALUES
  (1, 'pending'),
  (2, 'completed'),
  (3, 'pending'),
  (4, 'completed');
### 2. Start the Eureka Server
- Navigate to the Eureka Server project in your IDE.
- Run the application (`EurekaApplication.java`).
- Verify the Eureka Dashboard is available at: `http://localhost:8761`.
### 3. Start the Microservices
#### Food Menu Service:
- Navigate to the Food Menu Service project in your IDE.
- Run the application (`FoodServiceApplication.java`).
- Verify that the service is registered in Eureka (accessible via the Eureka Dashboard).

#### Orders Service:
- Navigate to the Orders Service project in your IDE.
- Run the application (`OrderServiceApplication.java`).
- Verify that the service is also registered in Eureka.
---

## Usage

Test the System using Postman or any HTTP client:

### Food Menu Service Endpoints:
1. **Get all food items**:
   - `GET http://localhost:8081/api/menu`
2. **Add a food item**:
   - `POST http://localhost:8081/api/menu`
   - Body (JSON):
     ```json
     {
         "name": "Pasta",
         "price": 7.49
     }
     ```
3. **Get a specific food item**:
   - `GET http://localhost:8081/api/menu/{id}` (Replace `{id}` with the actual food item ID)
4. **Check availability of a food item**:
   - `GET http://localhost:8081/api/menu/{id}/check-availability?quantity=5` (Replace `{id}` with the food item ID)

### Orders Service Endpoints:
1. **Get all orders**:
   - `GET http://localhost:8082/api/orders`
2. **Place an order**:
   - `POST http://localhost:8082/api/orders`
   - Body (JSON):
     ```json
     {
         "menuId": 1,
         "status": "pending"
     }
     ```

### Verify Microservice Communication:
- Place an order using the Orders Service.
- Ensure that the Order Service communicates with the Menu Service to check food item availability.
- If the order is successful:
  - The food item's quantity should decrease (if implemented).
  - The order is saved in the Orders Service database.

### Stop Services:
- Stop the applications in your IDE after testing.
- Shut down the Eureka Server.
---

## Technologies Used
- **Backend**: Spring Boot, Hibernate, MySQL
- **Other Tools**: Node.js, Maven, Spring Cloud Feign, Postman, IntelliJ IDEA

---

## Acknowledgments
- Inspired by various restaurant management and food delivery systems.
- Special thanks to all open-source resources and the community for their support.



