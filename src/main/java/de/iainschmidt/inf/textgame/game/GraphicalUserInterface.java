package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Inventoryable;
import de.iainschmidt.inf.textgame.game.frames.InventoryFrame;

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
    List<Component> components = new ArrayList<>();
    private GameFrame frame;

    public GraphicalUserInterface(GameFrame frame) {
        setLayout(null);
        setVisible(true);
        setSize(800, 800);
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel inv = new JLabel("Dein Inventar:");
        inv.setBounds(600, 400, 155, 10);
        add(inv);
        update(frame);
    }

    private void clear() {
        for (Component component : components) {
            remove(component);
        }
        components.clear();
    }

    public void update(GameFrame frame) {
        this.frame = frame;
        frame.setVisited(true);
        clear();

        //Title
        JLabel title = new JLabel(frame.getTitle());
        title.setBounds(10, 10, 380, 10);
        add(title);
        components.add(title);

        JList<String> inventoryList = new JList<>();

        inventoryList.setListData(TextGame.getInstance().getInventory().stream().map(Item::getDisplayname).toArray(String[]::new));

        inventoryList.setLayoutOrientation(JList.VERTICAL);
        inventoryList.setVisible(true);
        inventoryList.setVisibleRowCount(-1);
        inventoryList.setBounds(600, 410, 155, 300);
        add(inventoryList);
        components.add(inventoryList);

        StringBuilder txt = new StringBuilder(frame.getText());

        JButton map = new JButton("Item nehmen");
        map.setEnabled(false);
        if (frame instanceof Inventoryable) {
            if (((Inventoryable) frame).getItems() != null) {
                txt.append("\n\nItems im Raum:\n");
                for (Item item : ((Inventoryable) frame).getItems()) {
                    txt.append("- 1x ").append(item.getDisplayname()).append("\n");
                }

                if (((Inventoryable) frame).getItems().size() >= 1) {
                    map.addActionListener(e -> {
                        Item item = ((Inventoryable) frame).getItems().get(0);
                        TextGame.getInstance().getInventory().add(item);
                        ((Inventoryable) frame).getItems().remove(item);
                        update(frame);
                    });
                    map.setEnabled(true);
                }
            }

        }
        map.setBounds(600, 360, 155, 30);
        add(map);
        components.add(map);
        //Textarea
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
        //IMGAGE
        ImageIcon imageIcon = new ImageIcon(frame.getImgPath());
        JLabel image = new JLabel();
        image.setIcon(imageIcon);
        image.setBounds(470, 30, 320, 320);
        image.setVerticalAlignment(SwingConstants.TOP);
        add(image);
        components.add(image);


        int left = 500;
        int top = 400;
        int right = 500;
        int bottom = 600;
        int special = 400;

        for (Button button : frame.getButtons()) {
            switch (button.getOrientation()) {
                case SPECIAL: {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(430, special, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    special += 40;
                    break;
                }
                case TOP: {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(170, top, 250, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    top += 40;
                    break;
                }
                case BUTTON: {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(170, bottom, 250, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    bottom += 40;
                    break;
                }
                case LEFT: {
                    JButton jButton = new JButton(button.getText());
                    jButton.setBounds(10, left, 150, 30);
                    add(jButton);
                    jButton.addActionListener(e -> button.getAction().onClick());
                    components.add(jButton);
                    left += 40;
                    break;
                }
                case RIGHT: {
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

    public void openInventory() {
        if (frame instanceof InventoryFrame) {
            update(((InventoryFrame) frame).prev);
        } else {
            update(new InventoryFrame(this.frame));
        }
    }


}
