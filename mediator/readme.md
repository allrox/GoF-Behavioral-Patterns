
# Mediator Pattern – Java Example

This project demonstrates the **Mediator** behavioral design pattern through a minimal and easy-to-understand example in Java. The Mediator pattern is used to centralize communication between objects, avoiding tight coupling and direct dependencies.

---

## 📌 Scenario

We simulate a simple form with:

- A `TextField` where the user types
- A `Button` that is **enabled only when the input is not empty**

Instead of making the `Button` directly check the `TextField`, a `FormMediator` class handles the coordination between them.

---

## 🧱 Class Breakdown

- `UIControlMediator`: The interface for mediators to implement.
- `UIControl`: Abstract class for UI components that are coordinated by the mediator.
- `TextField`: A text input field that notifies the mediator when it changes.
- `Button`: A submit button that is enabled or disabled based on the `TextField`.
- `FormMediator`: Concrete mediator that defines how components should react.
- `MediatorExample`: The `main()` class to simulate typing and observe the interaction.

---

## 🧠 Key Learning Points

- **Encapsulation**: Components don’t interact directly with each other.
- **Centralized logic**: Only the mediator knows the rules of coordination.
- **Loose coupling**: The system is easier to maintain and extend.

---

## 🔧 Behavior Summary

When the user types something into the `TextField`, the mediator checks its value and enables the `Button` if it's not empty.

---

## 💡 Example Output

```
Typing 'hello'...
Button is now enabled
Clearing input...
Button is now disabled
```

---

## 📁 File

All classes are contained in a single file within the `mediator` package: `MediatorExample.java`.
