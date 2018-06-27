# For API document please refer FriendConnection-Swagger UI.htm. 
# To run the API go inside the target directory of the code and execute below command. 
# java -jar FriendConnection-0.0.1-SNAPSHOT.jar (Maven needs be installed in the system)
# URL to hit http://localhost:8080 (URI mentioned in FriendConnection-Swagger UI.htm)
# Below are the JSON input to run the API 

API1 Input :
{
"friends": [ "andy@example.com","john@example.com" ] }

API2 Input :
{ "email":"andy@example.com" }

API3 Input :
{
"friends": [ "andy@example.com","john@example.com" ] }

API4 Input :
{
"requestor" : "lisa@example.com", "target" : "john@example.com"
}

API5 Input :
{
"requestor" : "lisa@example.com", "target" : "john@example.com"
}
