import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking;
    private Room singleRoom;
    private Guest guest1;


    @Before
    public void setUp(){
        singleRoom = new Room("Single", "Ness", 101,1, 99);
        booking = new Booking(singleRoom, 5);
        guest1 = new Guest("Darren");
    }

    @Test
    public void getBookingCost(){
        assertEquals(495, booking.getTotalBill());
    }

}
