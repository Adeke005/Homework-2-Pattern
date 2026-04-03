package rpg.command;

import rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {

    private ArenaFighter fighter;
    private int amount;

    public HealCommand(ArenaFighter f, int amount) {
        this.fighter = f;
        this.amount = amount;
    }

    public void execute() {
        fighter.heal(amount);
    }

    public void undo() {
        fighter.takeDamage(amount);
        System.out.println("Undo heal");
    }
}
