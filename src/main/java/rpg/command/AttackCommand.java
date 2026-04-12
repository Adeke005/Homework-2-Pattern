package rpg.command;

import rpg.arena.ArenaFighter;
import rpg.arena.ArenaOpponent;

public class AttackCommand implements ActionCommand {

    private ArenaFighter fighter;
    private ArenaOpponent opponent;
    private int lastDamage;

    public AttackCommand(ArenaFighter f, ArenaOpponent o) {
        this.fighter = f;
        this.opponent = o;
    }

    public void execute() {
        lastDamage = fighter.getAttack();
        opponent.receiveDamage(lastDamage);
    }

    public void undo() {
        opponent.receiveDamage(-lastDamage);
        System.out.println("Undo attack");
    }
}