package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.DisplayableFrame;
import de.iainschmidt.inf.textgame.framework.Inventoryable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Iain Schmidt
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 * <br>
 * Provider for GUI, handels all the rendering tasks
 */
public class GraphicalUserInterface extends JFrame {

    private static final String TITLE = "Escape the Maxe";
    final List<Component> components = new ArrayList<>();
    private DisplayableFrame frame;

    /**
     * Initionalises the JFrame
     * @param frame Start frame
     */
    public GraphicalUserInterface(DisplayableFrame frame) {
        //jFrame setup
        setLayout(null);
        setVisible(true);
        setSize(810, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Inventory title
        JLabel inv = new JLabel("Dein Inventar:");
        inv.setBounds(600, 400, 155, 10);
        add(inv);

        //initialize first frame
        update(frame);
    }

    //remove all frame-related Components
    private void clear() {
        for (Component component : components) {
            remove(component);
        }
        components.clear();
    }

    /**
     * This renders as new Frame <br> executes {@link GraphicalUserInterface#clear()}
     * @param frame The new {@link DisplayableFrame frame}
     */
    public void update(DisplayableFrame frame) {
        //internal stuff
        this.frame = frame;
        frame.setVisited(true);
        clear();

        //Title of the Room
        JLabel title = new JLabel(frame.getTitle());
        title.setBounds(10, 10, 380, 10);
        add(title);
        components.add(title);

        //Updates inventory List
        JList<String> inventoryList = new JList<>();
        inventoryList.setListData(TextGame.getInstance().getInventory().stream().map(Item::getDisplayname).toArray(String[]::new));
        inventoryList.setLayoutOrientation(JList.VERTICAL);
        inventoryList.setVisible(true);
        inventoryList.setVisibleRowCount(-1);
        inventoryList.setBounds(600, 410, 155, 300);
        add(inventoryList);
        components.add(inventoryList);


        //Desctiption
        StringBuilder txt = new StringBuilder(frame.getText());

        //Adds room-inventory to the description, adds takeitem button
        JButton takeItem = new JButton("Item nehmen");
        takeItem.setEnabled(false);
        if (frame instanceof Inventoryable) {
            if (((Inventoryable) frame).getItems() != null) {
                txt.append("\n\nItems im Raum:\n");
                for (Item item : ((Inventoryable) frame).getItems()) {
                    txt.append("- 1x ").append(item.getDisplayname()).append("\n");
                }
                if (((Inventoryable) frame).getItems().size() >= 1) {
                    takeItem.addActionListener(e -> {
                        Item item = ((Inventoryable) frame).getItems().get(0);
                        TextGame.getInstance().getInventory().add(item);
                        ((Inventoryable) frame).getItems().remove(item);
                        update(frame);
                    });
                    takeItem.setEnabled(true);
                }
            }
        }
        takeItem.setBounds(600, 360, 155, 30);
        add(takeItem);
        components.add(takeItem);


        //Textarea for descruption
        JTextArea textArea = new JTextArea(txt.toString());
        textArea.setBounds(10, 30, 450, 350);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createCompoundBorder(
                textArea.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
        components.add(textArea);

        //Loading Image
        ImageIcon imageIcon = new ImageIcon(frame.getImgPath());
        JLabel image = new JLabel();
        image.setIcon(imageIcon);
        image.setBounds(470, 30, 320, 320);
        image.setVerticalAlignment(SwingConstants.TOP);
        add(image);
        components.add(image);


        //Render Buttons
        int left = 500;
        int top = 400;
        int right = 500;
        int bottom = 600;
        int special = 400;
        for (Button button : frame.getButtons()) {
            switch (button.getOrientation()) {
                case SPECIAL -> {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(430, special, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    special += 40;
                }
                case TOP -> {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(170, top, 250, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    top += 40;
                }
                case BUTTON -> {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(170, bottom, 250, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    bottom += 40;
                }
                case LEFT -> {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(10, left, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    left += 40;
                }
                case RIGHT -> {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(430, right, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    right += 40;
                }
            }
        }

        //Reload the JFrame
        revalidate();
        repaint();
    }


}
