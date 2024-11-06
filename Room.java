import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Room extends JPanel implements MouseListener, MouseMotionListener
{
    Point prevpt;

    Room()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        prevpt = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(1230,75,150,100);
        this.setBackground(new Color(255, 171, 171, 255));
        this.setOpaque(true);
    }
}
class Bathroom extends Room
{
    Bathroom()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(1230,275,150,100);
        this.setBackground(new Color(190, 236, 255, 255));
    }
}
class DrawingRoom extends Room
{
    DrawingRoom()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(1230,175,150,100);
        this.setBackground(new Color(255, 218, 176, 255));
    }
}
class Garage extends Room
{
    Garage()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(1230,575,150,100);
        this.setBackground(new Color(217, 189, 253, 255));
    }
}
class Bedroom extends Room
{
    Bedroom()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBackground(new Color(194, 255, 200, 255));
    }
}
class Sbedroom extends Bedroom
{
    Sbedroom()
    {
        this.setBounds(1230,375,150,100);
    }
}
class Lbedroom extends Bedroom
{
    Lbedroom()
    {
        this.setBounds(1230, 475, 150, 100);
    }
}
