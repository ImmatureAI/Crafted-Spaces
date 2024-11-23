import javax.swing.*;
import java.awt.event.MouseEvent;

public class Fixtures extends Accessories{
    @Override
    public void mouseReleased(MouseEvent e) {
        for (Room r : history) {
            boolean a = ((this.getX() <= r.getX() + 5) && (this.getX() >= r.getX() - 5));
            boolean b = ((this.getY() <= r.getY() + 5) && (this.getY() >= r.getY() - 5));
            boolean c = ((this.getX() + this.breadth <= r.getX() + r.width + 5) && (this.getX() + this.breadth >= r.getX() + r.width - 5));
            boolean d = ((this.getY() + this.length <= r.getY() + r.height + 5) && (this.getY() + this.length >= r.getY() + r.height - 5));
            boolean onWall = (a || b || c || d);

            if (!onWall) {
                JOptionPane.showMessageDialog(null, "Fixtures must be placed on the walls", "ERROR", JOptionPane.WARNING_MESSAGE);
                this.setBounds(initialpt.x, initialpt.y, this.breadth, this.length);
            }
        }
    }
}



class urinal extends Fixtures
{
    urinal()
    {
        length = icon11.getIconHeight();
        breadth = icon11.getIconWidth();
        this.setBounds(0,0,breadth,length);
        this.setIcon(icon11);
    }
}
class sink extends Fixtures
{
    sink()
    {
        length = icon12.getIconHeight();
        breadth = icon12.getIconWidth();
        this.setBounds(0,0,breadth,length);
        this.setIcon(icon12);
    }
}
