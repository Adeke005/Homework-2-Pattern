package rpg.arena;
public class TournamentResult {

    private String winner;
    private int rounds;

    public TournamentResult(String winner, int rounds) {
        this.winner = winner;
        this.rounds = rounds;
    }

    public String getWinner() {
        return winner;
    }

    public int getRounds() {
        return rounds;
    }

    public void printSummary() {
        System.out.println("=== TOURNAMENT RESULT ===");
        System.out.println("Winner: " + winner);
        System.out.println("Rounds: " + rounds);
    }
}