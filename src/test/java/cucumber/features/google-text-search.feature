Feature: Google search

  Scenario Outline: user can search any keyword
    Given an open browser with google.com
    When a keyword <keyword> is entered in <keyword12> input field
    Then the first one should contain <expectedWord>
    And close browser

    Examples:
      | keyword | expectedWord | keyword12 |
      | karol   | karol        | 1     |
      | jacek   | jacek        | 2    |