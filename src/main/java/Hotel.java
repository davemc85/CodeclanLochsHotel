import java.util.ArrayList;
import java.util.BitSet;

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

    public boolean checkIn(Guest guest, Room room) {
        boolean checkedIn = false;
        if (room.getType() == "Single"){
            int roomIndex = this.singleRooms.indexOf(room);
            if(this.singleRooms.get(roomIndex).countRoomGuests() == 0) {
                this.singleRooms.get(roomIndex).addGuest(guest);
                checkedIn = true;
            }
        }
        if (room.getType() == "Double"){
            int roomIndex = this.doubleRooms.indexOf(room);
            if(this.doubleRooms.get(roomIndex).countRoomGuests() == 0) {
                this.doubleRooms.get(roomIndex).addGuest(guest);
                checkedIn = true;
            }
        }
        if (room.getType() == "Conference"){
            int roomIndex = this.conferenceRooms.indexOf(room);
            if(this.conferenceRooms.get(roomIndex).countRoomGuests() == 0) {
                this.conferenceRooms.get(roomIndex).addGuest(guest);
                checkedIn = true;
            }
        }
        return checkedIn;
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

    public Booking bookRoom(Guest guest, Room room, int numberOfNights) {
        Booking booking = null;
        if(this.checkIn(guest, room)){
            booking = new Booking(room, numberOfNights);
        }
        return booking;
    }


    public ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<Room>();
        for(Room room : this.singleRooms){
            if(room.countRoomGuests() == 0){
                availableRooms.add(room);
            }
        }
        for(Room room : this.doubleRooms){
            if(room.countRoomGuests() == 0){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
