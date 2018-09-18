Feature: Add a pet to the store
  In order to sale a pet I would like
  to add a profile information to pet store web site
  and remove the profile when particular pet is sold

  @Test
  Scenario Outline: Add a pet profile to the store
#    Given The pet store "<website>" connection is available
    When I add the pet profile information with "<id>" to the "<website>"
    Then I am able to get the pet by "<id>"
    Examples:
      | website                           | id   |
      | http://petstore.swagger.io/v2/pet | 9876 |

  Scenario Outline: Remove a pet profile from the store
#    Given The pet store <website> connection is available
    When I remove the pet profile information with "<id>" from the "<website>"
    Then Pet with "<id>" is not found in "<website>"
    Examples:
      | website                           | id   |
      | http://petstore.swagger.io/v2/pet | 9876 |