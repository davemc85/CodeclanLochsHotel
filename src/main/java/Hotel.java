import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Room> singleRooms;
    private ArrayList<Room> doubleRooms;
    private ArrayList<Room> conferenceRooms;

    public Hotel(String name) {
        this.name = name;
        this.singleRooms = new ArrayList<Room>();
        this.doubleRooms = new ArrayList<Room>();
        this.conferenceRooms = new ArrayList<Room>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Room> getSingleRooms() {
        return singleRooms;
    }

    public ArrayList<Room> getDoubleRooms() {
        return doubleRooms;
    }

    public ArrayList<Room> getConferenceRooms() {
        return conferenceRooms;
    }

    public void addRoom(Room room) {
        if (room.getType() == "Single"){
            this.singleRooms.add(room);
        }
        if (room.getType() == "Double"){
            this.doubleRooms.add(room);
        }
        if (room.getType() == "Conference"){
            this.conferenceRooms.add(room);
        }
    }

    public void checkIn(Guest guest, Room room) {
        if (room.getType() == "Single"){
            int roomIndex = this.singleRooms.indexOf(room);
            this.singleRooms.get(roomIndex).addGuest(guest);
        }
        if (room.getType() == "Double"){
            int roomIndex = this.doubleRooms.indexOf(room);
            this.doubleRooms.get(roomIndex).addGuest(guest);
        }
        if (room.getType() == "Conference"){
            int roomIndex = this.conferenceRooms.indexOf(room);
            this.conferenceRooms.get(roomIndex).addGuest(guest);
        }
    }

    public void checkOut(Room room) {
        if (room.getType() == "Single"){
            int roomIndex = this.singleRooms.indexOf(room);
            this.singleRooms.get(roomIndex).removeGuests();
        }
        if (room.getType() == "Double"){
            int roomIndex = this.doubleRooms.indexOf(room);
            this.doubleRooms.get(roomIndex).removeGuests();
        }
        if (room.getType() == "Conference"){
            int roomIndex = this.conferenceRooms.indexOf(room);
            this.conferenceRooms.get(roomIndex).removeGuests();
        }
    }
}
