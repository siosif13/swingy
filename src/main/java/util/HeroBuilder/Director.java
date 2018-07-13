package util.HeroBuilder;

import model.characters.heroEntity;

public class Director {

    public heroEntity createHero(String aClass, String name) {

        switch (aClass) {

            case "Mage" : MageBuilder mage = new MageBuilder(name); return mage.getMage();
            case "Thief" : ThiefBuilder thief = new ThiefBuilder(name); return thief.getThief();
            case "Warrior" : WarriorBuilder warrior = new WarriorBuilder(name); return warrior.getWarrior();
            default: System.out.println("Diretor returned null"); return null;
        }
    }
}
