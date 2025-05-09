
# Interpreter Pattern – Java Example

This project demonstrates the **Interpreter** behavioral design pattern in Java. It defines a grammar for a mini-language and provides an interpreter to evaluate sentences in that language at runtime.

## 📌 Scenario

Suppose you want to determine if a user is eligible to receive a support ticket assignment based on their role and status. For example:

> `"admin AND active"`

This rule means: "Only assign the ticket if the user is both an admin and active."

## 🧠 How It Works (Your Thinking Preserved)

1. First, define **what** to check: the user's role and status.
2. Then, define **how** to combine those checks: using AND, OR, etc.
3. Finally, evaluate real data against these rules to decide if an action (like ticket assignment) should happen.

This is exactly what the Interpreter pattern does.

---

## 🧱 Class Structure

- `Expression`: Interface with `interpret(String context)` method.
- `TerminalExpression`: Checks for a keyword in the context string.
- `AndExpression` / `OrExpression`: Combine expressions using logical operators.
- `InterpreterExample`: Main class to simulate and test combinations.

---

## 🔧 Code Example

```java
Expression isAdmin = new TerminalExpression("admin");
Expression isActive = new TerminalExpression("active");

Expression isAdminAndActive = new AndExpression(isAdmin, isActive);
Expression isAdminOrActive = new OrExpression(isAdmin, isActive);

String user1 = "admin active";
String user2 = "admin";
String user3 = "guest inactive";

System.out.println(isAdminAndActive.interpret(user1)); // true
System.out.println(isAdminAndActive.interpret(user2)); // false
System.out.println(isAdminOrActive.interpret(user3));  // false
```

---

## 💡 Practical Example – Ticket Assignment Rule

Imagine you have a user record with fields like `role` and `status`.

```java
User u = new User("admin", "active");
String input = u.getRole() + " " + u.getStatus();
```

You can now evaluate a rule dynamically:

```java
Expression rule = new AndExpression(
    new TerminalExpression("admin"),
    new TerminalExpression("active")
);

boolean canReceiveTicket = rule.interpret(input); // true or false
```

This makes your logic **flexible and data-driven** – no hard-coded `if` chains.

---

## ✅ Benefits

- Decouples logic from structure.
- Easy to add or change rules without rewriting your program.
- Great for mini-DSLs, filters, access control, and rule engines.

## ⚠️ Drawbacks

- Not ideal for complex grammars (use a real parser instead).
- May lead to many small classes for large rule sets.

## 📁 File

The full example is implemented in `InterpreterExample.java`.
