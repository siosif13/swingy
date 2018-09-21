package model.characters;

import model.artifacts.armorEntity;
import model.artifacts.helmEntity;
import model.artifacts.weaponEntity;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class heroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String aclass;
    private String name;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hp;

    @OneToOne
    weaponEntity weapon;

    @OneToOne
    armorEntity armor;

    @OneToOne
    helmEntity helm;

    public heroEntity() {}

    public heroEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getaClass() {
        return aclass;
    }

    public void setaClass(String aClass) {
        aclass = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public weaponEntity getWeapon() {
        if (weapon != null)
            return weapon;
        else
            return null;
    }

    public void setWeapon(weaponEntity weapon) {
        this.weapon = weapon;
    }

    public armorEntity getArmor() {
        if (armor != null)
            return armor;
        else
            return null;
    }

    public void setArmor(armorEntity armor) {
        this.armor = armor;
    }

    public helmEntity getHelm() {
        if (helm != null)
            return helm;
        else
            return null;
    }

    public void setHelm(helmEntity helm) {
        this.helm = helm;
    }


}
