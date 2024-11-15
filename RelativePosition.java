import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RelativePosition extends JPanel {
    JComboBox<String> roomchecks;

    String[] positions = {"North", "East", "South", "West"};
    JComboBox<String> position = new JComboBox<>(positions);

    String[] alignments = {"Center", "Left", "Right"};
    JComboBox<String> alignment = new JComboBox<>(alignments);

    RelativePosition(ArrayList<Room> rooms, int numberofrooms){
        String[] r = new String[numberofrooms];
        int i = 0;
        for(Room rs:rooms){
            r[i] = "Room " + String.valueOf(i+1);
            i++;
        }
        roomchecks = new JComboBox<>(r);

        this.add(roomchecks);
        this.add(position);
        this.add(alignment);

    }

    public Point changeposition(Room roomrespect, String direction, String align, Room room){
        Point point = new Point();
        switch(direction){
            case "North":   switch(align){
                                case "Left":    point.x = roomrespect.getX();
                                                point.y = roomrespect.getY()-room.height;break;

                                case "Right":   point.x = roomrespect.getX()+roomrespect.width-room.width;
                                                point.y = roomrespect.getY()-room.height;break;

                                case "Center":  point.x = roomrespect.getX()+roomrespect.width/2 - room.width/2;
                                                point.y = roomrespect.getY()-room.height;break;
                            }break;

            case "West":    switch(align){
                                case "Left":    point.x = roomrespect.getX()-room.width;
                                                point.y = roomrespect.getY()+roomrespect.height-room.height;break;

                                case "Right":   point.x = roomrespect.getX()-room.width;
                                                point.y = roomrespect.getY();break;

                                case "Center":  point.x = roomrespect.getX()-room.width;
                                                point.y = roomrespect.getY()+roomrespect.height/2 - room.height/2;break;
                            }break;

            case "South":   switch(align){
                                case "Right":   point.x = roomrespect.getX();
                                                point.y = roomrespect.getY()+roomrespect.height;break;

                                case "Left":    point.x = roomrespect.getX()+roomrespect.width-room.width;
                                                point.y = roomrespect.getY()+roomrespect.height;break;

                                case "Center":  point.x = roomrespect.getX()+roomrespect.width/2 - room.width/2;
                                                point.y = roomrespect.getY()+roomrespect.height;break;
                            }break;

            case "East":    switch(align){
                                case "Right":   point.x = roomrespect.getX()+roomrespect.width;
                                                point.y = roomrespect.getY()+roomrespect.height-room.height;break;

                                case "Left":    point.x = roomrespect.getX()+roomrespect.width;
                                                point.y = roomrespect.getY();break;

                                case "Center":  point.x = roomrespect.getX()+roomrespect.width;
                                                point.y = roomrespect.getY()+roomrespect.height/2 - room.height/2;break;
                            }break;
        }
        return point;
    }
}