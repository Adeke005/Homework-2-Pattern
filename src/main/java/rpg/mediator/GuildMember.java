package rpg.mediator;

public abstract class GuildMember {

    private final String name;
    private final GuildMediator mediator;

    protected GuildMember(String name, GuildMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    protected GuildMediator getMediator() {
        return mediator;
    }

    public void send(String message, String topic) {
        mediator.send(message, topic, this);
    }

    public abstract void receive(String message, String topic, GuildMember sender);
}
