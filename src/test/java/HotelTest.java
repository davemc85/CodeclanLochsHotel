import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Room singleRoom;
    private Room doubleRoom;
    private Room conferenceRoom;
    private Guest guest1;
    private Guest guest2;

    @Before
    public void setUp(){
        hotel = new Hotel("Codeclan Lochs");
        guest1 = new Guest("Darren");
        guest2 = new Guest("David");
        singleRoom = new Room("Single", "Ness", 101,1, 99);
        doubleRoom = new Room("Double", "Katrine", 201,2, 159);
        conferenceRoom = new Room("Conference", "Lomond Suite",1, 20, 500);
        hotel.addRoom(singleRoom);
        hotel.addRoom(doubleRoom);
        hotel.addRoom(conferenceRoom);
    }

    @Test
    public void hasName(){
        assertEquals("Codeclan Lochs", hotel.getName());
    }

    @Test
    public void hasRooms(){
        assertEquals(1, hotel.getSingleRooms().size());
        assertEquals(1, hotel.getDoubleRooms().size());
        assertEquals(1, hotel.getConferenceRooms().size());
    }

    @Test
    public void canCheckGuestIn(){
        hotel.checkIn(guest1, singleRoom);
        assertEquals(1, singleRoom.countRoomGuests());
    }

    @Test
    public void cannotCheckInGuest(){
        hotel.checkIn(guest1, singleRoom);
        hotel.checkIn(guest1, singleRoom);
        assertEquals(1, singleRoom.countRoomGuests());
    }

    @Test
    public void canCheckGuestOut(){
        hotel.checkIn(guest1, singleRoom);
        hotel.checkOut(singleRoom);
        assertEquals(0, singleRoom.countRoomGuests());
    }

    @Test
    public void canBookInGuest(){
        Booking booking = hotel.bookRoom(guest1, singleRoom, 3);
        assertEquals(297, booking.getTotalBill());
    }

    @Test
    public void canNotBookInGuest(){
        hotel.checkIn(guest1, singleRoom);
        Booking booking = hotel.bookRoom(guest2, singleRoom, 3);
        assertEquals(null, booking);
    }

    @Test
    public void canGetAvailableRooms(){
        hotel.checkIn(guest1, singleRoom);
        assertEquals(1, hotel.getAvailableRooms().size());
    }

}
