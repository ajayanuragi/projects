# WhatToBuild

WhatToBuild is a simple backend project that allows users to share and like creative ideas. Users can explore a list of ideas, create new ones, and express their appreciation by liking the ideas they find interesting. The project aims to inspire and connect users through a collaborative platform for idea sharing.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Adding an Idea](#adding-an-idea)
  - [Retrieving All Ideas](#retrieving-all-ideas)
  - [Liking an Idea](#liking-an-idea)
- [Built With](#built-with)


## Features

- **Explore Ideas:** Browse through a curated list of creative ideas contributed by the community.
- **Like Ideas:** Express your approval by liking ideas that resonate with you. Remember, you can like an idea only once!
- **Share Your Ideas:** Contribute to the community by sharing your own creative ideas.
- **Simplified Backend:** Built with Spring Boot, the backend provides a straightforward API for managing ideas and likes.

## Getting Started

### Prerequisites

Make sure you have the following tools installed:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ajayanuragi/whatToBuild.git

2. Navigate to the project directory:

   ```bash
   cd WhatToBuild

3. Build and run the application:
    
   ```bash
   ./mvnw spring-boot:run

The application will be accessible at http://localhost:8080.

#### Note: Change db-url to your url for mongoDB database in application.yml file.

## Usage
### Adding an Idea

To add an idea to the system, follow these steps:

1. **Open Postman**: Ensure you have Postman installed on your machine.

2. **Select Request Method as POST**: In Postman, create a new request and set the request method to POST.

3. **Enter URL**: Set the URL to http://localhost:8080/api/idea.

4. **Set Headers**:
   - In the Headers section, add the `Content-Type` header with the value `application/json`.

5. **Configure Request Body**:
   - Go to the Body tab.
   - Select `raw`.
   - Choose `JSON (application/json)` from the dropdown.

6. **Enter Idea JSON**:
   - In the request body, enter your idea in JSON format. For example:
     ```json
     {
         "title": "Second Idea",
         "description": "Whatever is this idea."
     }
     ```

7. **Send Request**:
   - Click the "Send" button in Postman to make the POST request.

### Retrieving All Ideas

To retrieve all ideas from the system, send a GET request:

1. **Open Postman**: Create a new request and set the request method to GET.

2. **Enter URL**: Set the URL to http://localhost:8080/api/ideas.

3. **Send Request**:
   - Click the "Send" button in Postman to make the GET request.


### Liking an Idea

To like an idea, send a POST request with the user ID in the headers:

1. **Open Postman**: Create a new request and set the request method to POST.

2. **Enter URL**: Set the URL to http://localhost:8080/api/1/like, where `1` is the idea ID.

3. **Set Headers**:
   - Add the `Content-Type` header with the value `application/json`.
   - Add the `user-id` header with the user ID.
   - Note(user ID could be anything, Planning to ask this from client in future)

4. **Send Request**:
   - Click the "Send" button in Postman to make the POST request.

# Built With

This project was built using the following tools and technologies:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html): Programming language used for the backend.
- [Spring Boot](https://spring.io/projects/spring-boot): Framework for building Java-based applications.
- [Maven](https://maven.apache.org/): Build tool for managing dependencies and building the project.
- [Postman](https://www.postman.com/): API development and testing tool used for interacting with the backend API.
- [MongoDB](https://www.mongodb.com/): NoSQL database used for data storage.

Feel free to explore the links to learn more about each tool.
  
   
