import java.util.ArrayList;

public class Room {

    private String type;
    private String name;
    private int number;
    private int capacity;
    private ArrayList<Guest> roomGuests;
    private int rate;

    public Room(String type, String name, int number, int capacity, int rate) {
        this.type = type;
        this.name = name;
        this.number = number;
        this.capacity = capacity;
        this.roomGuests = new ArrayList<Guest>();
        this.rate = rate;
    }

    public int countRoomGuests() {
        return this.roomGuests.size();
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public int getRate() {
        return rate;
    }

    public void addGuest(Guest guest) {
        this.roomGuests.add(guest);
    }

    public void removeGuests() {
        this.roomGuests.clear();
    }
}
