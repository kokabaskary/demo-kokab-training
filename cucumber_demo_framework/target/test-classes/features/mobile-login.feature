@mobile-regression @mobile-login @mobile
Feature: Mobile Login Feature

  @mobile-login-1
  Scenario: Verify invalid login in mobile
    Given I am on mobile login page
    When I sign in using username mohammad@technosoftacademy.io and password Test12345 in mobile app
    Then I verify  no longer support signing with this version error message on mobile app