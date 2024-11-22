import javax.swing.*;
import java.awt.*;

public class DoorPanel extends JPanel{
    int doorLength;
    Room room;

    String[] positions = {"North", "East", "South", "West"};
    JComboBox<String> position = new JComboBox<>(positions);

    DoorPanel(Room r,int doorLength){
        this.doorLength = doorLength;
        this.room = r;
    }

    JPanel doorPanel(String pos){
        switch(pos){
            case "North":
                this.setBackground(Color.white);
                this.setBounds(room.width/2 - doorLength/2,0,doorLength,5);
                this.setOpaque(true);
                this.setVisible(true);
                return this;
            case "East":
                this.setBackground(Color.white);
                this.setBounds((room.width - 5),(room.height/2 - doorLength /2), 5, doorLength);
                this.setOpaque(true);
                return this;
            case "South":
                this.setBackground(Color.white);
                this.setBounds((room.width/2 - doorLength /2), (room.height - 5), doorLength, 5);
                this.setOpaque(true);
                return this;
            case "West":
                this.setBackground(Color.white);
                this.setBounds(0,(room.height/2 - doorLength /2), 5, doorLength);
                this.setOpaque(true);
                return this;
            default:
                return null;
        }
    }
}
