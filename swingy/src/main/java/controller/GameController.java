package controller;

import controller.SavingMechanism.SavingMechanism;
import util.Map.MapBuilder;
import model.characters.heroEntity;
import view.ConsoleGameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {

    private ConsoleGameView consoleView = null;

    public void controllerStart(heroEntity hero) {
        consoleView = new ConsoleGameView();
        char[][] map = MapBuilder.generateMap(hero.getLevel());

        while(true) {
            MapBuilder.displayMap(map);
            consoleView.consoleMovementInterface();

            String userInput = getUserInput();
            switch (userInput) {
                case "1" : map = MapBuilder.changeMap(map, 1, hero); break;
                case "2" : map = MapBuilder.changeMap(map, 2, hero); break;
                case "3" : map = MapBuilder.changeMap(map, 3, hero); break;
                case "4" : map = MapBuilder.changeMap(map, 4, hero); break;
                case "5" : consoleView.printHeroStats(hero); break;
                case "9" :
                    SavingMechanism.getInstance().saveHero(hero);
                    System.out.println("Bye bye!");
                    System.exit(0);
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public String getUserInput() {
        String inputLine = null;
        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
        }
        catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}
