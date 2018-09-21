package util.HeroBuilder;
import model.characters.heroEntity;

public class ThiefBuilder implements HeroFactory {

    heroEntity thief;

    public ThiefBuilder(String name){
        this.thief = new heroEntity();
        this.thief.setName(name);
        buildClass();
        buildLevel();
        buildExperience();
        buildAttack();
        buildDefense();
        buildHitPoints();
    }

    public void buildClass() {
        this.thief.setaClass("Thief");
    }

    public void buildLevel() {
        this.thief.setLevel(1);
    }

    public void buildExperience() {
        this.thief.setExperience(0);
    }

    public void buildAttack(){
        this.thief.setAttack(5);
    }

    public void buildDefense() {
        this.thief.setDefense(5);
    }

    public void buildHitPoints() {
        this.thief.setHp(15);
    }

    public heroEntity getThief() {return this.thief;}
}