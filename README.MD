#### Project Setup
- clone the project
- pre installed MySQL
- change application.properties according requirment
- build the project and generate war file then deploy it in tomcat

#### API Info

- to login : 
> /dologin, method : POST, body : {"userName":"","password":""}

- to create a new user :
> /createuser, method : POST, body : { "username":"", "password":"", "firstname":"", "lastname":"", "email":"", "address":"", "phone":""} 

- to assign a module :
> /assignmodule, method : POST, body : { "userid":"", "moduleid":""}

- to update user : 
> /updateuser, method : PUT, body : { "userid" : "", "password" : "", "firstname" : "", "lastname" : "", "email" : "", "address" : "", "phone" : "" }

- to delete a user :
> /deleteuser, method : DELETE, String value, example : /deleteuser/1 

