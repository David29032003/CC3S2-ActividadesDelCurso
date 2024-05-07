# new feature
# Tags: optional

Feature: BellyFeature

  Scenario: Comí muchos pasteles y gruñí.
    Given I have eaten 22 cukes
    When I wait 3 hour
    Then my belly should growl

  Scenario: Comí algunos pasteles y  no gruñí.
    Given I have eaten 5 cukes
    When I wait 2 hour
    Then my belly should not growl

  Scenario: No Comí pasteles y no gruñí.
    Given I have eaten 0 cukes
    When I wait 1 hour
    Then my belly should not growl

  Scenario: Comí 10 pasteles y  no gruñí.
    Given I have eaten 10 cukes
    When I wait 2 hour
    Then my belly should not growl

  Scenario: Comí muchos pasteles y gruñí después de esperar.
    Given I have eaten 30 cukes
    When I wait 5 hour
    Then my belly should growl

  Scenario: Comí unos cuantos pasteles y no gruñí después de esperar.
    Given I have eaten 3 cukes
    When I wait 1 hour
    Then my belly should not growl

  Scenario: Comí 15 pasteles y no gruñí.
    Given I have eaten 15 cukes
    When I wait 1 hour
    Then my belly should not growl

  Scenario: Comí 50 pasteles y gruñí despues de esperar.
    Given I have eaten 50 cukes
    When I wait 8 hour
    Then my belly should growl

