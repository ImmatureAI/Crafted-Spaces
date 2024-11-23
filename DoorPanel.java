import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.*;
import java.awt.*;

public class DoorPanel extends JPanel{
    int doorLength;
    String pos;



    DoorPanel(String pos, int doorLength){
        this.doorLength = doorLength;
        this.pos = pos;
    }

    JPanel doorPanel(Room room, String pos){
        JPanel panel = new JPanel();
        switch(pos){
            case "North":
                panel.setBackground(Color.white);
                panel.setBounds(room.width/2 - doorLength/2,0,doorLength,5);
                //panel.setOpaque(true);
                panel.setVisible(true);
                //finalpt = this.getLocation();
                return panel;
            case "East":
                this.setBackground(Color.white);
                this.setBounds((room.width - 5),(room.height/2 - doorLength /2), 5, doorLength);
                this.setOpaque(true);
                //finalpt = this.getLocation();
                return this;
            case "South":
                this.setBackground(Color.white);
                this.setBounds((room.width/2 - doorLength /2), (room.height - 5), doorLength, 5);
                this.setOpaque(true);
                //finalpt = this.getLocation();
                return this;
            case "West":
                this.setBackground(Color.white);
                this.setBounds(0,(room.height/2 - doorLength /2), 5, doorLength);
                this.setOpaque(true);
                //finalpt = this.getLocation();
                return this;
            default:
                return null;
        }
    }
}
