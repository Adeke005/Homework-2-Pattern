package rpg.hero.character;

public class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Mage();
    }
}
