
# Splitwise Machine Coding Problem – Design Document

## 🎯 Objective

Build a console-based version of **Splitwise**, a tool that helps people split expenses and track who owes whom. The system should handle different types of expense splits and display the balance between users.

---

## 📚 Functional Requirements

### 1. Add Expense

Allows a user to add an expense they paid on behalf of others.

#### ✅ Inputs:

- `PaidBy` – User who paid the expense.
- `Amount` – Total amount of the expense.
- `Users` – List of users to split the amount with.
- `SplitType` – One of the following:
    - `EQUAL` – Split amount equally.
    - `EXACT` – Split amount by exact values.
    - `PERCENT` – Split amount by percentages.

#### ✅ Command Format:

```
EXPENSE <PaidBy> <Amount> <NumUsers> <User1> <User2> ... <SplitType> <SplitValues...>
```

#### ✅ Examples:

```
EXPENSE User1 1000 4 User2 User3 User4 User1 EQUAL
EXPENSE User1 1250 2 User2 User3 EXACT 370 880
EXPENSE User4 1200 3 User1 User2 User3 PERCENT 40 20 40
```

---

### 2. Show All Balances

Displays all non-zero balances in the system.

#### ✅ Command Format:

```
SHOW
```

#### ✅ Output Example:

```
User2 owes User1: ₹250
User3 owes User1: ₹500
User3 owes User4: ₹480
```

---

### 3. Show Balance for a Specific User

Displays balances involving a particular user.

#### ✅ Command Format:

```
SHOW <UserId>
```

#### ✅ Output Example:

```
User2 owes User1: ₹250
User2 owes User4: ₹100
```

---

```

---

## 🧠 Business Rules

- All balances are **net balances**.
    - If A owes B ₹100 and B owes A ₹50 → Final: A owes B ₹50.
- Round balances to **2 decimal places**.
- Ensure sum of split amounts or percentages equals total amount or 100% respectively.
- Do **not double-print** reverse relationships.

---

## 🛠️ Sample Input & Output

### Input:

```
EXPENSE User1 1000 4 User1 User2 User3 User4 EQUAL
SHOW
EXPENSE User1 1250 2 User2 User3 EXACT 370 880
EXPENSE User4 1200 3 User1 User2 User3 PERCENT 40 20 40
SHOW User3
SHOW
```

### Output:

```
User2 owes User1: ₹250.00
User3 owes User1: ₹250.00
User4 owes User1: ₹250.00

User3 owes User1: ₹880.00
User3 owes User4: ₹480.00

User2 owes User1: ₹620.00
User3 owes User1: ₹1130.00
User4 owes User1: ₹250.00
User2 owes User4: ₹240.00
User3 owes User4: ₹480.00
```

---

## 📌 Optional Features (If Time Permits)

- Add support for **Groups** (group expenses).
- Add support for **Expense Categories**.
- Handle **currency conversions**.
- Export/import balances to a **CSV file**.
- Add **command-line interaction loop** or **menu-based UI**.

---

## 🚫 Constraints

- User IDs are **unique strings** (e.g., `User1`, `User2`).
- The sum of exact splits must match the total amount.
- The sum of percent splits must equal 100.
- Balances are calculated at the **time of adding expense**.
- The system should be **case-sensitive**.

---

## ✅ Goals

- Write clean, modular, extensible code.
- Use good object-oriented principles.
- Minimize duplication of logic.
- Easy to add new split strategies in future.

---

## 🚀 Extension Ideas (for Interviews or Real-world Use)

- Notification service when balances exceed limits.
- Expense audit history per user.
- Group settlement feature.
- Friend requests and user relationships.
