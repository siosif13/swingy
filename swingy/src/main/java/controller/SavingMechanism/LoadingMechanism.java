package controller.SavingMechanism;

import controller.Providers.WeaponProvider;
import model.characters.heroEntity;

import javax.persistence.*;
import java.util.List;

import static util.Colors.Colors.ANSI_GREEN;
import static util.Colors.Colors.ANSI_RESET;

public class LoadingMechanism {

    private static LoadingMechanism loadingMechanism = new LoadingMechanism();

    private LoadingMechanism() {}

    public heroEntity loadHero(String name) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM heroEntity e WHERE e.name LIKE :objName").setParameter("objName", name);

        try {
            heroEntity loadedHero = (heroEntity) query.getSingleResult();
            em.close();
            emf.close();
            return loadedHero;
        } catch (NoResultException e) {
            em.close();
            emf.close();
            return null;
        }
    }

    public void printHeroes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query heroes = em.createQuery("SELECT e FROM heroEntity e");
        List<heroEntity> heroList = heroes.getResultList();

        System.out.println("You can select from the following heroes");
        for (heroEntity tmp : heroList) {
            System.out.println(ANSI_GREEN + "Name: " + tmp.getName() + ANSI_RESET + " || Class: " + tmp.getaClass() + " || Level: " +tmp.getLevel());
            System.out.println("Attack: " + tmp.getAttack() + " || Defense: " + tmp.getDefense() + " || HP: " + tmp.getHp());
            System.out.println("Experience: " + tmp.getExperience());
        }
        em.close();
        emf.close();
    }

    public static LoadingMechanism getInstance() {
        return loadingMechanism;
    }
}
