package rpg.mediator;

public interface GuildMediator {

    void send(String message, String topic, GuildMember sender);
}
