Feature: Add new project

  Scenario Outline: Add new project

    Then Add new project with Name as "<projectName>" client as "<client>" startDate as "<startDate>" endDate as "<endDate>" description as "<description>"

    Then User is logged out

    Examples:
      |projectName    |client |startDate  |endDate    |description      |
      |AutonomousLogan|Dacia  |08.01.2021 |08.02.2021 |Logan autonomous |