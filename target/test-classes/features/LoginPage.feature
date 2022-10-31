Feature: Login feature

Scenario Outline: Login with correct credentials
Given user is on login page
When user fills the userName and password from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on Login button
Then user gets the current URL
And page URL should be contain "inventory"
Examples:
|SheetName|RowNumber|
|Login|0|
Scenario Outline: Login with invalid credentials
Given user is on login page
When user fills the userName and password from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on Login button
Then user gets the error message
And the error message should be contain from given sheetname "<SheetName>" and rownumber <RowNumber>
Examples:
|SheetName|RowNumber|
|Login|1|
|Login|2|
|Login|3|
|Login|4|