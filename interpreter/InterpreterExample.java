package interpreter;

// Abstract Expression
interface Expression {
    boolean interpret(String context);
}

// Terminal expression: checks if context contains a specific keyword
class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        return context.contains(data);
    }
}

// Non-terminal expression: AND operation
class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}

// Non-terminal expression: OR operation
class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

// Main
public class InterpreterExample {
    public static void main(String[] args) {
        Expression isAdmin = new TerminalExpression("admin");
        Expression isActive = new TerminalExpression("active");

        Expression isAdminAndActive = new AndExpression(isAdmin, isActive);
        Expression isAdminOrActive = new OrExpression(isAdmin, isActive);

        String user1 = "admin active";
        String user2 = "admin";
        String user3 = "guest inactive";

        System.out.println("User1 is admin AND active? " + isAdminAndActive.interpret(user1));
        System.out.println("User2 is admin AND active? " + isAdminAndActive.interpret(user2));
        System.out.println("User3 is admin OR active? " + isAdminOrActive.interpret(user3));
    }
}
