import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Room extends JPanel implements MouseListener, MouseMotionListener, Crafted_Spaces
{
    Point prevpt;
    Point initialpoint;
    Point finalpt;
    int width,height;
    static int numberofrooms=0;
    int spacewidth, spaceheight;;

    Room(int spacewidth, int spaceheight)
    {
        history.add(this);
        this.spacewidth = spacewidth;
        this.spaceheight = spaceheight;
        this.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        JLabel label = new JLabel();
        label.setText(String.valueOf(numberofrooms+1));
        this.add(label);
        this.setOpaque(true);
        numberofrooms++;
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
        if(SwingUtilities.isMiddleMouseButton(e)){
            RelativePosition relpos = new RelativePosition(history, numberofrooms);
            int result = JOptionPane.showOptionDialog(null, relpos, "Relative Position", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,0);
            this.setVisible(true);
            if(result==0){
                this.setLocation(relpos.changeposition(history.get(relpos.roomchecks.getSelectedIndex()), (String)relpos.position.getSelectedItem(), (String)relpos.alignment.getSelectedItem(), this));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(Room room : history) {
            if((this.getX()>room.getX() && this.getX()< room.getX()+room.width - 5) || (this.getX()+this.width-5>room.getX() && this.getX()+this.width < room.getX()+room.width)){
                if((this.getY()>room.getY() && this.getY()<room.getY()+room.height - 5) || (this.getY()+this.height-5>room.getY() && this.getY()+this.height<room.getY()+room.height)){
                    JOptionPane.showMessageDialog(null,"Overlap", "ERROR", JOptionPane.WARNING_MESSAGE);
                    this.setBounds(initialpoint.x, initialpoint.y, this.width, this.height);
                }
            }
        }
        Rectangle work = new Rectangle(800 - (5 * this.spacewidth), 400 - (5 * this.spaceheight), 10 * spacewidth, 10 * spaceheight);
        Rectangle outside = new Rectangle(700-(5*this.spacewidth), 300-(5*this.spaceheight), 10*this.spacewidth+200, 10*this.spaceheight+200);
        if(outside.contains(this.getBounds())){
            if(!work.contains(this.getBounds())){
                JOptionPane.showMessageDialog(null,"Room is outside the house", "ERROR", JOptionPane.WARNING_MESSAGE);
                this.setBounds(initialpoint.x, initialpoint.y, this.width, this.height);
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

class Kitchen extends Room
{
    Kitchen(int spacewidth, int spaceheight)
    {
        super(spacewidth,spaceheight);
        width = 150;
        height = 100;
        this.setBounds(1230,75,width,height);
        this.setBackground(new Color(255, 171, 171, 255));
    }
}
class Bathroom extends Room
{
    Bathroom(int spacewidth, int spaceheight)
    {
        super(spacewidth,spaceheight);
        width = 150;
        height = 100;
        this.setBounds(1230,275,width,height);
        this.setBackground(new Color(190, 236, 255, 255));
    }
}
class DrawingRoom extends Room
{
    DrawingRoom(int spacewidth, int spaceheight)
    {
        super(spacewidth,spaceheight);
        width = 150;
        height = 100;
        this.setBounds(1230,175,width,height);
        this.setBackground(new Color(255, 218, 176, 255));
    }
}
class Garage extends Room
{
    Garage(int spacewidth, int spaceheight)
    {
        super(spacewidth,spaceheight);
        width = 150;
        height = 100;
        this.setBounds(1230,575,width,height);
        this.setBackground(new Color(217, 189, 253, 255));
    }
}
class Bedroom extends Room
{
    Bedroom(int width, int height, int y, int spacewidth, int spaceheight)
    {
        super(spacewidth, spaceheight);
        this.width = width;
        this.height = height;
        this.setBounds(1230,y,width,height);
        this.setBackground(new Color(194, 255, 200, 255));
    }
}
