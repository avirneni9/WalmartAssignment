# WalmartAssignment
Walmart Ticket Service Homework

Assumptions: 

1.	No seat number preference to the user. User doesn’t have facility to choose seat numbers because of high-demand, seats will be        hold based on the availability.
2.	Seats can’t be hold in multiple levels in a single transaction. Suppose if the user want 5 seats, 2 in Level-1 and 3 in Level-2.      This type of transaction can’t be performed. First 2 seats are to be hold in Level-1 and then 3 seats in Level-2 in two different      transactions.
3.	All the inputs are entered in console and outputs will be displayed in the same.
4.	Hold time can be set based on our requirement. It is set to 60 seconds in this application.
5.	Once hold is performed user need to save the hold Id to perform reserve operation.
6.	If user selected to exit, the transactions performed before this will be erased automatically.

System Requirements:

1.	Install Java JDK, create JAVA_HOME variable in environment variables and set the JDK location to JAVA_HOME.
2.	Install maven, create M2_HOME variable in environment variables and set the maven path to M2_HOME.

How to run:
1.	Download or Clone the project from the below Repository to your local environment.
    https://github.com/avirneni9/WalmartAssignment.git
2.	Open the Command prompt and point to the jar file folder WalmartAssignment/target/ and run the below command
    java -jar WalmartAssignment-0.0.1-SNAPSHOT-jar-with-dependencies.jar
3.	Now new menu will appear prompting to enter the user input, enter valid inputs and have a good one.

