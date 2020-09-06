Feature: login Test

Scenario: Test login page header
Given launch the browser
When Open login page with URL 
Then verify login page header
And Close browser 

Scenario: Test Login page with credentials 
Given Launch the "FF" browser
When open login page with URL : "https://admin-demo.nopcommerce.com/"
And Enter UserID and Password as "admin@yourstore.com",  "admin"
And Click Login Button
Then Page title should be "Dashboard / nopCommerce administration"
When Click on Logout link
Then Page title should be "Your store. Login"
And Close browser