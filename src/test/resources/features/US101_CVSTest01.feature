@cvs
Feature: US101 CVS MinuteClinic test
  Background: User is on the CVS main page
    Given user is on the cvs page
  Scenario: TC01 Search MinuteClinic with valid credentials
    And user click visitMinuteClinic button
    When user enter valid "02478"
    Then : Verify results if clinics are less than 20 miles.


