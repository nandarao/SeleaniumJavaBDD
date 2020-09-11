Feature: login Test 

Background: Resuable code
	Given Launch the "FF" browser 
	When open login page with URL : "https://admin-demo.nopcommerce.com/" 


@smokeTest 
Scenario: Test login page header 
	Then verify login page header 
	And Close browser 
	
@RegetionTest 
Scenario: Test Login page with credentials 
	And Enter UserID and Password as "admin@yourstore.com"  "admin" 
	And Click Login Button 
	Then Page title should be "Dashboard / nopCommerce administration" 
	When Click on Logout link 
	Then Page title should be "Your store. Login" 
	And Close browser 
	
Scenario: Checking with star 
	* User Enter UserID and Password as "admin@yourstore.com"  "admin" 
	* User Click Login Button 
	* Match Page title with "Dashboard / nopCommerce administration" 
	* User Click on Logout link 
	* Match Page title with "Your store. Login" 
	* User Close browser

@RegetionTest 
Scenario Outline: Test Login page with data driven with scenario outline credentials 
	And Enter UserID and Password as "<UserID>"  "<Password>" 
	And Click Login Button 
	Then Page title should be "Dashboard / nopCommerce administration" 
	When Click on Logout link 
	Then Page title should be "Your store. Login" 
	And Close browser 
	Examples: 
		|UserID|Password|
		|admin@yourstore.com|admin|
		|admin@yourstore.com|admin|
		
Scenario: Test Login page with data tables credentials 
	Given Launch the browser 
		|FF|
	When open login page with URL : "https://admin-demo.nopcommerce.com/" 
	And Enter UserID and Password 
		|admin@yourstore.com|admin|
	And Click Login Button 
	Then Page title should be "Dashboard / nopCommerce administration" 
	When Click on Logout link 
	Then Page title should be "Your store. Login" 
	And Close browser 
	
@EndToEnd 
Scenario: Test Login page with data tables with list map credentials 
	Given Launch the browser of 
		|BrowserType|URL|UserID|Password|HomeTitle|LoginTitle| 
		|FF|https://admin-demo.nopcommerce.com/|admin@yourstore.com|admin|Dashboard / nopCommerce administration|Your store. Login|
		|CR|https://admin-demo.nopcommerce.com/|admin@yourstore.com|admin|Dashboard / nopCommerce administration|Your store. Login|
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	