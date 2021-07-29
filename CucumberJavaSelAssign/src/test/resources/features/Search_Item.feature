@Search_feature
Feature: Verifying the Search functionality

  @Serach_Scenario_1
  Scenario Outline: Validate the User Search is Successfull
    Given The Browser is launched
    Then Verify the url <searchURL> is launched
    And user enters <serachItem> for search
    And user clicks the submit button
    Then Validate the user is navigated to <expectedResult> search results
    Then Validate the user obtains first <returnedResult> from results

    Examples: 
      | searchURL          |  | serachItem     | expectedResult | returnedResult |
      | https://google.com |  | Term Insurance | Term Insurance | Term Insurance |
