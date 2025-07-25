import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Space_Page extends JFrame implements Crafted_Spaces,Serializable
{

    JLayeredPane pane;
    JPanel workspace;
    JPanel accessories;
    JPanel outside;
    JPanel rooms;
    JMenuBar menubar;
    JMenu file;
    JMenuItem save;
    JMenuItem open;
    JButton garage;
    JButton kitchen;
    JButton sauna;
    JButton bathroom;
    JButton bedroom;

    JButton sbed;
    JButton lbed;
    JButton shelf1;
    JButton shelf2;
    JButton sofa1;
    JButton sofa2;
    JButton sofa3;
    JButton table;
    JButton desk;
    JButton bath;
    JButton urinal;
    JButton sink;

    JButton door;
    JButton window;

    int response;


    Space_Page(int width, int height)
    {
        this.setLayout(null);
        this.setSize(2000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(27, 108, 54));

        pane = new JLayeredPane();
        pane.setBounds(0, 0, 2000, 1000);

        workspace = new JPanel();
        workspace.setBackground(new Color(255, 255, 152));
        workspace.setBounds(800 - (5 * width), 400 - (5 * height), 10 * width, 10 * height);
        workspace.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        workspace.setOpaque(true);

        outside = new JPanel();
        outside.setBounds(700-(5*width), 300-(5*height), 10*width+200, 10*height+200);
        outside.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        outside.setBackground(new Color(181, 181, 181, 187));
        outside.setOpaque(true);

        accessories = new JPanel();
        accessories.setBounds(0, 75, 200, 700);
        accessories.setLayout(new GridLayout(7, 2));

        rooms = new JPanel();
        rooms.setBounds(1380, 75, 150, 500);
        rooms.setLayout(new GridLayout(5, 1));

        menubar = new JMenuBar();
        file = new JMenu("File");
        save = new JMenuItem("Save");
        open = new JMenuItem("Open");
        save.addActionListener(e -> {
            if (e.getSource() == save){
                JFileChooser jfc = new JFileChooser();

                int response = jfc.showSaveDialog(null);

                if(response == JFileChooser.APPROVE_OPTION) {
                    File fileToSave;

                    if(jfc.getSelectedFile().getName().endsWith(".myext")){
                        fileToSave = jfc.getSelectedFile();
                    }
                    else{
                        fileToSave = new File(jfc.getSelectedFile().getPath() + ".myext");
                    }

                    Details details = new Details(history, accessoryHistory,width, height);

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave))) {
                        oos.writeObject(details);
                        JOptionPane.showMessageDialog(null, "File saved");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        open.addActionListener(e -> {
            if (e.getSource() == open){
                JFileChooser jfc = new JFileChooser();

                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Crafted Spaces Projects","myext");
                jfc.setFileFilter(fileNameExtensionFilter);

                response = jfc.showOpenDialog(null);
                if (response == 0) {
                    File fileToOpen;

                    if(jfc.getSelectedFile().getName().endsWith(".myext")) {
                        fileToOpen = jfc.getSelectedFile();
                        Details dets;

                        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(fileToOpen.getPath()))) {
                            history.clear();
                            accessoryHistory.clear();
                            CloseCurrentFrame();
                            dets = (Details) ios.readObject();
                            new Space_Page(dets.rooms, dets.accessories, dets.width, dets.height);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Unexpected Error opening file", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                        } catch (ClassNotFoundException e1) {
                            JOptionPane.showMessageDialog(null, "Incorrect file format", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid File Type Selected","Error",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });



        file.add(save);
        file.add(open);
        menubar.add(file);
        this.setJMenuBar(menubar);

        //rooms

        kitchen = new JButton("Kitchen");
        kitchen.setBackground(new Color(255, 171, 171, 255));
        kitchen.addActionListener(e -> {
            if (e.getSource() == kitchen) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Kitchen(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        kitchen.setBorder(new MatteBorder(4,4,2,4, Color.black));
        kitchen.setFocusable(false);

        sauna = new JButton("Sauna");
        sauna.setBackground(new Color(255, 218, 176, 255));
        sauna.addActionListener(e -> {
            if (e.getSource() == sauna) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new DrawingRoom(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        sauna.setBorder(new MatteBorder(2,4,2,4, Color.black));
        sauna.setFocusable(false);

        bathroom = new JButton("Bathroom");
        bathroom.setBackground(new Color(190, 236, 255, 255));
        bathroom.addActionListener(e -> {
            if (e.getSource() == bathroom) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Bathroom(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        bathroom.setBorder(new MatteBorder(2,4,2,4, Color.black));
        bathroom.setFocusable(false);

        bedroom = new JButton("Bedroom");
        bedroom.setBackground(new Color(194, 255, 200, 255));
        bedroom.addActionListener(e -> {
            if (e.getSource() == bedroom) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Bedroom(a, b, 475, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        bedroom.setBorder(new MatteBorder(2,4,2,4, Color.black));
        bedroom.setFocusable(false);

        garage = new JButton("Garage");
        garage.setBackground(new Color(217, 189, 253, 255));
        garage.addActionListener(e -> {
            if (e.getSource() == garage) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Garage(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        garage.setBorder(new MatteBorder(2,4,4,4, Color.black));
        garage.setFocusable(false);





        //accessories

        sbed = new JButton();
        sbed.setBackground(new Color(255, 171, 171, 255));
        sbed.setBorder(new LineBorder(Color.black, 3));
        sbed.setIcon(icon1);
        sbed.addActionListener(e -> {
            if (e.getSource() == sbed) {
                pane.add(new sbed(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });

        sbed.setFocusable(false);

        lbed = new JButton();
        lbed.setBackground(new Color(255, 171, 171, 255));
        lbed.setBorder(new LineBorder(Color.black, 3));
        lbed.setIcon(icon2);
        lbed.addActionListener(e -> {
            if (e.getSource() == lbed) {
                pane.add(new lbed(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        lbed.setFocusable(false);

        shelf1 = new JButton();
        shelf1.setBackground(new Color(255, 171, 171, 255));
        shelf1.setBorder(new LineBorder(Color.black, 3));
        shelf1.setIcon(icon3);
        shelf1.addActionListener(e -> {
            if (e.getSource() == shelf1) {
                pane.add(new shelf1(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        shelf1.setFocusable(false);

        shelf2 = new JButton();
        shelf2.setBackground(new Color(255, 171, 171, 255));
        shelf2.setBorder(new LineBorder(Color.black, 3));
        shelf2.setIcon(icon4);
        shelf2.addActionListener(e -> {
            if (e.getSource() == shelf2) {
                pane.add(new shelf2(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        shelf2.setFocusable(false);

        sofa1 = new JButton();
        sofa1.setBackground(new Color(255, 171, 171, 255));
        sofa1.setBorder(new LineBorder(Color.black, 3));
        sofa1.setIcon(icon5);
        sofa1.addActionListener(e -> {
            if (e.getSource() == sofa1) {
                pane.add(new sofa1(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sofa1.setFocusable(false);

        sofa2 = new JButton();
        sofa2.setBackground(new Color(255, 171, 171, 255));
        sofa2.setBorder(new LineBorder(Color.black, 3));
        sofa2.setIcon(icon6);
        sofa2.addActionListener(e -> {
            if (e.getSource() == sofa2) {
                pane.add(new sofa2(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sofa2.setFocusable(false);

        sofa3 = new JButton();
        sofa3.setBackground(new Color(255, 171, 171, 255));
        sofa3.setBorder(new LineBorder(Color.black, 3));
        sofa3.setIcon(icon7);
        sofa3.addActionListener(e -> {
            if (e.getSource() == sofa3) {
                pane.add(new sofa3(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sofa3.setFocusable(false);

        table = new JButton();
        table.setBackground(new Color(255, 171, 171, 255));
        table.setBorder(new LineBorder(Color.black, 3));
        table.setIcon(icon8);
        table.addActionListener(e -> {
            if (e.getSource() == table) {
                pane.add(new table(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        table.setFocusable(false);

        desk = new JButton();
        desk.setBackground(new Color(255, 171, 171, 255));
        desk.setBorder(new LineBorder(Color.black, 3));
        desk.setIcon(icon9);
        desk.addActionListener(e -> {
            if (e.getSource() == desk) {
                pane.add(new desk(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        desk.setFocusable(false);

        bath = new JButton();
        bath.setBackground(new Color(255, 171, 171, 255));
        bath.setBorder(new LineBorder(Color.black, 3));
        bath.setIcon(icon10);
        bath.addActionListener(e -> {
            if (e.getSource() == bath) {
                pane.add(new bath(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        bath.setFocusable(false);

        urinal = new JButton();
        urinal.setBackground(new Color(255, 171, 171, 255));
        urinal.setBorder(new LineBorder(Color.black, 3));
        urinal.setIcon(icon11);
        urinal.addActionListener(e -> {
            if (e.getSource() == urinal) {
                pane.add(new urinal(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        urinal.setFocusable(false);

        sink = new JButton();
        sink.setBackground(new Color(255, 171, 171, 255));
        sink.setBorder(new LineBorder(Color.black, 3));
        sink.setIcon(icon12);
        sink.addActionListener(e -> {
            if (e.getSource() == sink) {
                pane.add(new sink(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sink.setFocusable(false);


//        door = new JButton();
//        door.setBackground(new Color(255, 171, 171, 255));
//        door.setBorder(new LineBorder(Color.black, 3));
//        door.setIcon(icon13);
//        door.addActionListener(e -> {
//            if (e.getSource() == door) {
//                new door();
//            }
//        });
//        door.setFocusable(false);
//
//        window = new JButton();
//        window.setBackground(new Color(255, 171, 171, 255));
//        window.setBorder(new LineBorder(Color.black, 3));
//        window.setIcon(icon14);
//        window.addActionListener(e -> {
//            if (e.getSource() == window) {
//                new window_comp();
//            }
//        });
//        window.setFocusable(false);

        accessories.add(sbed);
        accessories.add(lbed);
        accessories.add(shelf1);
        accessories.add(shelf2);
        accessories.add(sofa1);
        accessories.add(sofa2);
        accessories.add(sofa3);
        accessories.add(table);
        accessories.add(desk);
        accessories.add(bath);
        accessories.add(urinal);
        accessories.add(sink);
//        accessories.add(door);
//        accessories.add(window);


        rooms.add(kitchen);
        rooms.add(sauna);
        rooms.add(bathroom);
        rooms.add(bedroom);
        rooms.add(garage);

        this.setJMenuBar(menubar);
        this.add(rooms);
        this.add(accessories);
        pane.add(outside, Integer.valueOf(0));
        pane.add(workspace, Integer.valueOf(1));
        this.add(pane);
        this.setVisible(true);
    }

    //For the opening file thing

    Space_Page(ArrayList<Room> room, ArrayList<Accessories> accessory, int width, int height)
    {
        this.setLayout(null);
        this.setSize(2000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(27, 108, 54));

        pane = new JLayeredPane();
        pane.setBounds(0, 0, 2000, 1000);

        workspace = new JPanel();
        workspace.setBackground(new Color(255, 255, 152));
        workspace.setBounds(800 - (5 * width), 400 - (5 * height), 10 * width, 10 * height);
        workspace.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        workspace.setOpaque(true);

        outside = new JPanel();
        outside.setBounds(700-(5*width), 300-(5*height), 10*width+200, 10*height+200);
        outside.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        outside.setBackground(new Color(181, 181, 181, 187));
        outside.setOpaque(true);

        accessories = new JPanel();
        accessories.setBounds(0, 75, 200, 700);
        accessories.setLayout(new GridLayout(7, 2));

        rooms = new JPanel();
        rooms.setBounds(1380, 75, 150, 500);
        rooms.setLayout(new GridLayout(5, 1));

        menubar = new JMenuBar();
        file = new JMenu("File");
        save = new JMenuItem("Save");
        open = new JMenuItem("Open");
        save.addActionListener(e -> {
            if (e.getSource() == save){
                JFileChooser jfc = new JFileChooser();

                int response = jfc.showSaveDialog(null);

                if(response == JFileChooser.APPROVE_OPTION) {
                    File fileToSave;

                    if(jfc.getSelectedFile().getName().endsWith(".myext")){
                        fileToSave = jfc.getSelectedFile();
                    }
                    else{
                        fileToSave = new File(jfc.getSelectedFile().getPath() + ".myext");
                    }

                    Details details = new Details(history, accessoryHistory,width, height);

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave))) {
                        oos.writeObject(details);
                        JOptionPane.showMessageDialog(null, "File saved");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        open.addActionListener(e -> {
            if (e.getSource() == open){
                JFileChooser jfc = new JFileChooser();

                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Crafted Spaces Projects","myext");
                jfc.setFileFilter(fileNameExtensionFilter);

                response = jfc.showOpenDialog(null);
                if (response == 0) {
                    File fileToOpen;

                    if(jfc.getSelectedFile().getName().endsWith(".myext")) {
                        fileToOpen = jfc.getSelectedFile();
                        Details dets;

                        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(fileToOpen.getPath()))) {
                            history.clear();
                            accessoryHistory.clear();
                            CloseCurrentFrame();
                            dets = (Details) ios.readObject();
                            new Space_Page(dets.rooms, dets.accessories, dets.width, dets.height);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Unexpected Error opening file", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                        } catch (ClassNotFoundException e1) {
                            JOptionPane.showMessageDialog(null, "Incorrect file format", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid File Type Selected","Error",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });



        file.add(save);
        file.add(open);
        menubar.add(file);
        this.setJMenuBar(menubar);

        //constructing the opened file

        for (Room r: room){
            r.setBounds((int)r.finalpt.getX(),(int)r.finalpt.getY(),r.width,r.height);
            pane.add(r,Integer.valueOf(2));
            history.add(r);
            for (DoorPanel d: r.doors){
                r.add(d.doorPanel(r,d.pos),Integer.valueOf(1));
            }
        }

        for (Accessories a: accessory){
            a.setBounds((int)a.finalpt.getX(),(int)a.finalpt.getY(),a.breadth,a.length);
            pane.add(a,Integer.valueOf(3));
            accessoryHistory.add(a);
        }

        //rooms

        kitchen = new JButton("Kitchen");
        kitchen.setBackground(new Color(255, 171, 171, 255));
        kitchen.addActionListener(e -> {
            if (e.getSource() == kitchen) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Kitchen(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        kitchen.setBorder(new MatteBorder(4,4,2,4, Color.black));
        kitchen.setFocusable(false);

        sauna = new JButton("Sauna");
        sauna.setBackground(new Color(255, 218, 176, 255));
        sauna.addActionListener(e -> {
            if (e.getSource() == sauna) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new DrawingRoom(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        sauna.setBorder(new MatteBorder(2,4,2,4, Color.black));
        sauna.setFocusable(false);

        bathroom = new JButton("Bathroom");
        bathroom.setBackground(new Color(190, 236, 255, 255));
        bathroom.addActionListener(e -> {
            if (e.getSource() == bathroom) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Bathroom(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        bathroom.setBorder(new MatteBorder(2,4,2,4, Color.black));
        bathroom.setFocusable(false);

        bedroom = new JButton("Bedroom");
        bedroom.setBackground(new Color(194, 255, 200, 255));
        bedroom.addActionListener(e -> {
            if (e.getSource() == bedroom) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Bedroom(a, b, 475, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        bedroom.setBorder(new MatteBorder(2,4,2,4, Color.black));
        bedroom.setFocusable(false);

        garage = new JButton("Garage");
        garage.setBackground(new Color(217, 189, 253, 255));
        garage.addActionListener(e -> {
            if (e.getSource() == garage) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the room"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the room"));
                    pane.add(new Garage(a, b, width, height), Integer.valueOf(2));
                    revalidate();
                    repaint();
                }
                catch(Exception ex){

                }
            }
        });
        garage.setBorder(new MatteBorder(2,4,4,4, Color.black));
        garage.setFocusable(false);





        //accessories

        sbed = new JButton();
        sbed.setBackground(new Color(255, 171, 171, 255));
        sbed.setBorder(new LineBorder(Color.black, 3));
        sbed.setIcon(icon1);
        sbed.addActionListener(e -> {
            if (e.getSource() == sbed) {
                pane.add(new sbed(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });

        sbed.setFocusable(false);

        lbed = new JButton();
        lbed.setBackground(new Color(255, 171, 171, 255));
        lbed.setBorder(new LineBorder(Color.black, 3));
        lbed.setIcon(icon2);
        lbed.addActionListener(e -> {
            if (e.getSource() == lbed) {
                pane.add(new lbed(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        lbed.setFocusable(false);

        shelf1 = new JButton();
        shelf1.setBackground(new Color(255, 171, 171, 255));
        shelf1.setBorder(new LineBorder(Color.black, 3));
        shelf1.setIcon(icon3);
        shelf1.addActionListener(e -> {
            if (e.getSource() == shelf1) {
                pane.add(new shelf1(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        shelf1.setFocusable(false);

        shelf2 = new JButton();
        shelf2.setBackground(new Color(255, 171, 171, 255));
        shelf2.setBorder(new LineBorder(Color.black, 3));
        shelf2.setIcon(icon4);
        shelf2.addActionListener(e -> {
            if (e.getSource() == shelf2) {
                pane.add(new shelf2(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        shelf2.setFocusable(false);

        sofa1 = new JButton();
        sofa1.setBackground(new Color(255, 171, 171, 255));
        sofa1.setBorder(new LineBorder(Color.black, 3));
        sofa1.setIcon(icon5);
        sofa1.addActionListener(e -> {
            if (e.getSource() == sofa1) {
                pane.add(new sofa1(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sofa1.setFocusable(false);

        sofa2 = new JButton();
        sofa2.setBackground(new Color(255, 171, 171, 255));
        sofa2.setBorder(new LineBorder(Color.black, 3));
        sofa2.setIcon(icon6);
        sofa2.addActionListener(e -> {
            if (e.getSource() == sofa2) {
                pane.add(new sofa2(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sofa2.setFocusable(false);

        sofa3 = new JButton();
        sofa3.setBackground(new Color(255, 171, 171, 255));
        sofa3.setBorder(new LineBorder(Color.black, 3));
        sofa3.setIcon(icon7);
        sofa3.addActionListener(e -> {
            if (e.getSource() == sofa3) {
                pane.add(new sofa3(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sofa3.setFocusable(false);

        table = new JButton();
        table.setBackground(new Color(255, 171, 171, 255));
        table.setBorder(new LineBorder(Color.black, 3));
        table.setIcon(icon8);
        table.addActionListener(e -> {
            if (e.getSource() == table) {
                pane.add(new table(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        table.setFocusable(false);

        desk = new JButton();
        desk.setBackground(new Color(255, 171, 171, 255));
        desk.setBorder(new LineBorder(Color.black, 3));
        desk.setIcon(icon9);
        desk.addActionListener(e -> {
            if (e.getSource() == desk) {
                pane.add(new desk(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        desk.setFocusable(false);

        bath = new JButton();
        bath.setBackground(new Color(255, 171, 171, 255));
        bath.setBorder(new LineBorder(Color.black, 3));
        bath.setIcon(icon10);
        bath.addActionListener(e -> {
            if (e.getSource() == bath) {
                pane.add(new bath(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        bath.setFocusable(false);

        urinal = new JButton();
        urinal.setBackground(new Color(255, 171, 171, 255));
        urinal.setBorder(new LineBorder(Color.black, 3));
        urinal.setIcon(icon11);
        urinal.addActionListener(e -> {
            if (e.getSource() == urinal) {
                pane.add(new urinal(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        urinal.setFocusable(false);

        sink = new JButton();
        sink.setBackground(new Color(255, 171, 171, 255));
        sink.setBorder(new LineBorder(Color.black, 3));
        sink.setIcon(icon12);
        sink.addActionListener(e -> {
            if (e.getSource() == sink) {
                pane.add(new sink(), Integer.valueOf(3));
                revalidate();
                repaint();
            }
        });
        sink.setFocusable(false);


//        door = new JButton();
//        door.setBackground(new Color(255, 171, 171, 255));
//        door.setBorder(new LineBorder(Color.black, 3));
//        door.setIcon(icon13);
//        door.addActionListener(e -> {
//            if (e.getSource() == door) {
//                new door();
//            }
//        });
//        door.setFocusable(false);
//
//        window = new JButton();
//        window.setBackground(new Color(255, 171, 171, 255));
//        window.setBorder(new LineBorder(Color.black, 3));
//        window.setIcon(icon14);
//        window.addActionListener(e -> {
//            if (e.getSource() == window) {
//                new window_comp();
//            }
//        });
        //window.setFocusable(false);

        accessories.add(sbed);
        accessories.add(lbed);
        accessories.add(shelf1);
        accessories.add(shelf2);
        accessories.add(sofa1);
        accessories.add(sofa2);
        accessories.add(sofa3);
        accessories.add(table);
        accessories.add(desk);
        accessories.add(bath);
        accessories.add(urinal);
        accessories.add(sink);
        //accessories.add(door);
        //accessories.add(window);


        rooms.add(kitchen);
        rooms.add(sauna);
        rooms.add(bathroom);
        rooms.add(bedroom);
        rooms.add(garage);

        this.setJMenuBar(menubar);
        this.add(rooms);
        this.add(accessories);
        pane.add(outside, Integer.valueOf(0));
        pane.add(workspace, Integer.valueOf(1));
        this.add(pane);
        this.setVisible(true);
    }

    private void CloseCurrentFrame(){
        this.dispose();
    }
}

class mainsdfe{
    public static void main(String args[]){
        new Space_Page(60,40);
    }
}
