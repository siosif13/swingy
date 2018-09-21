package controller.SavingMechanism;

import model.characters.heroEntity;

import javax.persistence.*;

public class DeletingMechanism {

    public static int deleteHero(String name) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM heroEntity AS e WHERE e.name LIKE :objName").setParameter("objName", name);

        try {
            heroEntity hero = (heroEntity) query.getSingleResult();
            em.getTransaction().begin();
            em.remove(hero);
            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            em.close();
            emf.close();
            return 0;
        } finally {
            em.close();
            emf.close();
        }
        return 1;
    }
}
