import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Accessories extends JLabel implements MouseListener, MouseMotionListener, Crafted_Spaces
{
    Point prevpt;
    int length, breadth;
    Accessories()
    {
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
        this.setBounds(0,0,150,100);
        this.setIcon(icon1);
    }

}
class lbed extends furniture
{
    lbed()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon2);
    }
}
class shelf1 extends furniture
{
    shelf1()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon3);
    }
}
class shelf2 extends furniture
{
    shelf2()
    {

        this.setBounds(0,0,150,100);
        this.setIcon(icon4);
    }
}
class sofa1 extends furniture
{
    sofa1()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon5);
    }
}
class sofa2 extends furniture
{
    sofa2()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon6);
    }
}
class sofa3 extends furniture
{
    sofa3()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon7);
    }
}
class table extends furniture
{
    table()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon8);
    }
}
class desk extends furniture
{
    desk()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon9);
    }
}
class bath extends furniture
{
    bath()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon10);
    }
}
class urinal extends furniture
{
    urinal()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon11);
    }
}
class sink extends furniture
{
    sink()
    {
        this.setBounds(0,0,150,100);
        this.setIcon(icon12);
    }
}

class window_comp extends window
{
}
class door extends window
{
}
