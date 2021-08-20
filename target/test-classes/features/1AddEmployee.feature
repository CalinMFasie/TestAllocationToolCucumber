Feature: Add new Employee

  Scenario Outline: Open and run app
    Given User is logged in
    Then Add new Employee with Name as "<employeeName>" email as "<employeeEmail>" supervisor as "<supervisor>" workingHours as "<workingHours>" startDate as "<startDate>" endDate as "<endDate>"

    Examples:
      |employeeName|employeeEmail   |supervisor |workingHours |startDate |endDate   |
      |Calin Marcel|calin@marcel.ro |Manager    |8            |08.01.2021|08.02.2021|
      |John Black  |john@black.com  |Team leader|6            |08.02.2021|08.03.2021|
      |Jack Smith  |jack@smith.com  |Unit manager|4           |08.01.2021|08.02.2021|