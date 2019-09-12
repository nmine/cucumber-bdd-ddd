Feature:  Take order
  taking order of a person

  Scenario Outline: Taking order of a person
    Given  "<person_number>" person takes an order "<item_ordered>" item of value "<value_item_ordered>"
    When the waitress introduces the order in the system
    Then the system knows the order "<order_item_output>" items with value "<value_sales>"

    Examples:
      | person_number    | item_ordered               | value_item_ordered | order_item_output | value_sales   |
      | 1                | 1                          | 1                  |1                  | 1             |
      | 2                | 1                          | 1                  |2                  | 2             |
