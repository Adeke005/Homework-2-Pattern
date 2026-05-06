package rpg.mediator;

public class Scout extends GuildMember {

    public Scout(GuildMediator mediator) {
        super("Scout", mediator);
    }

    @Override
    public void receive(String message, String topic, GuildMember sender) {
        if ("RECON".equals(topic)) {
            System.out.println(
                    "[RECON] Scout reports terrain and enemy movement for " + message
            );
        }
    }
}
