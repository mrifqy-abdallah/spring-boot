# The Exam Instruction
Create a simple presence (class attendance) application with Restful API. There are at least 2 tables that are related to each other in the database. More complex is allowed, but pay attention to the time frame limitation for the exam. No need for outgoing attendance, in-going attendance only.

Default Endpoint (URL) scenario to create:

- **New student registration**: Enrolling new students accompanied by a username and password
  > Use POST method >> Request in the form of JSON containing username and password along with other details
- **Login**: Search for student's record based on username and password. If the username and password match and are in the database, return the response in the form of the student's details. Quite simple logic, no need to use OAuth2 or JWT (JSON Web Token). You can enter the password directly into the database, or you can also encrypt it (the important thing is there is a password in the system)
  > POST method >> The request is in the form of a JSON username and password
- **Incoming attendance**: Record the attendance of a student to the database based on his/her ID, plus the timestamp
  > POST or GET are both permitted
- **Attendance List**: Displays all the attendance records in the database
  > GET method

Apart from the information above, you may add other functions with your personal assumptions. Please make the detail of the database design with your own assumption.

## More information
- The package name represents [my-student-id-number].[my-name].uas
- [latihan_springboot_uas_db.sql](latihan_springboot_uas_db.sql) is the database of the system
- This project was made using IntelliJ 2020 IDE
- Take a look at [application.properties](k3517035.mrifqyabdallah.uas/src/main/resources/application.properties) to see the configuration of the web