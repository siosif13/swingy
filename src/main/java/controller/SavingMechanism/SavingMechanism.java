package controller.SavingMechanism;

import model.characters.heroEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SavingMechanism {

    private static SavingMechanism savingMechanism = new SavingMechanism();

    private SavingMechanism() {
    }

    public static SavingMechanism getInstance() {
        return savingMechanism;
    }

    public void saveHero(heroEntity hero) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM heroEntity e WHERE e.id LIKE :objId").setParameter("objId", hero.getId());
        List<heroEntity> qList = query.getResultList();

        if (qList.size() == 1) {
            try {
                System.out.println("Level = " + hero.getLevel() + " Experience = " + hero.getExperience());
                em.getTransaction().begin();

                heroEntity tmpHero = em.find(heroEntity.class, hero.getId());
                tmpHero.setLevel(hero.getLevel());
                tmpHero.setExperience(hero.getExperience());
                tmpHero.setAttack(hero.getAttack());
                tmpHero.setDefense(hero.getDefense());
                tmpHero.setHp(hero.getHp());
                tmpHero.setWeapon(hero.getWeapon());
                tmpHero.setHelm(hero.getHelm());
                tmpHero.setArmor(hero.getArmor());

                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em.close();
                emf.close();
            }
        } else {
            try {
                em.getTransaction().begin();
                em.persist(hero);
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
}

//        heroEntity tmpHero = new heroEntity();
//
//        tmpHero.setaClass(hero.getaClass());
//        tmpHero.setLevel(hero.getLevel());
//        tmpHero.setExperience(hero.getExperience());
//        tmpHero.setName(hero.getName());
//        tmpHero.setHp(hero.getHp());
//        tmpHero.setAttack(hero.getAttack());
//        tmpHero.setDefense(hero.getDefense());