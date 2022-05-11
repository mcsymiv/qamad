Feature: Check successful login

  @ui
  Scenario: Successfully login to the platform
    Given I open Login Page
    Then I see Login Page
    And I enter "s.mcsymiv@gmail.com" username
    And I enter "PvECV7tr65Zsy3c" password
    And I click on login button on Login Page
    Then I see Main Page