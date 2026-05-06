package rpg.mediator;

public class Healer extends GuildMember {

    public Healer(GuildMediator mediator) {
        super("Healer", mediator);
    }

    @Override
    public void receive(String message, String topic, GuildMember sender) {
        if ("MEDICAL".equals(topic)) {
            System.out.println(
                    "[MEDICAL] Healer prepares restorative support for " + message
            );
        }
    }
}
