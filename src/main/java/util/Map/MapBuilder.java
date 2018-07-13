package util.Map;

import controller.Fighting.FightingMechanism;
import controller.Providers.MobProvider;
import model.Globals.Globals;
import model.characters.heroEntity;
import model.characters.villainEntity;
import view.Gui.GuiView;

import java.awt.*;

import static util.Colors.Colors.*;

public class MapBuilder {

    static int [][] beenHere;

    public static char[][] generateMap(int level) {

        Globals.size = (level - 1) * 5 + 10 - (level%2);
        char[][] map = new char[Globals.size][Globals.size];
        int center = Globals.size/2;

        for (int i = 0; i < Globals.size; i++) {
            for (int j = 0; j< Globals.size; j++) {
                map[i][j] = '#';
            }
        }
        int way = (int) (Math.random() * 5) + 1;
        int x = center;
        int y = center;

        while (way != 0) {

            int nb = (int) (Math.random() * 4);
            switch (nb) {
                case 0 : y--; map[y][x] = '~'; break;
                case 1 : x++; map[y][x] = '~'; break;
                case 2 : y++; map[y][x] = '~'; break;
                case 3 : x--; map[y][x] = '~'; break;
            }
            if (x == 0 || x == Globals.size - 1 || y == 0 || y == Globals.size - 1) {
                way--;
                map[y][x] = '*';
                x = center;
                y = center;
            }
        }

        for (int i = 0; i < Globals.size; i++) {
            for (int j = 0; j < Globals.size; j++) {
                if (map[i][j] == '~' && (int) (Math.random() * 4) == 1)
                    map[i][j] = 'Q';
            }
        }

        map[center][center] = 'X';

        MapBuilder.beenHere = new int [Globals.size][Globals.size];
        for (int i = 0; i < Globals.size; i++) {
            for (int j = 0; i < Globals.size; i++) {
                beenHere[i][j] = 0;
            }
        }

        return map;
    }

    public static char[][] changeMap(char[][] map, int direction, heroEntity hero) {

        //int Globals.size = map.length;
        char[][] tmpMap = map;
        int y = 0;
        int x = 0;

        for(int i = 0; i < Globals.size; i++) {
            for (int j = 0; j < Globals.size; j++)
                if (tmpMap[i][j] == 'X') {
                    y = i;
                    x = j;
                    break;
                }
        }

        switch (direction) {

            case 1 :
                if (y - 1 == 0 && tmpMap[y-1][x] == '*') {
                    System.out.print("Generate new map here");
                    tmpMap = MapBuilder.generateMap(hero.getLevel());
  //                  Globals.gui.resetGuiMap();
                    return tmpMap;
                } else if (y - 1 > 0 && tmpMap[y-1][x] == '~') {
                    tmpMap[y][x] = '~';
                    beenHereFunction(y, x);
                    tmpMap[y - 1][x] = 'X';
//                    Globals.gui.resetGuiMap();
                } else if (tmpMap[y-1][x] == ' ')
                    System.out.println("There is a wall here");
                else if (tmpMap[y-1][x] == 'Q') {
                    villainEntity villain = MobProvider.provideVillain();
                   hero = FightingMechanism.fight(hero, villain);
                   if (hero != null) {
                       tmpMap[y-1][x] = 'X';
                       tmpMap[y][x] = '~';
                   }
                }
                break;
            case 2 :
                if (x + 1 == Globals.size - 1 && tmpMap[y][x + 1] == '*') {
                    System.out.print("Generate new map here");
                    tmpMap = MapBuilder.generateMap(hero.getLevel());
 //                   Globals.gui.resetGuiMap();
                    return tmpMap;
                } else if (x + 1 < Globals.size - 1 && tmpMap[y][x + 1] == '~') {
                    tmpMap[y][x] = '~';
                    beenHereFunction(y, x);
                    tmpMap[y][x + 1] = 'X';
//                    Globals.gui.resetGuiMap();
                } else if (tmpMap[y][x + 1] == ' ')
                    System.out.println("There is a wall here");
                else if (tmpMap[y][x + 1] == 'Q') {
                    villainEntity villain = MobProvider.provideVillain();
                   hero = FightingMechanism.fight(hero, villain);
                   if (hero != null) {
                       tmpMap[y][x + 1] = 'X';
                        tmpMap[y][x] = '~';
                    }
                }
                break;
            case 3 :
                if (y + 1 == Globals.size - 1 && tmpMap[y + 1][x] == '*') {
                    System.out.print("Generate new map here");
                    tmpMap = MapBuilder.generateMap(hero.getLevel());
     //               Globals.gui.resetGuiMap();
                    return tmpMap;
                } else if (y + 1 < Globals.size - 1 && tmpMap[y + 1][x] == '~') {
                    tmpMap[y][x] = '~';
                    beenHereFunction(y, x);
                    tmpMap[y + 1][x] = 'X';
   //                 Globals.gui.resetGuiMap();
                } else if (tmpMap[y + 1][x] == ' ')
                    System.out.println("There is a wall here");
                else if (tmpMap[y + 1][x] == 'Q') {
                    villainEntity villain = MobProvider.provideVillain();
                   hero = FightingMechanism.fight(hero, villain);
                   if (hero != null) {
                       tmpMap[y + 1][x] = 'X';
                       tmpMap[y][x] = '~';
                   }
                }
                break;
            case 4 :
                if (x - 1 == 0 && tmpMap[y][x - 1] == '*') {
                    System.out.print("Generate new map here");
                    tmpMap = MapBuilder.generateMap(hero.getLevel());
  //                  Globals.gui.resetGuiMap();
                    return tmpMap;
                } else if (x - 1 > 0 && tmpMap[y][x - 1] == '~') {
                    tmpMap[y][x] = '~';
                    beenHereFunction(y, x);
                    tmpMap[y][x - 1] = 'X';
    //                Globals.gui.resetGuiMap();
                } else if (tmpMap[y][x - 1] == ' ')
                    System.out.println("There is a wall here");
                else if (tmpMap[y][x - 1] == 'Q') {
                    villainEntity villain = MobProvider.provideVillain();
                   hero = FightingMechanism.fight(hero, villain);
                   if (hero != null) {
                       tmpMap[y][x - 1] = 'X';
                       tmpMap[y][x] = '~';
                   }
                }
                break;
        }
        return tmpMap;
    }

    private static void beenHereFunction(int y, int x) {

        MapBuilder.beenHere[y][x] = 1;
        MapBuilder.beenHere[y + 1][x + 1] = 1;
        MapBuilder.beenHere[y + 1][x] = 1;
        MapBuilder.beenHere[y + 1][x - 1] = 1;
        MapBuilder.beenHere[y][x + 1] = 1;
        MapBuilder.beenHere[y][x - 1] = 1;
        MapBuilder.beenHere[y - 1][x + 1] = 1;
        MapBuilder.beenHere[y - 1][x] = 1;
        MapBuilder.beenHere[y - 1][x - 1] = 1;
    }

    public static void displayMap(char[][] map) {

          //int Globals.size = map.length;
//        for (int y = 0; y < Globals.size; y++) {
//            System.out.print("\n");
//            for (int x = 0; x < Globals.size; x++) {
//                System.out.print(map[y][x]);          // <<< -----------      For easy mode
//                System.out.print(' ');
//            }
//
//        }

        for (int y = 0; y < Globals.size; y++) {
           System.out.print("\n");
            for (int x = 0; x < Globals.size; x++) {

                //if (x > 0 && y > 0 && x < Globals.size - 1 && y < Globals.size - 1)
                if (map[y][x] == 'X' || (y < Globals.size - 1 && x < Globals.size - 1 && map[y + 1][x + 1] == 'X')
                        || (y < Globals.size - 1 && map[y + 1][x] == 'X')
                    || (y < Globals.size - 1 && x > 0 && map[y + 1][x - 1] == 'X')
                        || (x < Globals.size - 1 && map[y][x + 1] == 'X')
                        || (x > 0 && map[y][x - 1] == 'X')
                    || (y > 0 && x < Globals.size - 1 && map[y - 1][x + 1] == 'X') ||
                        (y > 0 && map[y - 1][x] == 'X') ||
                        (y > 0 && x > 0 && map[y - 1][x - 1] == 'X')) {

                    if (map[y][x] == 'X') {
                       // GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.GREEN);
                        System.out.print(ANSI_GREEN + 'X' + ANSI_RESET);
                    } else if (map[y][x] == 'Q') {
                        //GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.RED);
                        System.out.print(ANSI_RED + 'Q' + ANSI_RESET);
                    } else if (map[y][x] == '#') {
                       // GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.ORANGE);
                        System.out.print(ANSI_YELLOW + '#' + ANSI_RESET);
                    } else if (map[y][x] == '*') {
                       // GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.MAGENTA);
                        System.out.print(ANSI_PURPLE + '*' + ANSI_RESET);
                    } else {
                       // GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.white);
                        System.out.print(map[y][x]);
                    }
                }
                else if (MapBuilder.beenHere[y][x] == 1) {
                    if (map[y][x] == '#') {
//                        GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.ORANGE);
                    } else if (map[y][x] == 'Q') {
//                        GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.RED);
                    } else {
 //                       GuiView.blockList.get(MapBuilder.findPosition(y, x)).setBackground(Color.gray);
                    }
                    System.out.print(map[y][x]);
                } else
                    System.out.print(' ');
                System.out.print(' ');
            }
        }
    }

    public static int findPosition(int y, int x) {

        int ret = Globals.size * y + x;
        return ret;
    }
}
