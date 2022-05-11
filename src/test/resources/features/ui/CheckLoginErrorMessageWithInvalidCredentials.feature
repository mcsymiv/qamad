Feature: Check login error message with invalid credentials

  Scenario Outline: Error message on empty username field login
    Given I open Login Page
    Then I see Login Page
    When I switch to <language> language
    And I enter "" username
    And I enter "PvECV7tr65Zsy3c" password
    And I click on login button on Login Page
    Then I see "<errorMessage>" error message

    Examples:
      | language | errorMessage                                                          |
      | ru       | Не найден введённый адрес E-Mail и/или пароль указан неправильно.     |
      | ua       | Не вдалося знайти введену E-Mail адресу / або пароль вказано невірно. |
    