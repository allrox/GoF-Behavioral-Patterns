// Abstract base class of the chain
abstract class Support {
    protected Support next;

    public void setNext(Support next) {
        this.next = next;
    }

    public abstract void handle(String issue);
}

// Attendant handles simple issues
class Attendant extends Support {
    public void handle(String issue) {
        if (issue.equalsIgnoreCase("password")) {
            System.out.println("Attendant resolved: reset password.");
        } else if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("Issue not resolved.");
        }
    }
}

// Supervisor handles moderate issues
class Supervisor extends Support {
    public void handle(String issue) {
        if (issue.equalsIgnoreCase("connection")) {
            System.out.println("Supervisor resolved: connection problem.");
        } else if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("Issue not resolved.");
        }
    }
}

// Manager handles serious issues
class Manager extends Support {
    public void handle(String issue) {
        if (issue.equalsIgnoreCase("cut cable")) {
            System.out.println("Manager resolved: cable replaced.");
        } else {
            System.out.println("Issue not resolved. Escalate to technical team.");
        }
    }
}

// Main class with simulation
public class ClientSupport {
    public static void main(String[] args) {
        // Create handlers
        Support attendant = new Attendant();
        Support supervisor = new Supervisor();
        Support manager = new Manager();

        // Build the chain
        attendant.setNext(supervisor);
        supervisor.setNext(manager);

        // Test different issues
        System.out.println("🔧 Issue: password");
        attendant.handle("password");

        System.out.println("\n🔧 Issue: connection");
        attendant.handle("connection");

        System.out.println("\n🔧 Issue: cut cable");
        attendant.handle("cut cable");

        System.out.println("\n🔧 Issue: I'm angry");
        attendant.handle("I'm angry");
    }
}
