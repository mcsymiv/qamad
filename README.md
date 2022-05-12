### qamad task
#### Site
    I choose to cover with tests "Wau Dog" [website]:https://waudog.ua/. It is a e-shop for pets and owners. 
    Recently I bought there leash, so this is basic reason behind my choice.  

***
### Test cases
ID: 1 

Type: functional, positive

Description: Successful login to the account page

Preconditions: user credentials - username=s.mcsymiv@gmail.com, password=PvECV7tr65Zsy3c

Steps: 
1. Open login page
2. Enter user username
3. Enter user password
4. Click on login button on Login Page

Expected: User is on the account page, can see orders, history address, password. links.
     
---
ID: 2

Type: functional, negative

Description: Check login error message with invalid credentials

Preconditions: test data
     
| username            | password        |
| --------------------|:---------------:|
| -                   | PvECV7tr65Zsy3c |
| s.mcsymiv@gmail.com | -               |
| s.m@gmail.com       | PvECV7tr65Zsy3c |
| s.mcsymiv@gmail.com | testpassword    |
     
Steps:
1. Open login page
2. Enter username from _test data_
3. Enter password from _test data_
4. Click on login button on Login Page

Expected: Error message appears under navigation panel with message for __ua__ locale:
"Не вдалося знайти введену E-Mail адресу / або пароль вказано невірно." and
"Не найден введённый адрес E-Mail и/или пароль указан неправильно." message for __ru__ locale.

---
ID: 3

Type: non-functional, ui

Description: Check if elements visible on Login page

Steps:
1. Open Login Page

Expected: __Password__ and __username__ inputs are present and visible on the Login page, 
along with __forgot password__ link, __login__ button and __title__.

***
### Bug report is under issues [link]:https://github.com/mcsymiv/qamad/issues
