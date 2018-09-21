package model.characters;


import javax.persistence.*;

@Entity
@Table(name = "villains")
public class villainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int hp;
    private int damage;
    private String name;
    private int providedExperience;

    public int getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvidedExperience(int experience) {
        this.providedExperience = experience;
    }

    public int getProvidedExperience() {
        return providedExperience;
    }
}
