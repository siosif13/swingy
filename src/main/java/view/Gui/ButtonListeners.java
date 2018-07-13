package view.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListeners implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == GuiView.bNorth) {
            System.out.println("Merge nord");
        }
        if (e.getSource() == GuiView.bEast) {
            System.out.println("Merge est");
        }
        if (e.getSource() == GuiView.bSouth) {
            System.out.println("Merge sud");
        }
        if (e.getSource() == GuiView.bWest) {
            System.out.println("Merge west");
        }
        if (e.getSource() == StartMenuGui.exitgame) {
            System.exit(0);
        }
        if (e.getSource() == StartMenuGui.loadHero) {
            System.out.println("Peleu");
        }
    }
}
