import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Room extends JPanel implements MouseListener, MouseMotionListener, Crafted_Spaces
{
    Point prevpt;
    Point initialpoint;
    int width,height;

    Room()
    {
        history.add(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        prevpt = e.getPoint();
        initialpoint = this.getLocation();
        if(SwingUtilities.isRightMouseButton(e))
        {
            int x = this.width;
            this.width = this.height;
            this.height = x;
            this.setBounds(this.getX(),this.getY(),this.width,this.height);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(Room room : history) {
            if(this.getX()>room.getX() && this.getX()< room.getX()+room.width){
                if((this.getY()>room.getY() && this.getY()<room.getY()+room.height) || (this.getY()+this.height>room.getY() && this.getY()+this.height<room.getY()+room.height)){
                    this.setBounds(initialpoint.x, initialpoint.y, this.width, this.height);
                }
            }
            if(this.getX()+this.width>room.getX() && this.getX()+this.width < room.getX()+room.width){
                if((this.getY()>room.getY() && this.getY()<room.getY()+room.height) || (this.getY()+this.height>room.getY() && this.getY()+this.height<room.getY()+room.height)){
                    this.setBounds(initialpoint.x, initialpoint.y, this.width, this.height);
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = this.getX() + e.getX() - prevpt.x;
        int y = this.getY() + e.getY() - prevpt.y;
        this.setLocation(x,y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

class Kitchen extends Room
{
    Kitchen()
    {
        width = 150;
        height = 100;
        this.setBounds(1230,75,width,height);
        this.setBackground(new Color(255, 171, 171, 255));
    }
}
class Bathroom extends Room
{
    Bathroom()
    {
        width = 150;
        height = 100;
        this.setBounds(1230,350,width,height);
        this.setBackground(new Color(190, 236, 255, 255));
    }
}
class DrawingRoom extends Room
{
    DrawingRoom()
    {
        width = 150;
        height = 100;
        this.setBounds(1230,175,width,height);
        this.setBackground(new Color(255, 218, 176, 255));
    }
}
class Garage extends Room
{
    Garage()
    {
        width = 150;
        height = 100;
        this.setBounds(1230,575,width,height);
        this.setBackground(new Color(217, 189, 253, 255));
    }
}
class Bedroom extends Room
{
    Bedroom(int width, int height, int y)
    {
        this.width = width;
        this.height = height;
        this.setBounds(1230,y,width,height);
        this.setBackground(new Color(194, 255, 200, 255));
    }
}
