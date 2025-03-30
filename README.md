# Authors and Books API

This document outlines the RESTful API for managing authors and their books, hosted at `http://localhost:8080`. It supports CRUD operations for authors and books.

## Base URL
```
http://localhost:8080
```

## Author Endpoints

### Get All Authors
- **Method**: `GET`
- **Path**: `/api/v1/authors`
- **Operation ID**: `getAllAuthor`
- **Description**: Retrieves a list of all authors.
- **Response Format**:
  ```json
  [
    {
      "name": "Jane Austen",
      "birthdate": "1775-12-16"
    },
    {
      "name": "Mark Twain",
      "birthdate": "1835-11-30"
    }
  ]
  ```

### Create an Author
- **Method**: `POST`
- **Path**: `/api/v1/authors`
- **Operation ID**: `createAuthor`
- **Description**: Creates a new author.
- **Request Body**: Author data (required)
- **Response Format**:
  ```json
  {
    "name": "Jane Austen",
    "birthdate": "1775-12-16"
  }
  ```

### Get Author by ID
- **Method**: `GET`
- **Path**: `/api/v1/authors/{id}`
- **Operation ID**: `getAuthorById`
- **Parameters**: 
  - `id` (path, required): Integer (int64), the author’s ID.
- **Response Format**:
  ```json
  {
    "name": "Jane Austen",
    "birthdate": "1775-12-16"
  }
  ```

### Update Author
- **Method**: `PUT`
- **Path**: `/api/v1/authors/{id}`
- **Operation ID**: `updateAuthor`
- **Parameters**: 
  - `id` (path, required): Integer (int64), the author’s ID.
- **Request Body**: Author data (required)
- **Response Format**:
  ```json
  {
    "name": "Jane Austen",
    "birthdate": "1775-12-16"
  }
  ```

### Delete Author
- **Method**: `DELETE`
- **Path**: `/api/v1/authors/{id}`
- **Operation ID**: `deleteAuthor`
- **Parameters**: 
  - `id` (path, required): Integer (int64), the author’s ID.
- **Response Format**: No content (empty response body).

## Book Endpoints

### Get All Books by Author
- **Method**: `GET`
- **Path**: `/api/v1/authors/{authorId}/books`
- **Operation ID**: `getAllBooks`
- **Parameters**: 
  - `authorId` (path, required): Integer (int64), the author’s ID.
- **Response Format**:
  ```json
  [
    {
      "title": "Pride and Prejudice",
      "publishedDate": "1813-01-28"
    },
    {
      "title": "Sense and Sensibility",
      "publishedDate": "1811-10-30"
    }
  ]
  ```

### Create a Book for an Author
- **Method**: `POST`
- **Path**: `/api/v1/authors/{authorId}/books`
- **Operation ID**: `createBook`
- **Parameters**: 
  - `authorId` (path, required): Integer (int64), the author’s ID.
- **Request Body**: Book data (required)
- **Response Format**:
  ```json
  {
    "title": "Pride and Prejudice",
    "publishedDate": "1813-01-28"
  }
  ```

### Get Book by ID
- **Method**: `GET`
- **Path**: `/api/v1/authors/{authorId}/books/{bookId}`
- **Operation ID**: `getBookById`
- **Parameters**: 
  - `authorId` (path, required): Integer (int64), the author’s ID.
  - `bookId` (path, required): Integer (int64), the book’s ID.
- **Response Format**:
  ```json
  {
    "title": "Pride and Prejudice",
    "publishedDate": "1813-01-28"
  }
  ```

### Update Book
- **Method**: `PUT`
- **Path**: `/api/v1/authors/{authorId}/books/{bookId}`
- **Operation ID**: `updateBook`
- **Parameters**: 
  - `authorId` (path, required): Integer (int64), the author’s ID.
  - `bookId` (path, required): Integer (int64), the book’s ID.
- **Request Body**: Book data (required)
- **Response Format**:
  ```json
  {
    "title": "Pride and Prejudice",
    "publishedDate": "1813-01-28"
  }
  ```

### Delete Book
- **Method**: `DELETE`
- **Path**: `/api/v1/authors/{authorId}/books/{bookId}`
- **Operation ID**: `deleteBook`
- **Parameters**: 
  - `authorId` (path, required): Integer (int64), the author’s ID.
  - `bookId` (path, required): Integer (int64), the book’s ID.
- **Response Format**: No content (empty response body).

## Data Models

### Author
- **Properties**:
  - `name` (string, required): The author’s name.
  - `birthdate` (string, format: date, required): The author’s birthdate (e.g., `YYYY-MM-DD`).

### Book
- **Properties**:
  - `title` (string, required): The book’s title.
  - `publishedDate` (string, format: date, required): The book’s publication date (e.g., `YYYY-MM-DD`).

## Usage Notes
- All endpoints return a `200 OK` status on success.
- Set the `Content-Type` header to `application/json` for `POST` and `PUT` requests.
- Path parameters must be valid 64-bit integers.

## Getting Started
1. Run the server at `http://localhost:8080`.
2. Test endpoints using tools like Postman or cURL.
3. Refer to the OpenAPI spec for additional details.

Contact the team for support or feedback.
