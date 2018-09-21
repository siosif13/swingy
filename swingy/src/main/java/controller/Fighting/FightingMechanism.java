package controller.Fighting;

import controller.GameController;
import controller.Providers.ArmorProvider;
import controller.Providers.HelmProvider;
import controller.Providers.WeaponProvider;
import model.artifacts.armorEntity;
import model.artifacts.helmEntity;
import model.artifacts.weaponEntity;
import model.characters.heroEntity;
import model.characters.villainEntity;

import static java.lang.System.exit;
import static util.Colors.Colors.*;

public class FightingMechanism {

    public static heroEntity fight(heroEntity hero, villainEntity villain) {

        System.out.println("You encountered a mob");
        System.out.println("1. Fight");
        System.out.println("2. Run");

        GameController controller = new GameController();
        while (true) {
            String i = controller.getUserInput();
            switch (i) {

                case "1":
                    return FightingMechanism.tmpFight(hero, villain);
                case "2":
                    int x = (int) (Math.random() * 2);
                    if (x == 1) {
                        System.out.println("You managed to run");
                        return null;
                    } else
                        System.out.println(villain.getName() + " caught you so you have to fight him.");
                    return FightingMechanism.tmpFight(hero, villain);
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private static heroEntity tmpFight(heroEntity hero, villainEntity villain) {

        int level = hero.getLevel();

        String[] rps = {"Rock", "Paper", "Scrissors"};
        int heroHP = hero.getHp() + hero.getDefense();
        int rpsVillain;
        int rpsHero;
        boolean fightInProgress = true;

        while (fightInProgress) {
            rpsVillain = (int) (Math.random() * 3) + 1;
            rpsHero = (int) (Math.random() * 3) + 1;

            if (rpsHero == 1 && rpsVillain == 3) {
                System.out.println(hero.getName() + " hits " + villain.getName() + " for " + hero.getAttack() + " damage.");
                villain.setHp(villain.getHp() - hero.getAttack());
            } else if (rpsHero == 3 && rpsVillain == 2) {
                System.out.println(hero.getName() + " hits " + villain.getName() + " for " + hero.getAttack() + " damage.");
                villain.setHp(villain.getHp() - hero.getAttack());
            } else if (rpsHero == 2 && rpsVillain == 1) {
                System.out.println(hero.getName() + " hits " + villain.getName() + " for " + hero.getAttack() + " damage.");
                villain.setHp(villain.getHp() - hero.getAttack());
            } else if (rpsVillain == 1 && rpsHero == 3) {
                System.out.println(villain.getName() + " hits " + hero.getName() + " for " + villain.getDamage() + " damage.");
                heroHP = heroHP - villain.getDamage();
            } else if (rpsVillain == 3 && rpsHero == 2) {
                System.out.println(villain.getName() + " hits " + hero.getName() + " for " + villain.getDamage() + " damage.");
                heroHP = heroHP - villain.getDamage();
            } else if (rpsVillain == 2 && rpsHero == 1) {
                System.out.println(villain.getName() + " hits " + hero.getName() + " for " + villain.getDamage() + " damage.");
                heroHP = heroHP - villain.getDamage();
            } else if (rpsHero == 1 && rpsVillain == 1) {
                System.out.println(hero.getName() + " deflects " + villain.getName() + "'s attack.");
            } else if (rpsHero == 2 && rpsVillain == 2) {
                System.out.println(villain.getName() + " deflects " + hero.getName() + "'s attack.");
            } else if (rpsHero == 3 && rpsVillain == 3) {
                System.out.println(hero.getName() + " deflects " + villain.getName() + "'s attack.");
            }

            if (villain.getHp() <= 0) {
                System.out.println(villain.getName() + " has died.");
                hero.setExperience(hero.getExperience() + villain.getProvidedExperience());
                if ((heroHP - hero.getDefense()) >= 5) {
                    hero.setHp(heroHP - hero.getDefense());
                } else {
                    hero.setHp(5);
                }
                System.out.println("You get + " + villain.getProvidedExperience() + " experience.");

                if (hero.getExperience() >= level * 1000 + (Math.sqrt(level - 1) * 450)) {
                    hero.setLevel(level + 1);
                    hero.setExperience(0);
                    hero.setHp(hero.getHp() + 3);
                    hero.setAttack(hero.getAttack() + 3);
                    hero.setDefense(hero.getDefense() + 3);
                    System.out.println("DING! You reached level " + hero.getLevel());
                    System.out.println("+3 Attack || + 3 Defense || + 3 HP");
                }
                fightInProgress = false;
            }else if (heroHP <= 0) {
                    System.out.println("You have died. :(");
                    exit(0);
                }
            }
        int drop = (int) (Math.random() * 2);
        if (drop == 1)
            hero = FightingMechanism.itemDropped(hero, villain);
        drop = (int) (Math.random() * 3);
        if (drop < 2) {
            System.out.println("A health potion dropped (+5hp)");
            if ((hero.getHp() + 5) < 40)
                hero.setHp(hero.getHp() + 5);
            else
                hero.setHp(40);
        }
        return hero;
        }

    private static heroEntity itemDropped(heroEntity hero, villainEntity villain) {

        int villainId = villain.getId();
        int itemType = (int) (Math.random() * 3);
        GameController controller = new GameController();
        boolean whileBool = true;
        String in;

        switch (itemType) {

            case 1:
                WeaponProvider weaponProvider = new WeaponProvider();
                weaponEntity weapon = weaponProvider.provideWeapon(villainId);
                weaponEntity lastWeapon = hero.getWeapon();
                System.out.println(ANSI_PURPLE + "Weapon " + weapon.getName() + " dropped." + ANSI_RESET);
                if (lastWeapon != null)
                    System.out.println("It gives you " + (weapon.getDamage() - lastWeapon.getDamage()) + " damage.");
                else
                    System.out.println("It gives you " + weapon.getDamage() + " damage.");
                System.out.println("1. Equip");
                System.out.println("2. Drop");
                while (true) {
                    in = controller.getUserInput();
                    switch (in) {
                        case "1":
                            if (lastWeapon != null) {
                                hero.setAttack(hero.getAttack() - lastWeapon.getDamage());
                            }
                            hero.setWeapon(weapon);
                            hero.setAttack(hero.getAttack() + weapon.getDamage());
                            return hero;
                        case "2":
                            System.out.println("Weapon dropped.");
                            return hero;
                        default:
                            System.out.println("Wrong input");
                    }
                }
            case 2:
                ArmorProvider armorProvider = new ArmorProvider();
                armorEntity armor = armorProvider.provideArmor(villainId);
                armorEntity lastArmor = hero.getArmor();
                System.out.println(ANSI_PURPLE + "Armor " + armor.getName() + " dropped." + ANSI_RESET);
                if (lastArmor != null)
                    System.out.println("It gives you " + (armor.getProtection() - lastArmor.getProtection()) + " defense.");
                else
                    System.out.println("It gives you " + armor.getProtection() + " protection.");
                System.out.println("1. Equip");
                System.out.println("2. Drop");
                while (true) {
                    in = controller.getUserInput();
                    switch (in) {
                        case "1":
                            if (lastArmor != null) {
                                hero.setDefense(hero.getDefense() - lastArmor.getProtection());
                            }
                            hero.setArmor(armor);
                            hero.setDefense(hero.getDefense() + armor.getProtection());
                            return hero;
                        case "2":
                            System.out.println("Armor dropped");
                            return hero;
                        default:
                            System.out.println("Wrong input");
                    }
                }
            case 3:
                HelmProvider helmProvider = new HelmProvider();
                helmEntity helm = helmProvider.provideHelm(villainId);
                helmEntity lastHelm = hero.getHelm();
                System.out.println(ANSI_PURPLE + "Helm " + helm.getName() + " dropped." + ANSI_RESET);
                if (lastHelm != null)
                    System.out.println("It gives you " + (helm.getHp() - lastHelm.getHp()) + " HP.");
                else
                    System.out.println("It gives you " + helm.getHp() + " HP.");
                System.out.println("1. Equip");
                System.out.println("2. Drop");
                while (true) {
                    in = controller.getUserInput();
                    switch (in) {
                        case "1":
                            if (lastHelm != null) {
                                hero.setHp(hero.getHp() - lastHelm.getHp());
                            }
                            hero.setHelm(helm);
                            hero.setHp(hero.getHp() + helm.getHp());
                            return hero;
                        case "2":
                            System.out.println("Helm dropped");
                            return hero;
                        default:
                            System.out.println("Wrong input");
                    }
                }
        }
        return hero;
    }
}
