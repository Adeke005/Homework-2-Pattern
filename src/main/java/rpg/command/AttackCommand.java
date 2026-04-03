package rpg.command;

import rpg.arena.ArenaFighter;
import rpg.arena.ArenaOpponent;

public class AttackCommand implements ActionCommand {

    private ArenaFighter fighter;
    private ArenaOpponent opponent;

    public AttackCommand(ArenaFighter f, ArenaOpponent o) {
        this.fighter = f;
        this.opponent = o;
    }

    public void execute() {
        fighter.attack(opponent);
    }

    public void undo() {
        System.out.println("Undo attack (not fully reversible)");
    }
}