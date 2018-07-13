package controller.Providers;

import model.characters.villainEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static util.Colors.Colors.*;

public class MobProvider {


    public static villainEntity provideVillain() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        int get = (int) ((Math.random() * 4) + 1);
        Query query = null;

        switch (get) {

            case 1:
                query = em.createQuery("SELECT e FROM villainEntity AS e WHERE id = 1");
                break;
            case 2:
                query = em.createQuery("SELECT e FROM villainEntity AS e WHERE id = 2");
                break;
            case 3:
                query = em.createQuery("SELECT e FROM villainEntity AS e WHERE id = 3");
                break;
            case 4:
                query = em.createQuery("SELECT e FROM villainEntity AS e WHERE id = 4");
                break;
        }

        villainEntity villain = (villainEntity) query.getSingleResult();

        System.out.println(ANSI_RED + "Villain:" + villain.getName() + ANSI_RESET);
        System.out.println(ANSI_RED + "Villain HP: " + villain.getHp() + ANSI_RESET);
        System.out.println(ANSI_RED + "Villain damage: " + villain.getDamage() + ANSI_RESET);


        em.close();
        emf.close();
        return villain;
    }
}
