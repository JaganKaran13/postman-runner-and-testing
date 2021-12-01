
# Postman Runner and Testing

## Description:
- Basic Spring boot application which runs the CRUD operations for Student Object.
- Creating a student with details and departmentId, and add them to the singleton list.

## Module Structure:
- app module holds the CRUD operation code.
- postman module holds the sample postman-collection to run and test the CRUD operations using postman and newman.

## Postman:
- Import the json inside the postman module to the postman.

## Newman:
### Prerequisite:
npm should be installed in the system.
https://www.npmjs.com/package/newman

### Run the following command
`newman run '.\Student Controller.postman_collection.json' -r cli`
