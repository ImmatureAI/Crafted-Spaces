import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page extends JFrame implements ActionListener
{
    JButton NewProject;
    JButton OpenProject;
    Home_Page()
    {
        this.setVisible(true);
        this.setSize(1000,1000);
        this.setTitle("Home Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout( new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(27, 108, 54));
        panel.add(Box.createRigidArea(new Dimension(0, 200)));

        JLabel MainText = new JLabel();
        MainText.setText("CRAFTED SPACES");
        MainText.setForeground(Color.black);
        MainText.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainText.setMaximumSize(new Dimension(350,50));
        MainText.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(MainText);

        NewProject = new JButton("NEW Project");
        OpenProject = new JButton("OPEN Project");
        NewProject.addActionListener(this);
        OpenProject.addActionListener(this);
        NewProject.setMaximumSize(new Dimension(600,100));
        OpenProject.setMaximumSize(new Dimension(600,100));
        NewProject.setFont(new Font("Arial", Font.BOLD, 24));
        OpenProject.setFont(new Font("Arial", Font.BOLD, 24));
        NewProject.setAlignmentX(Component.CENTER_ALIGNMENT);
        OpenProject.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 200)));
        panel.add(NewProject);
        panel.add(Box.createRigidArea(new Dimension(0, 100)));
        panel.add(OpenProject);

        this.add(panel);
    }
    public void actionPerformed( ActionEvent e)
    {
        if(e.getSource() == NewProject)
        {
            new SizePage();
            this.dispose();
        }
        else if( e.getSource() == OpenProject)
        {
            System.out.println("Open Project");
        }
    }
}