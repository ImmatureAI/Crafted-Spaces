import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface Crafted_Spaces
{
    ArrayList<Room> history = new ArrayList<>();
    ArrayList<Accessories> accessoryHistory = new ArrayList<>();
    
   ImageIcon Icon1 = new ImageIcon("sbed.png");
    ImageIcon Icon2 = new ImageIcon("lbed.png");
    ImageIcon Icon3 = new ImageIcon("shelf1.png");
    ImageIcon Icon4 = new ImageIcon("shelf2.png");
    ImageIcon Icon5 = new ImageIcon("sofa1.png");
    ImageIcon Icon6 = new ImageIcon("sofa2.png");
    ImageIcon Icon7 = new ImageIcon("sofa3.png");
    ImageIcon Icon8 = new ImageIcon("table.png");
    ImageIcon Icon9 = new ImageIcon("desk.png");
    ImageIcon Icon10 = new ImageIcon("bath.png");
    ImageIcon Icon11 = new ImageIcon("urinal.png");
    ImageIcon Icon12 = new ImageIcon("sink.png");
    ImageIcon Icon13 = new ImageIcon("door.png");
    ImageIcon Icon14 = new ImageIcon("window.png");

    Image i1 = Icon1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i2 = Icon2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i3 = Icon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i4 = Icon4.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i5 = Icon5.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i6 = Icon6.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i7 = Icon7.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i8 = Icon8.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i9 = Icon9.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i10 = Icon10.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i11 = Icon11.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i12 = Icon12.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i13 = Icon13.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    Image i14 = Icon14.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);

    ImageIcon icon1 = new ImageIcon(i1);
    ImageIcon icon2 = new ImageIcon(i2);
    ImageIcon icon3 = new ImageIcon(i3);
    ImageIcon icon4 = new ImageIcon(i4);
    ImageIcon icon5 = new ImageIcon(i5);
    ImageIcon icon6 = new ImageIcon(i6);
    ImageIcon icon7 = new ImageIcon(i7);
    ImageIcon icon8 = new ImageIcon(i8);
    ImageIcon icon9 = new ImageIcon(i9);
    ImageIcon icon10 = new ImageIcon(i10);
    ImageIcon icon11 = new ImageIcon(i11);
    ImageIcon icon12 = new ImageIcon(i12);
    ImageIcon icon13 = new ImageIcon(i13);
    ImageIcon icon14 = new ImageIcon(i14);

}
