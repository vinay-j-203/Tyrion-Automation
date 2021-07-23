Feature: Landing to homepage and login



Scenario Outline: user is on landing page
When user clicks on login button
And user enters username <Username> and pwd <Password>
And clicks on login button
Then navigate to home page
Then logout of the application

Examples:
|Username|Password|
|coddisabled@sharklasers.com|coddisabled@123|

