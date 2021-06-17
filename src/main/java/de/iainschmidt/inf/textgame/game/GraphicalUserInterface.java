package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.frames.InventoryFrame;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class GraphicalUserInterface extends JFrame {

    private static final String TITLE = "Escape the Maxe";



    private GameFrame frame;

    List<Component> components = new ArrayList<>();

    public GraphicalUserInterface(GameFrame frame){
        setLayout(null);
        setVisible(true);
        setSize(800, 800);
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton map = new JButton("Karte");
        map.addActionListener(e -> {
            System.out.println("ZEIGE MAP AN");
        });
        map.setBounds(470, 360, 155, 30);
        add(map);
        JButton inventory = new JButton("Inventar");
        inventory.addActionListener(e -> {
            new RoomChangeAction(frame, new InventoryFrame(frame)).onClick();
        });
        inventory.setBounds(635, 360, 155, 30);
        add(inventory);
        update(frame);
    }

    private void clear(){
        for (Component component : components) {
            remove(component);
        }
        components.clear();
    }

    public void update(GameFrame frame){
        this.frame = frame;
        clear();

        //Title
        JLabel title = new JLabel(frame.getTitle());
        title.setBounds(10, 10, 380, 10);
        add(title);
        components.add(title);

        //Textarea
        JTextArea textArea = new JTextArea(frame.getText());
        textArea.setBounds(10, 30, 450, 350);
        textArea.setBorder(BorderFactory.createCompoundBorder(
                textArea.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        add(textArea);
        components.add(textArea);

        //IMGAGE
        ImageIcon imageIcon = new ImageIcon(frame.getImgPath());
        JLabel image = new JLabel();
        image.setIcon(imageIcon);
        image.setBounds(470, 30, 320 , 320);
        image.setVerticalAlignment(SwingConstants.TOP);
        add(image);
        components.add(image);



        int left = 500;
        int top = 400;
        int right = 500;
        int bottom = 600;

        for (Button button : frame.getButtons()) {
            switch (button.getOrientation()){
                case TOP:  {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(170, top, 250, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    top += 40;
                    break;
                }
                case BUTTON:  {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(170, bottom, 250, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    bottom += 40;
                    break;
                }
                case LEFT:  {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(10, left, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    left += 40;
                    break;
                }
                case RIGHT:  {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(430, right, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    right += 40;
                    break;
                }
            }
        }

        revalidate();
        repaint();
    }


}
