package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.KeyLevel;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

import java.util.*;
import java.util.stream.Collectors;

public class RoomFactory {


    public static RoomFactory create(String title, String desc, String image){
        return new RoomFactory().setTitle(title).setDesc(desc).setImage(image);
    }


    String title;
    String describtion;
    String image;
    List<SimpleButton> buttons = new ArrayList<>();
    KeyLevel key = null;
    ArrayList<Item> items;

    public RoomFactory setTitle(String title){
        this.title = title;
        return this;
    }

    public RoomFactory setDesc(String desc){
        this.describtion = desc;
        return this;
    }

    public RoomFactory setImage(String image){
        this.image = image;
        return this;
    }


    public RoomFactory setKeyLevel(KeyLevel level){
        this.key = level;
        return this;
    }

    public RoomFactory addButton(String name, Room room, ButtonOrientation orientation){
        buttons.add(new SimpleButton(name, room, orientation));
        return this;
    }

    public RoomFactory setItems(Item... items){
        this.items = new ArrayList<>(Arrays.asList(items));
        return this;
    }








    public GameFrame build(){
        if(key == null){
            return new GameFrameImpl() {
                @Override
                public String getRoomName() {
                    return title;
                }

                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public String getText() {
                    return describtion;
                }

                @Override
                public String getImgPath() {
                    return image;
                }

                @Override
                public Button[] getButtons() {
                    return buttons.stream()
                            .map(button -> new RoomChangeButton(button.getTitle(), this, button.getTarget(), button.getOrientation())).toArray(Button[]::new);
                }

                ArrayList<Item> items = RoomFactory.this.items;

                @Override
                public ArrayList<Item> getItems() {
                    return items;
                }

                @Override
                public void removeItem(Item item) {
                    items.remove(item);
                }
            };
        }else {
            return new GameFrameImplLockable() {
                @Override
                public KeyLevel getKeyLevel() {
                    return key;
                }

                @Override
                public String getRoomName() {
                    return title;
                }

                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public String getText() {
                    return describtion;
                }

                @Override
                public String getImgPath() {
                    return image;
                }

                @Override
                public Button[] getButtons() {
                    return buttons.stream()
                            .map(button -> new RoomChangeButton(button.getTitle(), this, button.getTarget(), button.getOrientation())).toArray(Button[]::new);
                }
                ArrayList<Item> items = RoomFactory.this.items;

                @Override
                public ArrayList<Item> getItems() {
                    return items;
                }

                @Override
                public void removeItem(Item item) {
                    items.remove(item);
                }
            };
        }
    }

}
