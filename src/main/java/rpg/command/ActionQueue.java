package rpg.command;

import java.util.Stack;

public class ActionQueue {

    private Stack<ActionCommand> history = new Stack<>();

    public void enqueue(ActionCommand cmd) {
        history.push(cmd);
    }

    public void executeAll() {
        for (ActionCommand cmd : history) {
            cmd.execute();
        }
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}