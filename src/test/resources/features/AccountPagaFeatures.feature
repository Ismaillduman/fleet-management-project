@smoke
Feature: As a user, I want to filter customers’ info on the Account page

  Scenario: Users should see 8 filter items on the Accounts page
    Given The user is on the DashboardPage
    When User hovers mouse over "Customers" tab and click "Accounts" module
    And User go to the "All - Accounts - Customers"
    Then User should be able to see  below eight filter items on the Accounts page

      | Account Name  |
      | Contact Name  |
      | Contact Email |
      | Contact Phone |
      | Owner         |
      | Business Unit |
      | Created At    |
      | Updated At     |
@dashboard @smoke
    Scenario:  Drivers should NOT able to access the Vehicle contracts
    page, the app should display
      Given The user is on the DashboardPages
      When User hovers mouse over "Fleet" tab and click "Vehicles Model" module
      Then User see error message