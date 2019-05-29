import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    private Room singleRoom;
    private Room doubleRoom;
    private Room conferenceRoom;
    private Guest guest1;
    private Guest guest2;

    @Before
    public void setUp(){
        guest1 = new Guest("Darren");
        guest2 = new Guest("David");
        singleRoom = new Room("Single", "Ness", 101,1, 99);
        doubleRoom = new Room("Double", "Katrine", 201,2, 159);
        conferenceRoom = new Room("Conference", "Lomond Suite",1, 20, 500);
    }

    @Test
    public void checkRoomStartsWithNoGuest(){
        assertEquals(0, singleRoom.countRoomGuests());
    }

    @Test
    public void checkRoomHasType(){
        assertEquals("Single", singleRoom.getType());
    }

    @Test
    public void checkRoomHasNumber(){
        assertEquals(201, doubleRoom.getNumber());
    }

    @Test
    public void checkRoomHasName(){
        assertEquals("Ness", singleRoom.getName());
    }

    @Test
    public void checkRoomHasRate(){
        assertEquals(500, conferenceRoom.getRate());
    }

    @Test
    public void canAddGuestToRoom(){
        singleRoom.addGuest(guest1);
        assertEquals(1, singleRoom.countRoomGuests());
    }

    @Test
    public void canRemoveGuest(){
        singleRoom.addGuest(guest1);
        singleRoom.removeGuests();
        assertEquals(0, singleRoom.countRoomGuests());
    }

    @Test
    public void canNotAddTooManyGuestsToRoom(){
        singleRoom.addGuest(guest1);
        singleRoom.addGuest(guest2);
        assertEquals(1, singleRoom.countRoomGuests());
    }



}
