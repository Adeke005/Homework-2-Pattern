package rpg.mediator;

public class Quartermaster extends GuildMember {

    public Quartermaster(GuildMediator mediator) {
        super("Quartermaster", mediator);
    }

    @Override
    public void receive(String message, String topic, GuildMember sender) {
        if ("SUPPLY".equals(topic)) {
            System.out.println(
                    "[SUPPLY] Quartermaster allocates supplies for " + message
            );
        }
    }
}
