import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SizePage extends JFrame implements ActionListener{
    JLabel jl;
    JPanel jp1;
    JPanel jp2;

    JButton size1;
    JButton size2;
    JButton size3;

    SizePage(){
        this.setSize(1000,1000);          //making the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(27, 108, 54));
        this.setLayout(null);
        this.setVisible(true);


        jp1 = new JPanel();             //frame for "Select the size"
        jp1.setBounds(175,100,600,200);
        jp1.setBackground(new Color(27, 108, 54));
        jp1.setLayout(new BorderLayout());
        this.add(jp1);
        jl = new JLabel("SELECT THE SIZE");
        jl.setFont(new Font("Arial",Font.BOLD,36));
        jl.setForeground(Color.black);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setVerticalAlignment(JLabel.CENTER);
        jp1.add(jl);

        size1 = new JButton("Size 1");              //buttons for sizes
        size2 = new JButton("Size 2");
        size3 = new JButton("Size 3");
        size1.setPreferredSize(new Dimension(175,100));
        size2.setPreferredSize(new Dimension(175,100));
        size3.setPreferredSize(new Dimension(175,100));
        size1.setFont(new Font("Arial",Font.BOLD,24));
        size2.setFont(new Font("Arial",Font.BOLD,24));
        size3.setFont(new Font("Arial",Font.BOLD,24));
        size1.setFocusable(false);
        size2.setFocusable(false);
        size3.setFocusable(false);
        //size1.setBackground(new Color(27, 108, 54));
        //size2.setBackground(new Color(27, 108, 54));
        //size3.setBackground(new Color(27, 108, 54));
        size1.addActionListener(this);
        size2.addActionListener(this);
        size3.addActionListener(this);


        jp2 = new JPanel();                 //panel for buttons
        jp2.setBounds(100,450,700,200);
        jp2.setBackground(new Color(27, 108, 54));
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT,50,50));
        jp2.add(size1);
        jp2.add(size2);
        jp2.add(size3);
        this.add(jp2);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==size1)
        {
            new Space_Page(20,30);
        }
        if(e.getSource()==size2)
        {
            new Space_Page(30,50);
        }
        if(e.getSource()==size3)
        {
            new Space_Page(40,60);
        }
    }
}
