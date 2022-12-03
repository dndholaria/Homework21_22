Feature: Category
@cat
Scenario Outline: As a user, I should able to navigate to each category page successfully

  When I click on "<category_page>" link
  Then I should able to navigate to "<category_link>" page successfully

  Examples:
  |category_page| category_link|
  |Computers    |computers     |
  |Electronics| electronics    |
