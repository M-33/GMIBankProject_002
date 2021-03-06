@US01
Feature:  System should allow any user to register with valid credentials validating the success message

  @US01TC01
  Scenario Outline: There should be a valid SSN respecting the "-" where necessary, it should be 9 digits long
    Given Go to gmibank.com home page us01
    And Click to User Account menu and Click to Register
    And Enter the SSN "<SSN Number>" with valid credential
    And Click on first name box
    Then There should be a valid SSN respecting

    Examples: Test data for SSN
      |SSN Number|
      |111-11-1111|
      |111-11-9999|
      |111-99-9999|
      |999-99-9999|
      |999-99-1111|
      |999-11-1111|
      |456-25-1634|
  @US01TC02
  Scenario Outline: There should be a valid name that contains chars and cannot be blank
    And Enter the name "<First Name>" with valid credential
    And click on last name box
    Then There should be a valid name respecting
    Examples:
      |First Name|
      |A            |
      |AbcdefghijklmnoqprstuvwyzAbcdefghijklmnoqprstuvwyz|
      |John         |


  @US01TC03
  Scenario Outline: There should be a valid last name that contains chars and cannot be blank
    And Enter the last name "<Last Name>" with valid credential
    And click on Address box
    Then There should be a valid last name respecting
    Examples:
      |Last Name|
      |AbcdefghijklmnoqprstuvwyzAbcdefghijklmnoqprstuvwyz|
      |A            |
      |Smith        |

  @US01TC04
  Scenario: We can provide chars and digits to describe a valid address along with zip code
    And Enter the Address
    And click on mobile phone number box
    Then There should be a valid address respecting

  @US01TC05
  Scenario Outline: User should provide 10 digit-long mobilephone number as a required field respecting the "-"
    And Enter the GSM "<Mobile Phone Number>" with valid credential
    And click on username box
    Then There should be a valid mobile phone number respecting
    Examples:
      |Mobile Phone Number|
      |000-111-1111|
      |111-000-0000|
      |999-999-9999|
      |000-000-0000|
      |999-000-1111|
      |000-999-1111|
      |567-891-1234|

  @US01TC06
  Scenario Outline: User cannot use just digits for username, but can use any chars and digits along with them and of any length
    And Enter the valid username "<username>" with valid credentail
    And click on email box
    Then There should be a valid username respecting
    Examples:
      |username|
      |g|
      |a1|
      |globaluseruser|
      |globaluser0101|

  @US01TC07
  Scenario Outline: We should provide a valid email format that contains "@", ".com" extensions
    And Enter the e-mail "<email>" with valid credential
    And click on new password box
    Then There should be a valid email respecting
    Examples:
      |email|
      |a@gmail.com               |
      |a@b.com                   |
      |globaluser010101@gmail.com|

  @US01TC08
  Scenario Outline:  Password is required to be at least 4 characters
    And Enter the new "<password>" with valid credential
    And click on new password confirmation box
    Then There should be a valid password respecting

    Examples:
      |password|
      |1111    |
      |1234@!.Abc ;.|


  @US01TC09
  Scenario: Password confirmation entry should be same with password
    And Enter the same password with valid credential "1234@!.Abc ;."
    And click on new password box02
    Then entry should be same with password


  @US01TC10
  Scenario:  System should allow any user to register with valid credentials validating the success message
    And Click to Register button
    Then There should be Succes message.