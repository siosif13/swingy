//import model.artifacts.armorEntity;
//import model.artifacts.helmEntity;
//import model.artifacts.weaponEntity;
//import model.characters.heroEntity;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//import javax.swing.text.html.parser.Entity;
//
//public class dbCharTest {
//
//    public static void main(String[] args) {
//
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("heroDB-persistence-unit");
//        EntityManager em = emf.createEntityManager();
//
//        Query wQuery = em.createQuery("SELECT e from weaponEntity as e where id = 1");
//        weaponEntity weapon = (weaponEntity) wQuery.getSingleResult();
//
//        Query hQuery = em.createQuery("SELECT e from helmEntity as e where id = 1");
//        helmEntity helm = (helmEntity) hQuery.getSingleResult();
//
//        Query aQuery = em.createQuery("SELECT e from armorEntity as e where id = 1");
//        armorEntity armor = (armorEntity) aQuery.getSingleResult();
//
//        heroEntity hero = new heroEntity();
//        hero.setAttack(5);
//        hero.setaClass("Mage");
//        hero.setDefense(5);
//        hero.setHp(5);
//        hero.setName("Allah");
//        hero.setExperience(4);
//        hero.setLevel(4);
////        hero.setWeapon(weapon);
////        hero.setArmor(armor);
////        hero.setHelm(helm);
//
//        try {
//            em.getTransaction().begin();
//            em.persist(hero);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
//
//    }
//}
