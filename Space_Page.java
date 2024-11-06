import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Space_Page extends JFrame implements ActionListener
{
    JLayeredPane pane;
    JPanel workspace;
    JPanel accessories;
    JPanel rooms;
    JMenuBar menubar;
    JMenu save;
    JMenu open;
    JButton garage;
    JButton kitchen;
    JButton drawingroom;
    JButton bathroom;
    JButton sbedroom;
    JButton lbedroom;

    JButton bed;


    Space_Page(int width, int height)
    {

        this.setLayout(null);
        this.setSize(2000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(27, 108, 54));

        pane = new JLayeredPane();
        pane.setBounds(0,0,2000,1000);

        workspace = new JPanel();
        workspace.setBackground(new Color(255, 255, 152));
        workspace.setBounds(800-(5*width), 400-(5*height), 10*width, 10*height);
        workspace.setOpaque(true);

        accessories = new JPanel();
        accessories.setBounds(0,75,150,600);
        accessories.setLayout(new GridLayout(7,2));

        rooms = new JPanel();
        rooms.setBounds(1380,75,150,600);
        rooms.setLayout(new GridLayout(6,1));

        menubar = new JMenuBar();
        save = new JMenu("Save");
        open = new JMenu("Open");
        menubar.add(save);
        menubar.add(open);

        kitchen = new JButton("Kitchen");
        kitchen.setBackground(new Color(255, 171, 171, 255));
        kitchen.addActionListener(this);
        kitchen.setFocusable(false);

        drawingroom = new JButton("Drawing Room");
        drawingroom.setBackground(new Color(255, 218, 176, 255));
        drawingroom.addActionListener(this);
        drawingroom.setFocusable(false);

        bathroom = new JButton("Bathroom");
        bathroom.setBackground(new Color(190, 236, 255, 255));
        bathroom.addActionListener(this);
        bathroom.setFocusable(false);

        sbedroom = new JButton("Small bedroom");
        sbedroom.setBackground(new Color(194, 255, 200, 255));
        sbedroom.addActionListener(this);
        sbedroom.setFocusable(false);

        lbedroom = new JButton("Large bedroom");
        lbedroom.setBackground(new Color(194, 255, 200, 255));
        lbedroom.addActionListener(this);
        lbedroom.setFocusable(false);

        garage = new JButton("Garage");
        garage.setBackground(new Color(217, 189, 253, 255));
        garage.addActionListener(this);
        garage.setFocusable(false);

        bed = new JButton();
        bed.setIcon(new ImageIcon("bed.png"));

        accessories.add(bed);

        rooms.add(kitchen);
        rooms.add(drawingroom);
        rooms.add(bathroom);
        rooms.add(sbedroom);
        rooms.add(lbedroom);
        rooms.add(garage);

        this.setJMenuBar(menubar);
        this.add(rooms);
        this.add(accessories);
        pane.add(workspace, Integer.valueOf(1));
        this.add(pane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kitchen)
        {
            pane.add(new Kitchen(),Integer.valueOf(2) );
            revalidate();
            repaint();
        }
        if(e.getSource() == garage)
        {
            pane.add(new Garage(),Integer.valueOf(2));
            revalidate();
            repaint();
        }
        if(e.getSource() == drawingroom)
        {
            pane.add(new DrawingRoom(),Integer.valueOf(2));
            revalidate();
            repaint();
        }
        if(e.getSource() == bathroom)
        {
            pane.add(new Bathroom(),Integer.valueOf(2));
            revalidate();
            repaint();
        }
        if(e.getSource() == sbedroom)
        {
            pane.add(new Sbedroom(),Integer.valueOf(2));
            revalidate();
            repaint();
        }
        if(e.getSource() == lbedroom)
        {
            pane.add(new Lbedroom(),Integer.valueOf(2));
            revalidate();
            repaint();
        }

    }
}

class mainsdf
{
    public static void main(String[] args) {
        new Space_Page(50,20);
    }
}
