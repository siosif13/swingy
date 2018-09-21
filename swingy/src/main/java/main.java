import controller.GameController;
import controller.SavingMechanism.DeletingMechanism;
import controller.SavingMechanism.LoadingMechanism;
import model.DataBaseTool;
import model.Globals.Globals;
import model.characters.heroEntity;
import util.HeroBuilder.Director;
import view.ConsoleGameView;

import javax.xml.bind.annotation.XmlElementDecl;

import static java.lang.System.exit;
import static util.Colors.Colors.*;

public class main {

    public static ConsoleGameView  gameView = new ConsoleGameView();
    public static GameController controller = new GameController();

    public static void main(String[] args) {

//        if (args.length > 0) {
//
//            if (args[0].equals("console")) {
//                gameView = new ConsoleGameView();
//                controller = new GameController();
//            } else if (args[1].equals("gui")) {
//                Globals.isGui = 1;
//            } else {
//                System.out.println("Usage -jar/[gui/console]");
//                exit(0);
//            }
//        } else {
//            System.out.println("Usage -jar/[gui/console]");
//            exit(0);
//        }

//        StartMenuGui start = new StartMenuGui();
//        start.initialize();
//
//        Globals.setMapSize(1);
//        GuiView gui = new GuiView();
//        gui.remove(GuiView.generalContainer);
//        gui.add(start);
//        gui.validate();

//        CreateHeroGui createHeroGui = new CreateHeroGui();
//        gui.remove(start);
//        gui.add(createHeroGui);
//        gui.validate();

        DataBaseTool.databaseInit();

        //Globals.setMapSize(1);
        //Globals.gui = new GuiView();

        String in;
        boolean whileBool = true;
        gameView.chooseConsole();
        heroEntity hero;
        String aClass = null;
        String name = null;
        while (whileBool) {
            in = controller.getUserInput();
            switch (in) {
                case "1":
                    boolean whileBool2 = true;
                    gameView.selectClass();
                    while (whileBool2) {
                        in = controller.getUserInput();
                        switch (in) {
                            case "1":
                                aClass = "Warrior";
                                whileBool2 = false;
                                break;
                            case "2":
                                aClass = "Thief";
                                whileBool2 = false;
                                break;
                            case "3":
                                aClass = "Mage";
                                whileBool2 = false;
                                break;
                            default:
                                System.out.println("Wrong input");
                        }
                    }
                    gameView.selectName();
                    name = controller.getUserInput();
                    Director director = new Director();
                    hero = director.createHero(aClass, name);
                    controller.controllerStart(hero);
                    whileBool = false;
                    break;
                case "2":
                    boolean whileBool5 = true;
                    while (whileBool5) {
                        System.out.println(ANSI_CYAN + "Enter hero's name or enter 9 to get back:" + ANSI_RESET);
                        LoadingMechanism.getInstance().printHeroes();
                        name = controller.getUserInput();
                        if (name.equals("9")) {
                            whileBool5 = false;
                            gameView.chooseConsole();
                            break;
                        }
                        hero = LoadingMechanism.getInstance().loadHero(name);
                        if (hero == null) {
                            System.out.println(ANSI_CYAN + "A hero with this name does not exist." + ANSI_RESET);
                        } else
                            controller.controllerStart(hero);
                    }
                    break;
                case "3":
                    boolean whileBool3 = true;
                    while (whileBool3) {
                        System.out.println(ANSI_CYAN + "Enter a hero's name or enter " + ANSI_RESET + ANSI_RED + "9" +
                                ANSI_RESET + ANSI_CYAN + " to get back:" + ANSI_RESET);
                        LoadingMechanism.getInstance().printHeroes();
                        name = controller.getUserInput();
                        if (name.equals("9")) {
                            whileBool3 = false;
                            gameView.chooseConsole();
                            break;
                        }
                        if (DeletingMechanism.deleteHero(name) == 0) {
                            System.out.println(ANSI_CYAN + "A hero with this name does not exist." + ANSI_RESET);
                        }
                    }
                    break;
                default:
                    System.out.println(ANSI_RED + "Incorrect statement" + ANSI_RESET);
            }
        }
    }
}
