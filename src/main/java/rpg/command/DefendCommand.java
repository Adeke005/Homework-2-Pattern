package rpg.command;

import rpg.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {

    private ArenaFighter fighter;

    public DefendCommand(ArenaFighter f) {
        this.fighter = f;
    }

    public void execute() {
        fighter.defend();
    }

    public void undo() {
        fighter.setDefense(fighter.getDefense() - 5);
        System.out.println("Undo defend");
    }
}