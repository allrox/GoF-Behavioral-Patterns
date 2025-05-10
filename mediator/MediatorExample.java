package mediator;

// Mediator interface
interface UIControlMediator {
    void notifyChange(UIControl sender);
}

// Component base
abstract class UIControl {
    protected UIControlMediator mediator;

    public UIControl(UIControlMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void changed();
}

// Concrete component: TextField
class TextField extends UIControl {
    private String value = "";

    public TextField(UIControlMediator mediator) {
        super(mediator);
    }

    public void setValue(String value) {
        this.value = value;
        changed(); // notifica o mediador
    }

    public String getValue() {
        return value;
    }

    @Override
    public void changed() {
        mediator.notifyChange(this);
    }
}

// Concrete component: Button
class Button extends UIControl {
    private boolean enabled = false;

    public Button(UIControlMediator mediator) {
        super(mediator);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        System.out.println("Button is now " + (enabled ? "enabled" : "disabled"));
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void changed() {
        mediator.notifyChange(this);
    }
}

// Concrete Mediator
class FormMediator implements UIControlMediator {
    private TextField textField;
    private Button button;

    public void register(TextField tf, Button btn) {
        this.textField = tf;
        this.button = btn;
    }

    @Override
    public void notifyChange(UIControl sender) {
        if (sender == textField) {
            String text = textField.getValue();
            button.setEnabled(!text.trim().isEmpty());
        }
    }
}

// Main class
public class MediatorExample {
    public static void main(String[] args) {
        FormMediator mediator = new FormMediator();

        TextField input = new TextField(mediator);
        Button submitButton = new Button(mediator);

        mediator.register(input, submitButton);

        System.out.println("Typing 'hello'...");
        input.setValue("hello");

        System.out.println("Clearing input...");
        input.setValue("");
    }
}
