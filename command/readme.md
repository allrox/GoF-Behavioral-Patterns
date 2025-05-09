
# Command Pattern – Java Example

This project demonstrates the **Command** behavioral design pattern in Java. The pattern encapsulates a request as an object, allowing you to parameterize clients with different requests, queue or log requests, and support undoable operations.

## 📌 Scenario

A simple remote control can be configured to turn a light **on** or **off**. The action logic is encapsulated inside the `Light` class (Receiver), while the command objects represent the user's intentions.

## 🧱 Class Structure

- `Command`: Interface declaring the `execute()` method.
- `TurnOnLightCommand` / `TurnOffLightCommand`: Concrete commands that invoke actions on the `Light`.
- `Light`: The real object (Receiver) that performs actions like turning the light on/off.
- `RemoteControl`: The invoker that triggers the commands.
- `CommandPatternExample`: The main class to simulate and test the commands.

## 🔗 Interaction Example

```java
Command turnOn = new TurnOnLightCommand(light);
Command turnOff = new TurnOffLightCommand(light);

RemoteControl remote = new RemoteControl();

remote.setCommand(turnOn);
remote.pressButton(); // 💡 Light turned ON

remote.setCommand(turnOff);
remote.pressButton(); // 💡 Light turned OFF
```

## 💡 Output

```
🔘 Pressing ON button:
💡 Light turned ON

🔘 Pressing OFF button:
💡 Light turned OFF
```

## ✅ Benefits of Command Pattern

- Decouples the sender (invoker) from the receiver (logic).
- Makes it easy to add new commands without modifying existing code.
- Supports features like command logging, undo/redo, and macros.

## 📁 File

The entire example is implemented in a single file: `CommandPatternExample.java`.
