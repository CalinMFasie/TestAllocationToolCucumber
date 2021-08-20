Feature: Edit employees

  Scenario Outline: Edit employees

    And Edit Employee with Name as "<employeeName>" email as "<employeeEmail>" supervisor as "<supervisor>" workingHours as "<workingHours>" startDate as "<startDate>" endDate as "<endDate>"

    Examples:
      |employeeName |employeeEmail    |supervisor|workingHours|startDate |endDate   |
      |Modified User|modified@user.ro |CEO       |16          |08.01.2021|08.02.2021|