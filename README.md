# CSV Data Management with Spring Boot

This project provides a Spring Boot application that allows you to:
- **Read data from a CSV file**.
- **Upload CSV file data** into a database.
- **Delete the data** from the database.

These functionalities are exposed through **REST APIs**.

## Features

- **Read CSV File**: Parse a CSV file and extract its content.
- **Upload CSV Data**: Upload data from a CSV file to the database via a REST API.
- **Delete Data**: Delete data from the database via a REST API.

## Technologies Used

- **Spring Boot** for building the RESTful web service.
- **Spring Data JPA** for database interaction.
- **H2 Database** (or any preferred database) for storing data.
- **Jackson** for JSON processing.
- **Commons CSV** (or similar library) for reading CSV files.

## Endpoints

### 1. Upload CSV File

**POST /api/csv/upload**

Upload a CSV file and save its data to the database.

**Request:**

- **Content-Type**: `multipart/form-data`
- **Body**: Form data containing the CSV file.

**Example:**

```bash
curl -X POST -F "file=@path/to/your/file.csv" http://localhost:8080/api/csv/upload
```

**Response:**
- HTTP Status 200: File uploaded and data saved successfully.
- HTTP Status 400: Invalid file format or error during upload.

### 2. Read Data from CSV (CSV Parsing Example)

**GET /api/csv/read**

This endpoint returns a sample of the CSV data as JSON.

**Response:**
- HTTP Status 200: JSON representation of the CSV data.

### 3. Delete Data

**DELETE /api/csv/delete/{id}**

Deletes a specific entry from the database by its ID.

**Request:**

- **Path Parameter**: `id` - ID of the data entry to delete.

**Example:**

```bash
curl -X DELETE http://localhost:8080/api/csv/delete/1
```

**Response:**
- HTTP Status 200: Data deleted successfully.
- HTTP Status 404: Data not found with the given ID.

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/csv-data-management.git
cd csv-data-management
```

### 2. Build the Project

Make sure you have **Maven** or **Gradle** installed.

- Using Maven:
  
```bash
./mvnw clean install
```

- Using Gradle:
  
```bash
./gradlew build
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

Or, if using Gradle:

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`.
.hibernate.ddl-auto=update
```

## CSV File Format

Ensure that your CSV file follows the correct structure. For example, a simple CSV file could look like this:

```csv
source,codeListCode,code,displayValue,longDescription,fromDate,toDate,sortingPriority
source1,code1,value1,Display 1,Description 1,01-01-19,01-01-20,1
source2,code2,value2,Display 2,Description 2,02-01-19,02-01-20,2
```

The application assumes that the CSV file will contain these columns, and each row represents an entry.

## Testing

You can use tools like **Postman** or **cURL** to test the APIs. For example, use **Postman** to send the file upload request or to call the GET and DELETE endpoints.

### Example using Postman:
1. Set the method to `POST`.
2. Use `multipart/form-data` as the body type.
3. Select the CSV file to upload.
4. Click Send.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
