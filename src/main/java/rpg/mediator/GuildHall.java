package rpg.mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildHall implements GuildMediator {

    private final Map<String, List<GuildMember>> subscribersByTopic = new HashMap<>();

    public void subscribe(String topic, GuildMember member) {
        subscribersByTopic
                .computeIfAbsent(topic, ignored -> new ArrayList<>())
                .add(member);
    }

    @Override
    public void send(String message, String topic, GuildMember sender) {
        List<GuildMember> subscribers = subscribersByTopic.get(topic);
        if (subscribers == null) {
            return;
        }
        for (GuildMember subscriber : subscribers) {
            if (subscriber != sender) {
                subscriber.receive(message, topic, sender);
            }
        }
    }
}
