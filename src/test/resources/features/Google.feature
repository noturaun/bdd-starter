@Google
  Feature: Google search test
    This feature file intended to test Google search engine features
  Background: User ready to search
    Given User already on Google search page

    @Search
    Scenario Outline: As a user I want to be able to search for a certain keyword
      When '<actor>' enters the '<keyword>'
      Then s?he should be redirected to the result page for that '<keyword>' or '<alt>'
      Examples:
        | actor | keyword | alt   |
        | John  | Whale   | whale |