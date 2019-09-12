Feature:  Notifying Kitchen
  Notifying Kitchen

  Scenario Outline: Notifying Kitchen
    Given waitress take an order "<item_number>" item of value "<item_value>"
    When the waitress introduces the order introduced in the system
    Then the Cooker is notified of the order "<item_number>" item

    Examples:
      | item_number    | item_value    |
      | 1              | 1             |
      | 2              | 1             |
