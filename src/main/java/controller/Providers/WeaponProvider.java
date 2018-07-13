package controller.Providers;

import model.artifacts.weaponEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class WeaponProvider {

    public weaponEntity provideWeapon(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM weaponEntity AS e WHERE e.id = :objID").setParameter("objID", id);
        weaponEntity weapon = (weaponEntity) query.getSingleResult();

        em.close();
        emf.close();

        return weapon;
    }
}