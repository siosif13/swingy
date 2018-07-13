package model;

import model.artifacts.armorEntity;
import model.artifacts.helmEntity;
import model.artifacts.weaponEntity;
import model.characters.villainEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseTool {

    public static void databaseInit() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        weaponEntity woodenSword = new weaponEntity();
        woodenSword.setName("Wooden Sword");
        woodenSword.setDamage(2);

        weaponEntity steelSword = new weaponEntity();
        steelSword.setName("Steel Sword");
        steelSword.setDamage(4);

        weaponEntity mace = new weaponEntity();
        mace.setName("Ball-smashing Mace");
        mace.setDamage(7);

        weaponEntity dildo = new weaponEntity();
        dildo.setName("Magic Dildo");
        dildo.setDamage(15);

        armorEntity leatherArmor = new armorEntity();
        leatherArmor.setName("Leather Armor");
        leatherArmor.setProtection(2);

        armorEntity steelArmor = new armorEntity();
        steelArmor.setName("Steel Armor");
        steelArmor.setProtection(4);

        armorEntity dickSkin = new armorEntity();
        dickSkin.setName("DickSkin Armor");
        dickSkin.setProtection(7);

        armorEntity latexArmor = new armorEntity();
        latexArmor.setName("Magix Latex Armor");
        latexArmor.setProtection(15);

        helmEntity leatherHelm = new helmEntity();
        leatherHelm.setName("Leather Helm");
        leatherHelm.setHp(2);

        helmEntity steelHelm = new helmEntity();
        steelHelm.setName("Steel Helm");
        steelHelm.setHp(4);

        helmEntity dickHead = new helmEntity();
        dickHead.setName("Dick Head");
        dickHead.setHp(7);

        helmEntity latexHelm = new helmEntity();
        latexHelm.setName("Latex Helm");
        latexHelm.setHp(15);

        villainEntity rat = new villainEntity();
        rat.setName("Big Rat");
        rat.setHp(5);
        rat.setDamage(2);
        rat.setProvidedExperience(100);

        villainEntity orc = new villainEntity();
        orc.setName("Orc");
        orc.setHp(8);
        orc.setDamage(3);
        orc.setProvidedExperience(200);

        villainEntity bloodMage = new villainEntity();
        bloodMage.setName("Blood Mage");
        bloodMage.setHp(11);
        bloodMage.setDamage(4);
        bloodMage.setProvidedExperience(375);

        villainEntity dragon = new villainEntity();
        dragon.setName("Dragon");
        dragon.setHp(16);
        dragon.setDamage(8);
        dragon.setProvidedExperience(600);

        try {
            em.getTransaction().begin();

            em.persist(woodenSword);
            em.persist(steelSword);
            em.persist(mace);
            em.persist(dildo);

            em.persist(leatherArmor);
            em.persist(steelArmor);
            em.persist(dickSkin);
            em.persist(latexArmor);

            em.persist(leatherHelm);
            em.persist(steelHelm);
            em.persist(dickHead);
            em.persist(latexHelm);

            em.persist(rat);
            em.persist(orc);
            em.persist(bloodMage);
            em.persist(dragon);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

    }
}
