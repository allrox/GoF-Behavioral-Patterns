package memento;


// Memento: stores an immutable snapshot of the state
class TextMemento {
    private final String state;

    public TextMemento(String state) {
        this.state = state;
    }

    public String getSavedState() {
        return state;
    }
}

// Originator: the object whose state we want to save/restore
class TextEditor {
    private String text = "";

    public void write(String newText) {
        this.text = newText;
        System.out.println("Text set to: " + text);
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        if (memento != null) {
            this.text = memento.getSavedState();
            System.out.println("Text restored to: " + text);
        }
    }

    public String getText() {
        return text;
    }
}

// Caretaker: manages the undo and redo stacks
class History {
    private java.util.Stack<TextMemento> undoStack = new java.util.Stack<>();
    private java.util.Stack<TextMemento> redoStack = new java.util.Stack<>();

    // Save the current state and clear redo stack
    public void save(TextMemento memento) {
        undoStack.push(memento);
        redoStack.clear(); // any new action resets redo
    }

    public TextMemento undo() {
        if (!undoStack.isEmpty()) {
            TextMemento current = undoStack.pop();
            redoStack.push(current);
        }
        return undoStack.isEmpty() ? null : undoStack.peek();
    }

    public TextMemento redo() {
        if (!redoStack.isEmpty()) {
            TextMemento memento = redoStack.pop();
            undoStack.push(memento);
            return memento;
        }
        return null;
    }
}

// Main simulation
public class MementoExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("First version");
        history.save(editor.save()); // snapshot saved

        editor.write("Second version");
        history.save(editor.save());

        editor.write("Third version");

        // Undo twice
        editor.restore(history.undo()); // back to second version
        editor.restore(history.undo()); // back to first version

        // Redo once
        editor.restore(history.redo()); // forward to second version
    }
}
