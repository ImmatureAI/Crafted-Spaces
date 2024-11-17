import java.io.Serializable;
import java.util.ArrayList;

public class Details implements Serializable {
    //This class has the info about the room positions and furniture positions

    ArrayList<Room> rooms;
    ArrayList<Accessories> accessories;
    
    int width;
    int height;

    Details(ArrayList<Room> rooms, ArrayList <Accessories> accessories,int spacewidth, int spaceheight){
        this.rooms = rooms;
        this.accessories = accessories;
        this.width = spacewidth;
        this.height = spaceheight;
    }
}
