package util.HeroBuilder;
import model.characters.heroEntity;

public class MageBuilder implements HeroFactory {

     heroEntity mage;

    public MageBuilder(String name){
        this.mage = new heroEntity();
        this.mage.setName(name);
        buildClass();
        buildLevel();
        buildExperience();
        buildAttack();
        buildDefense();
        buildHitPoints();
    }

    public void buildClass() {
        this.mage.setaClass("Mage");
    }

    public void buildLevel() {
        this.mage.setLevel(1);
    }

    public void buildExperience() {
        this.mage.setExperience(0);
    }

    public void buildAttack(){
        this.mage.setAttack(8);
    }

    public void buildDefense() {
        this.mage.setDefense(1);
    }

    public void buildHitPoints() {
        this.mage.setHp(16);
    }

    public heroEntity getMage() {return this.mage;}
}