package model.artifacts;

import javax.persistence.*;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table (name = "weapons")
public class weaponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}