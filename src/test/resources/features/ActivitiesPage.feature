@activitiesPage
Feature: As a user, I should see error messages when I enter an
  invalid integer into the calendar repeat day input box.

  Scenario: : users see error messages for entering invalid integers.
    Given The user is on the DashboardPage
    When User hovers mouse over "Activities" tab and click "Calendar Events" module
    And User go to the "All - Calendar Events - Activities"
    And User click the Create Calender Event button
    And user navigate to Create Calender Event Page
    And user check the repeat check box
    And User enter the invalid data in repeat every box
    And user click the save and close button
    Then User should be able to see error message
