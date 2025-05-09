
# Chain of Responsibility – Java Example

This project demonstrates the **Chain of Responsibility** design pattern in Java. The pattern is useful when multiple objects might handle a request, but the handler is not known in advance. The request is passed along a chain of potential handlers until one of them deals with it.

## 📌 Scenario

A customer support system is implemented with three levels of support roles:

- **Attendant**: Handles simple issues (e.g., password reset)
- **Supervisor**: Handles moderate issues (e.g., connection problems)
- **Manager**: Handles serious issues (e.g., cut cable)

If an issue can't be handled at one level, it is forwarded to the next.

## 🧱 Class Structure

- `Support` (abstract class): Defines the chain structure and method `handle(String issue)`.
- `Attendant`, `Supervisor`, `Manager`: Implement the specific handling logic.
- `ClientSupport`: Contains the `main` method and builds the chain.

## 🔗 Chain Example

```java
Support attendant = new Attendant();
Support supervisor = new Supervisor();
Support manager = new Manager();

attendant.setNext(supervisor);
supervisor.setNext(manager);

attendant.handle("connection");
```

## 💡 Output

```
🔧 Issue: password
Attendant resolved: reset password.

🔧 Issue: connection
Supervisor resolved: connection problem.

🔧 Issue: cut cable
Manager resolved: cable replaced.

🔧 Issue: I'm angry
Issue not resolved. Escalate to technical team.
```

## ✅ Benefits of Chain of Responsibility

- Decouples sender from receiver.
- Adds flexibility in assigning responsibility.
- Promotes single responsibility principle (each handler has one job).

## 📁 File

The full example is implemented in a single file: `ClientSupport.java`.

## 💬 Personal Note

A generic issue can be handled by different levels or roles. Each role encapsulates its own logic, and if it can't handle the issue, it passes it to the next one (via a simple `if`). The application assembles a chain that defines who the next handler is. Once triggered at the base level, the conditions are tested in a literal chain reaction until someone solves it — or it fails at the end.
