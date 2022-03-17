# Project 1 - Book Review Back End

## Project Description
My second project assigned for my software development training. For this project I decided to create the backend code for a book review web service. 

## Technologies Used
- Maven (dependency management)
- Microsoft Azure (database and virtual machine)
- JDBC (database connection)
- Spring

## Features
- Multiple ways to filter data: Getting all books in the database, getting books by author, getting reviews by book title, etc.
- Posting new books and reviews to the database
- Updating existing book and review information while keeping any unchanged fields the same
- Removing data from teh database

## Getting Started
1. Using Git Bash, traverse to the location where you want to clone this repository.
2. Use the command: "git clone https://github.com/tylerdan/project1-Book-Reviews.git" (no " symbols included) to clone this repository to your machine.
3. Follow below "Usage" instructions for interacting with the stored data.

## Usage
1. Once code has been downloaded, use a tool of your choice to run the code. It can also be run through a command line tool using "mvn spring-boot:run".
2. Once the application is running, you can use one of the following to access the data in the database: web browser page linking to port 9000 ("localhost:9000" where a URL would go), an application such as Postman, forwarding requests to localhost:9000, or from the command prompt / terminal using "curl localhost:9000".
3. Use the various mappings to view, update, delete stored data.
