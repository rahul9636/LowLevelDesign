# State Machine for Vending Machine

| Current State           | Operation           | Next State                         |
|-------------------------|---------------------|------------------------------------|
| Ideal State             | Insert Money        | Money Addition State               |
| Money Addition State    | Insert More Money   | Money Addition State               |
|                         | Product Selection   | Product Selection State            |
|                         | Cancel              | Ideal State                        |
| Product Selection State | Cancel              | Refund and Ideal State             |
|                         | Select Product      | Product Selection State            |
|                         | Dispensing Product  | Dispense State                     |
| Dispense State          | Dispensing          | Refund Extra Money and Ideal State |
