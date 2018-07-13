package view.Gui;

import model.Globals.Globals;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class GuiView extends JFrame {

//    public static void main(String[] args) {
//        new GuiView();
//    }

    public static JPanel generalContainer;
    public static JPanel gamePanel;
    public static ArrayList<JPanel> blockList;
    public static JPanel westContainer;
    public static JPanel eastContainer;
    public static JPanel buttonContainer;
    public static JButton bNorth;
    public static JButton bWest;
    public static JButton bSouth;
    public static JButton bEast;
    public static JTextArea combatLog;
    public static JScrollPane combatScroll;
    public static ImagePanel image;
    public static PrintStream customStream;

    // Aici mai pui niste statice in care adaugi panelurile custom

    public void resetGuiMap() {
        gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(700, 700));
        gamePanel.setLayout(new GridLayout(Globals.size, Globals.size));
        blockList = new ArrayList<>();
        JPanel tmp = null;
        for (int i = 0; i < (Globals.size * Globals.size); i++) {
            tmp = new JPanel();
            gamePanel.add(tmp);
            blockList.add(tmp);
        }
        for (JPanel j : blockList) {
            j.setBackground(Color.BLACK);
        }
        generalContainer.add(gamePanel, BorderLayout.CENTER);

        this.add(generalContainer);
        this.validate();

    }

    public void switchGUI(int a) {
        if (a == 0) {
            this.setVisible(false);
        } else if (a == 1) {
            this.setVisible(true);
        }
    }

    public GuiView() {

        this.setTitle("MyRPG");
        this.setPreferredSize(new Dimension(1280, 720));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        generalContainer = new JPanel();
        westContainer = new JPanel();
        eastContainer = new JPanel();
        buttonContainer = new JPanel();
        combatLog = new JTextArea();
        combatScroll = new JScrollPane(combatLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bNorth = new JButton("North");
        bSouth = new JButton("South");
        bEast = new JButton("East");
        bWest = new JButton("West");

        String path = "src/main/Images/warrior.png"; // <-- Aici e posibil sa ai problema pt ca e in dir si nu in package
        image = new ImagePanel(path);

//        gamePanel.setLayout(new GridLayout(Globals.size, Globals.size));
//        blockList = new ArrayList<>();
//        JPanel tmp = null;
//        for (int i = 0; i < (Globals.size * Globals.size); i++) {
//            tmp = new JPanel();
//            gamePanel.add(tmp);
//            blockList.add(tmp);
//        }
//        for (JPanel j : blockList) {
//                j.setBackground(Color.BLACK);
//        }


        generalContainer.setLayout(new BorderLayout());
        westContainer.setLayout(new BorderLayout());
        eastContainer.setLayout(new BorderLayout());
        buttonContainer.setLayout(new BorderLayout());

        bNorth.addActionListener(new ButtonListeners());
        bEast.addActionListener(new ButtonListeners());
        bWest.addActionListener(new ButtonListeners());
        bSouth.addActionListener(new ButtonListeners());

        buttonContainer.add(bNorth, BorderLayout.NORTH);
        buttonContainer.add(bEast, BorderLayout.EAST);
        buttonContainer.add(bSouth, BorderLayout.SOUTH);
        buttonContainer.add(bWest, BorderLayout.WEST);

        combatLog.setLineWrap(true);

        eastContainer.setPreferredSize(new Dimension(280, 700));
        eastContainer.add(combatScroll, BorderLayout.CENTER);

        westContainer.setPreferredSize(new Dimension(280, 700));
        westContainer.add(image, BorderLayout.CENTER);
        westContainer.add(buttonContainer, BorderLayout.SOUTH);

        generalContainer.setPreferredSize(new Dimension(1280, 720));
        generalContainer.add(westContainer, BorderLayout.WEST);

        generalContainer.add(eastContainer, BorderLayout.EAST);

        resetGuiMap();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
