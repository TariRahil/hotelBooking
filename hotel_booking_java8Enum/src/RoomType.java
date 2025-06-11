public enum RoomType {
    STANDARD(100),
    DELUXE(200),
    SUITE(400);

    private final double basePrice;
    RoomType(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getRoomDiscount(int nights) {
        switch (this) {
            case DELUXE:
                return nights > 3 ? 0.10 : 0.0;
            case SUITE:
                return nights > 5 ? 0.15 : 0.0;
            default:
                return 0.0;
        }
    }
}
