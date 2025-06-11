public class Booking {
    private final String roomType;
    private final int nights;
    private final String memberShip;

    public Booking(String roomType, int nights, String memberShip) {
        this.roomType = roomType;
        this.nights = nights;
        this.memberShip = memberShip;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    public String getMemberShip() {
        return memberShip;
    }
}
