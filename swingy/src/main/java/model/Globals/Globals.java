package model.Globals;


public class Globals {

    public static int isGui;
    public static int size;

    public static void setMapSize(int heroLevel) {

        Globals.size = (heroLevel - 1) * 5 + 10 - (heroLevel%2);
    }
}
