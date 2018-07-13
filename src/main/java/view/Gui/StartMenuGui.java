package view.Gui;

import javax.swing.*;
import java.awt.*;

public class StartMenuGui extends JPanel {

    public static JPanel buttonContainer;
    public static JPanel menuContainer;
    public static JButton newHero;
    public static JButton loadHero;

    public static JButton exitgame;


    public void initialize() {
        buttonContainer = new JPanel();
        buttonContainer.setPreferredSize(new Dimension(1024, 50));
        buttonContainer.setBackground(Color.BLACK);
        buttonContainer.setLayout(new FlowLayout());
        newHero = new JButton("Create a new hero");
        buttonContainer.add(newHero);
        loadHero = new JButton("Load hero");
        loadHero.addActionListener(new ButtonListeners());
        buttonContainer.add(loadHero);
        exitgame = new JButton("Exit");
        exitgame.addActionListener(new ButtonListeners());
        buttonContainer.add(exitgame);

        menuContainer = new JPanel();
        menuContainer.setPreferredSize(new Dimension(1280, 720));
        menuContainer.setLayout(new BorderLayout());
        menuContainer.add(buttonContainer, BorderLayout.SOUTH);

        ImagePanel background = new ImagePanel("src/main/Images/menuPhoto.jpg");
        menuContainer.add(background, BorderLayout.CENTER);

        this.add(menuContainer);
        this.setVisible(true);
    }
}
