package controller.Providers;

import model.artifacts.armorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ArmorProvider {

    public armorEntity provideArmor(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM armorEntity AS e WHERE e.id = :objID").setParameter("objID", id);
        armorEntity armor = (armorEntity) query.getSingleResult();

        em.close();
        emf.close();

        return armor;
    }
}