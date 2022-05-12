Feature: Check login error message with invalid credentials

  @ui
  Scenario Outline: Error message on empty username field login
    Given I open Login Page
    Then I see Login Page
    When I switch to <language> language
    And I enter "<username>" username
    And I enter "<password>" password
    And I click on login button on Login Page
    Then I see "<errorMessage>" error message

    Examples:
      | language | username            | password        | errorMessage                                                          |
      | ru       |                     | PvECV7tr65Zsy3c | Не найден введённый адрес E-Mail и/или пароль указан неправильно.     |
      | ru       | s.mcsymiv@gmail.com | testpassword    | Не найден введённый адрес E-Mail и/или пароль указан неправильно.     |
      | ua       | s.mcsymiv@gmail.com |                 | Не вдалося знайти введену E-Mail адресу / або пароль вказано невірно. |
      | ua       | s.mc@gmail.com      | PvECV7tr65Zsy3c | Не вдалося знайти введену E-Mail адресу / або пароль вказано невірно. |

    