
# Memento Pattern – Java Example

This project demonstrates the **Memento** behavioral design pattern in Java using a text editor simulation with undo and redo functionality.

---

## 📌 Scenario

You have a `TextEditor` that stores and modifies text. The system allows:

- Saving the current state (snapshot)
- Undoing changes (going back to a previous state)
- Redoing changes (reapplying a previously undone state)

The challenge is to do this **without breaking encapsulation** or directly accessing internal fields.

---

## 🧠 Key Concepts (based on student's reasoning)

> *"The object contains a field that holds the current content. This content is stored in an array (or stack), so when we call undo, we perform a pop, and this action leads us back to the previous state."*

✔️ Exactly. Here's how it works:

- **Snapshots (states)** are saved using Mementos
- States are managed in a **stack** (Last-In, First-Out)
- When we undo, we:
  - `pop()` the current state from the undo stack
  - **push** it to the redo stack
  - **restore** the previous state

This creates a navigation path across previous and next states — just like in a real text editor.

---

## 🧱 Class Structure

### `TextMemento`
- Stores an immutable snapshot of the text
- Only the `TextEditor` knows how to create or restore it

### `TextEditor`
- Acts as the **Originator**
- Modifies and restores its internal state
- Creates Mementos via `save()`, restores via `restore()`

### `History`
- Holds two stacks: `undoStack` and `redoStack`
- Coordinates undo/redo logic

---

## 🔧 Simplified Java Usage Example

```java
TextEditor editor = new TextEditor();
History history = new History();

editor.write("First version");
history.save(editor.save());

editor.write("Second version");
history.save(editor.save());

editor.write("Third version");

// Undo twice
editor.restore(history.undo());
editor.restore(history.undo());

// Redo once
editor.restore(history.redo());
```

---

## 💡 Example Output

```
Text set to: First version
Text set to: Second version
Text set to: Third version
Text restored to: Second version
Text restored to: First version
Text restored to: Second version
```

---

## ✅ Benefits of This Design

- Encapsulation is preserved (no access to internal fields)
- Full undo/redo stack management is clean and reversible
- Easy to implement in any application with reversible actions

---

## ⚠️ Important Notes

- **Redo only works** if you undo and do not perform a new action in between.
- New actions after an undo typically **clear the redo stack** — this behavior should be handled explicitly depending on the use case.
