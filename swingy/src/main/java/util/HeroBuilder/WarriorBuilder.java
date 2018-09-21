package util.HeroBuilder;
import model.characters.heroEntity;

public class WarriorBuilder implements HeroFactory {

    heroEntity warrior;

    public WarriorBuilder(String name){
        this.warrior = new heroEntity();
        this.warrior.setName(name);
        buildClass();
        buildLevel();
        buildExperience();
        buildAttack();
        buildDefense();
        buildHitPoints();
    }

    public void buildClass() {
        this.warrior.setaClass("Warrior");
    }

    public void buildLevel() {
        this.warrior.setLevel(1);
    }

    public void buildExperience() {
        this.warrior.setExperience(0);
    }

    public void buildAttack(){
        this.warrior.setAttack(4);
    }

    public void buildDefense() {
        this.warrior.setDefense(7);
    }

    public void buildHitPoints() {
        this.warrior.setHp(14);
    }

    public heroEntity getWarrior() {return this.warrior;}
}