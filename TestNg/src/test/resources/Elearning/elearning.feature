Feature: E-commerce application names as elearning
@signup
Scenario: Validate Registration with happy path
Given open the signup page using URL
When user should enter firstname as "<firstname>"
And user should enter lastname as "<lastname>"
And user should enter email as "<email>"
And user should enter username as "<username>"
And user should enter password as "<password>"
And click on register
Then Registration should be successful

Scenario: Validate compose email
Given validate the email entered
When user should click on homepage
And click on compose
And user should enter reciever email adress as "<reciever>"
And user should enter subject as "<subject>"
And user should enter message 
And user should clikc on sendmessage
Then message should be sent sucessfully


|firstname|lastname|email                    |username|password    |reciever|subject|
|Muneeswar   |Vollati |muneeswar12vollati@gmail.com|muneeswarv  |Welcome01 |muneeswar  |Hi testcase done|
