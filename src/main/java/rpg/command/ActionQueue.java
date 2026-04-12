package rpg.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ActionQueue {

    private List<ActionCommand> queue = new ArrayList<>();
    private Stack<ActionCommand> history = new Stack<>();

    public void enqueue(ActionCommand cmd) {
        queue.add(cmd);
    }

    public void executeAll() {
        for (ActionCommand cmd : queue) {
            cmd.execute();
            history.push(cmd);
        }
        queue.clear();
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}