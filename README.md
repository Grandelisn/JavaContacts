# JavaContacts
Personal Challenge to create a backend API to manage contacts with Spring Boot

I chose to use an H2 database so there is no setup required, however there is an example of a toggle that would allow the service to be run on a PostgreSQL database. See applications.properties and DataSourceConfig
Taking time into account, I left out more robust validation, exception handling, and unit tests. However there are examples of each of those throughout the service.

To most easily run the application open the project in Intellij and hit the run command



<img width="423" alt="Screen Shot 2021-06-22 at 11 48 08 PM" src="https://user-images.githubusercontent.com/71465617/123032811-a2924100-d3b4-11eb-8809-225f358b2cd4.png">



Also if you have both maven and java downloaded and the proper env variables set you go to the root of the project and run
  mvn exec:java -Dexec.mainClass=com.example.javacontacts.JavaContactsApplication
  
For documentation there is a HTML page located in swagger/html-client
  Open for swagger api documentation
For a GUI version of the documentation navigate to https://editor.swagger.io/ clear the editor and copy the contents of editorSwagger.yaml into the editor
