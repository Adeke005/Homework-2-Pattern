package rpg.mediator;

public class Captain extends GuildMember {

    public Captain(GuildMediator mediator) {
        super("Captain", mediator);
    }

    public void coordinateQuest(String questTitle) {
        send("quest '" + questTitle + "'", "SUPPLY");
        send("quest '" + questTitle + "'", "RECON");
        send("quest '" + questTitle + "'", "MEDICAL");
    }

    @Override
    public void receive(String message, String topic, GuildMember sender) {
        System.out.println(
                "[CAPTAIN] Received on " + topic + " from " + sender.getName() + ": " + message
        );
    }
}
