@mySearchAlerts
Feature: My Search Alerts Feature
	As a blinq.com site user
	I want to save my current searches as entries 
	So that when new items that match these searches are added
	I receive email alerts

@featureX
Scenario: Only logged in user can access save search feature
	Given I am a new user on blinq.com site
	When I perform a search for product "laptops"
	Then The CREATE ALLERT button is not available
	
	When I login using valid credentials
	And I perform a search for product "laptops" 
	Then The CREATE ALLERT button is available
	And Clicking it will display the Create New Search Alert modal for "laptops"
	
Scenario: Create New Search Alert with default options
	Given I am a new user on blinq.com site
	When I login using valid credentials
	And I perform a search for product "laptops" 
	When Create New Search Alert workflow is launched
	Then Create New Search Alert modal is displayed with following editable mappings:
      | name                | value                   | 
      | title               | Create New Search Alert | 
      | allert name         | laptops                 |
      | frequency day       | selected                |
      | frequency week      | notselected             |
      | frequency noemails  | notselected             |
     
     When User save the Search Alert
     Then Search Alert Saved message is displayed
     And Manage My Search Alerts page contains "laptops" in saved-search-list
     
	
Scenario: Create New Search - cancel workflow 
	Given I am a new user on blinq.com site
	When I login using valid credentials
	And I perform a search for product "laptops" 
	When Create New Search Alert workflow is launched
	Then User can cancel the Create New Search Alert
	And Return to previous state
	
Scenario: New Search Alert - modify frequency
	Given Manage My Search Alerts page contains "laptops" in saved-search-list
	When User select the "Weekly" frequency
	Then "laptops" Search Alert is updated

Scenario: New Search Alert - rename
	Given Manage My Search Alerts page contains "laptops" in saved-search-list
	When User rename "laptops" into "new laptops"
	Then "laptops" Search Alert is updated
	
Scenario: New Search Alert - delete
	Given Manage My Search Alerts page contains "laptops" in saved-search-list
	When I click the delete icon for "laptops" Search Alert
	Then "laptops" Search Alert is marked as deleted
	And UNDO DELETE button is available
	
	When User logout
	And User login 
	Then Manage My Search Alerts page does not contains "laptops" in saved-search-list

@end-to-end @long 
Scenario:
Create New Search Alert and validate user receives email once new item(s) matching search criteria are added in stock 
	Given mockserver is setup for e2e alert validation test 
	And New Search Alert modal is created with following editable mappings: 
		| name                | value                     | 
		| title               | e2e alert validation test | 
		| allert name         | e2e alert validation test |
		| frequency day       | selected                  |
		
	When Insert test product for e2e alert validation test 
	Then Validate mockserver received content email for e2e alert validation test 
	
