import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Accessories extends JLabel implements MouseListener, MouseMotionListener, Crafted_Spaces
{
    Point prevpt;
    Point finalpt;
    Point initialpt;
    int length;
    int breadth;
    Accessories()
    {
        accessoryHistory.add(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setOpaque(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        prevpt = e.getPoint();
        initialpt = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(Accessories a: accessoryHistory) {
            if(this.getX()>a.getX() && this.getX()< a.getX()+a.breadth){
                if((this.getY()>a.getY() && this.getY()<a.getY()+a.length) || (this.getY()+this.length>a.getY() && this.getY()+this.length<a.getY()+a.length)){
                    JOptionPane.showMessageDialog(null,"Overlap", "ERROR", JOptionPane.WARNING_MESSAGE);
                    this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
                }
            }
            if(this.getX()+this.breadth>a.getX() && this.getX()+this.breadth < a.getX()+a.breadth){
                if((this.getY()>a.getY() && this.getY()<a.getY()+a.length) || (this.getY()+this.length>a.getY() && this.getY()+this.length<a.getY()+a.length)){
                    JOptionPane.showMessageDialog(null,"Overlap", "ERROR", JOptionPane.WARNING_MESSAGE);
                    this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
                }
            }
        }

        for( Room rooms: history ) {
            if(this.getX() < rooms.getX() + rooms.width && this.getX() + this.breadth > rooms.getX() + rooms.width )
            {
                JOptionPane.showMessageDialog(null,"Object cannot be placed between rooms", "ERROR", JOptionPane.WARNING_MESSAGE);
                this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
            }
            if(this.getY() < rooms.getY() + rooms.height && this.getY() + this.length > rooms.getY() + rooms.height )
            {
                JOptionPane.showMessageDialog(null,"Object cannot be placed between rooms", "ERROR", JOptionPane.WARNING_MESSAGE);
                this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
            }
            if(this.getX()< rooms.getX() && this.getX() + this.breadth > rooms.getX() )
            {
                JOptionPane.showMessageDialog(null,"Object cannot be placed between rooms", "ERROR", JOptionPane.WARNING_MESSAGE);
                this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
            }
            if(this.getY()< rooms.getY() && this.getY() + this.length > rooms.getY() )
            {
                JOptionPane.showMessageDialog(null,"Object cannot be placed between rooms", "ERROR", JOptionPane.WARNING_MESSAGE);
                this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
            }
        }

        finalpt = this.getLocation();
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

class furniture extends Accessories
{

}
class window extends Accessories
{

}

class sbed extends furniture
{
    sbed()
    {
        length = icon1.getIconHeight();
        breadth = icon1.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon1);
    }

}
class lbed extends furniture
{
    lbed()
    {
        length = icon2.getIconHeight();
        breadth = icon2.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon2);
    }
}
class shelf1 extends furniture
{
    shelf1()
    {
        length = icon3.getIconHeight();
        breadth = icon3.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon3);
    }
}
class shelf2 extends furniture
{
    shelf2()
    {
        length = icon4.getIconHeight();
        breadth = icon4.getIconWidth();

        this.setBounds(0,0,80,100);
        this.setIcon(icon4);
    }
}
class sofa1 extends furniture
{
    sofa1()
    {
        length = icon5.getIconHeight();
        breadth = icon5.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon5);
    }
}
class sofa2 extends furniture
{
    sofa2()
    {
        length = icon6.getIconHeight();
        breadth = icon6.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon6);
    }
}
class sofa3 extends furniture
{
    sofa3()
    {
        length = icon7.getIconHeight();
        breadth = icon7.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon7);
    }
}
class table extends furniture
{
    table()
    {
        length = icon8.getIconHeight();
        breadth = icon8.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon8);
    }
}
class desk extends furniture
{
    desk()
    {
        length = icon9.getIconHeight();
        breadth = icon9.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon9);
    }
}
class bath extends furniture
{
    bath()
    {
        length = icon10.getIconHeight();
        breadth = icon10.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon10);
    }
}
class urinal extends furniture
{
    urinal()
    {
        length = icon11.getIconHeight();
        breadth = icon11.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon11);
    }
}
class sink extends furniture
{
    sink()
    {
        length = icon12.getIconHeight();
        breadth = icon12.getIconWidth();
        this.setBounds(0,0,80,100);
        this.setIcon(icon12);
    }
}

class window_comp extends window
{
}
class door extends window
{
}
