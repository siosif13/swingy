package view.Gui;

import javax.swing.*;
import java.awt.*;

public class CreateHeroGui extends JPanel {

    public CreateHeroGui() {

        this.setPreferredSize(new Dimension(1280, 720));
        ImagePanel image = new ImagePanel("src/main/Images/menuPhoto.jpg");
        this.setLayout(new BorderLayout());
        this.add(image, BorderLayout.CENTER);
        JTextField userInput = new JTextField();
        //userInput.
        this.add(userInput, BorderLayout.SOUTH);
    }
}
