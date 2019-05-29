public class Booking {

    private Room room;
    private int numberOfNights;
    private int totalBill;

    public Booking(Room room, int numberOfNights) {
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.totalBill = room.getRate() * this.numberOfNights;
    }

    public int getTotalBill() {
        return totalBill;
    }
}
