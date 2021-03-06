package controller.Providers;

import model.artifacts.helmEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HelmProvider {

    public helmEntity provideHelm(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM helmEntity AS e WHERE e.id = :objID").setParameter("objID", id);
        helmEntity helm = (helmEntity) query.getSingleResult();

        em.close();
        emf.close();

        return helm;
    }
}