package view;

import model.characters.heroEntity;

import static util.Colors.Colors.*;

public class ConsoleGameView {

    public void consoleMovementInterface() {

        System.out.println(ANSI_CYAN + "Choose one of the following options:" + ANSI_RESET);
        System.out.println("1: North");
        System.out.println("2: East");
        System.out.println("3: South");
        System.out.println("4: West");
        System.out.println("5: Show character stats");
        System.out.println("9: Save & exit game");
    }

    public void printHeroStats(heroEntity hero) {

        System.out.println(ANSI_CYAN + "Hero stats: " + ANSI_RESET);
        System.out.println("Name = " + hero.getName() + " || Class = " + hero.getaClass());
        System.out.println("Level = " + hero.getLevel() + " || Experience = " + hero.getExperience());
        System.out.println(ANSI_RED + "Attack: " + hero.getAttack() + ANSI_RESET);
        if (hero.getWeapon() != null)
            System.out.println(ANSI_RED + "Weapon: " + hero.getWeapon().getName() + " (" + hero.getWeapon().getDamage() + " damage)" + ANSI_RESET);
        else
            System.out.println(ANSI_RED + "No weapon equipped, you are fighting with your bare hands." + ANSI_RESET);

        System.out.println(ANSI_BLUE + "Defense: " + hero.getDefense() + ANSI_RESET);
        if (hero.getArmor() != null)
            System.out.println(ANSI_BLUE + "Armor: " + hero.getArmor().getName() + " (" + hero.getArmor().getProtection() + " defense)" + ANSI_RESET);
        else
            System.out.println(ANSI_BLUE + "No armor equipped, you are fighting butt-naked." + ANSI_RESET);

        System.out.println(ANSI_GREEN + "HP: " + hero.getHp() +ANSI_GREEN);
        if (hero.getHelm() != null)
            System.out.println(ANSI_GREEN + "Helm: " + hero.getHelm().getName() + " (" + hero.getHelm().getHp() + " HP)" + ANSI_RESET);
        else
            System.out.println(ANSI_GREEN + "No helm equipped, you may get an arrow to the head." + ANSI_RESET);
    }

    public void selectClass() {

        System.out.println(ANSI_CYAN + "Select a class:" + ANSI_RESET);
        System.out.println("1. Warrior");
        System.out.println("2. Thief");
        System.out.println("3. Mage");
    }

    public void selectName() {

        System.out.println(ANSI_CYAN + "Enter a name" + ANSI_RESET);
    }

    public void chooseConsole () {

        System.out.println("1. New hero");
        System.out.println("2. Load existing hero");
        System.out.println("3. Delete existing hero");
    }

    public void chooseGUI () {

        System.out.println("Gui version coming soon");
    }
}
