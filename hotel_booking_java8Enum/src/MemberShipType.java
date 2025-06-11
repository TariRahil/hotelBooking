public enum MemberShipType {
    GOLD(0.10),
    PLATINUM(0.20),
    NONE(0.0);

    private final double discount;
    MemberShipType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
