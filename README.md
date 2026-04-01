# HOTEL_BOOKING
Room management module
## 📌 Overview

This module is part of the Hotel Booking System and is responsible for managing rooms within hotels. It allows hotel managers to add, view, and delete rooms associated with specific hotels.

---

## 🚀 Features

* Add new rooms to a hotel
* View rooms by hotel
* Delete rooms
* Integration with Hotel module
* JWT-based authentication support

---

## 🏗️ Tech Stack

* **Frontend:** React (Vite)
* **Backend:** Spring Boot
* **Database:** MySQL
* **Authentication:** JWT

---

## 📂 Project Structure

```
room/
 ├── AddRoom.jsx
 ├── ManageRooms.jsx
 ├── roomService.js
```

---

## 🔗 API Endpoints

### ➕ Add Room

```
POST /api/rooms
```

### 📄 Get Rooms by Hotel

```
GET /api/rooms/hotel/{hotelId}
```

### ❌ Delete Room

```
DELETE /api/rooms/{id}
```

---

## 🔄 Flow

1. Manager logs in
2. Selects a hotel
3. Adds rooms to that hotel
4. Rooms are linked using `hotelId`
5. Rooms are used in booking system

---

## 🔐 Authentication

* JWT token is required for all room APIs
* Only **MANAGER** role can access room operations

---

## 🧪 Testing (Postman)

1. Login → get token
2. Add token in headers

   ```
   Authorization: Bearer <token>
   ```
3. Test APIs

---

## 🎯 Key Concept

* One Hotel → Many Rooms
* Each Room belongs to one Hotel

---

## 👨‍💻 Author

**Gokul C**
(Room Management Module Developer)

---

## 🏆 Conclusion

The Room Management module ensures efficient handling of room data and seamless integration with hotel and booking systems.

---
