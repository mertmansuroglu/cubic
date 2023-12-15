Feature: Cubic Test Automation Exercise

  Background: Goto home and Login Page
    Given  goto  Home Page
    When  go to login page
    Then verify login page and see page header as "AUTHENTICATION"

  Scenario: Successful Login
    When enter username and password as "mertmansurolu@gmail.com" and "12345"
    Then verify Succes login message as "Welcome to your account"

  Scenario: Unsuccessful Login with wrong password
    When enter username and password as "mertmansurolu@gmail.com" and "password"
    Then verify error Message   as "Authentication failed"

  Scenario: Unsuccessful Login with wrong username
    When enter username and password as "test" and "password"
    Then verify error Message   as "Invalid email address"