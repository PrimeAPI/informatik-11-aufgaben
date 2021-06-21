package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.game.KeyLevel;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomFactory {


    public static RoomFactory create(String title, String desc, String image){
        return new RoomFactory().setTitle(title).setDesc(desc).setImage(image);
    }


    String title;
    String describtion;
    String image;
    HashMap<String, Room> buttons = new HashMap<>();
    KeyLevel key = null;

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

    public RoomFactory addButton(String name, Room room){
        buttons.put(name, room);
        return this;
    }








    public GameFrame build(){
        if(key == null){
            return new GameFrame() {
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
                    List<Button> list = new ArrayList<>();
                    for (Map.Entry<String, Room> entry : buttons.entrySet()) {
                        String s = entry.getKey();
                        Room room = entry.getValue();

                        list.add(new RoomChangeButton(s, this, room, ButtonOrientation.TOP));
                    }
                    return (Button[]) list.toArray();
                }
            };
        }else {
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
                    return (Button[]) buttons.toArray();
                }

                @Override
                public KeyLevel getKeyLevel() {
                    return key;
                }
            };
        }
    }

}
