public class Booking {
    private final RoomType roomType;
    private final MemberShipType memberShipType;
    private final int nights;

    public Booking(RoomType roomType, MemberShipType memberShipType, int nights) {
        this.roomType = roomType;
        this.memberShipType = memberShipType;
        this.nights = nights;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public MemberShipType getMemberShipType() {
        return memberShipType;
    }

    public int getNights() {
        return nights;
    }
}
