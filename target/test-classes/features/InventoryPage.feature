Feature: Inventory feature

Scenario Outline: User add to cart and remove the single product from inventory page
Given user is on Inventory page when login from given sheetname "<SheetName>" and rownumber <RowNumber>
When user add to cart single product from given sheetname "<SheetName>" and rownumber <RowNumber>
Then user get the shopping cart badge number
And the badge number should be contain from given sheetname "<SheetName>" and rownumber <RowNumber>
When user remove the single product from given sheetname "<SheetName>" and rownumber <RowNumber>
Then the badge number should not display
Examples:
|SheetName|RowNumber|
|Inventory|0|

Scenario Outline: User add to cart and remove the multi products from inventory page
Given user is on Inventory page when login from given sheetname "<SheetName>" and rownumber <RowNumber>
When user add to cart multi products from given sheetname "<SheetName>" and rownumber <RowNumber>
Then user get the shopping cart badge number
And the badge number should be contain from given sheetname "<SheetName>" and rownumber <RowNumber>
When user remove the multi products from given sheetname "<SheetName>" and rownumber <RowNumber>
Then the badge number should not display
Examples:
|SheetName|RowNumber|
|Inventory|1|

Scenario Outline: User add to cart and remove the product from product detail
Given user is on Inventory page when login from given sheetname "<SheetName>" and rownumber <RowNumber>
When user go to product detail from given sheetname "<SheetName>" and rownumber <RowNumber>
And user add to cart from product detail
Then user get the shopping cart badge number
And the badge number should be contain from given sheetname "<SheetName>" and rownumber <RowNumber>
When user remove the single product
Then the badge number should not display
Examples:
|SheetName|RowNumber|
|Inventory|0|
