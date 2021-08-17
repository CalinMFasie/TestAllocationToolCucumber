Feature: Add new Employee

  Scenario Outline: Open and run app
    Given User is logged in
    Then Add new Employee with Name as "<employeeName>" email as "<employeeEmail>"

    Examples:
      |employeeName|employeeEmail|
      |Calin Marcel|calin@marcel.ro|
    |Paul Georgescu|paul@georgescu.ro|
    |John Black    |john@black.com   |
