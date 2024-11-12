import java.io.Serializable;
import java.util.ArrayList;

public class Details implements Serializable {
    //This class has the info about the room positions and furniture positions

    ArrayList<Room> rooms;
    int width;
    int height;

    Details(ArrayList<Room> rooms, int spacewidth, int spaceheight){
        this.rooms = rooms;
        this.width = spacewidth;
        this.height = spaceheight;
    }
}
