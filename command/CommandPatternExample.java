package command;

// Command: common interface for all commands
interface Command {
    void execute();
}

// Receiver: the actual object that performs actions
class Light {
    public void turnOn() {
        System.out.println("💡 Light turned ON");
    }

    public void turnOff() {
        System.out.println("💡 Light turned OFF");
    }
}

// ConcreteCommand: encapsulates the command to turn the light on
class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// ConcreteCommand: encapsulates the command to turn the light off
class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker: the remote control
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

// Main class: setup and execution
public class CommandPatternExample {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        // Create commands
        Command turnOn = new TurnOnLightCommand(livingRoomLight);
        Command turnOff = new TurnOffLightCommand(livingRoomLight);

        // Create the remote control
        RemoteControl remote = new RemoteControl();

        System.out.println("🔘 Pressing ON button:");
        remote.setCommand(turnOn);
        remote.pressButton();

        System.out.println("\n🔘 Pressing OFF button:");
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
