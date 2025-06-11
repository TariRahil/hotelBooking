import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Booking> bookings = Arrays.asList(
                new Booking(RoomType.STANDARD, MemberShipType.GOLD, 2),
                new Booking(RoomType.DELUXE, MemberShipType.PLATINUM, 4),
                new Booking(RoomType.SUITE, MemberShipType.NONE, 6)
        );

        bookings.forEach(booking -> {
            double totalCost = calculateTotalCost(booking);
            System.out.println(formatBookingDetails(booking, totalCost));
        });
    }

    private static String formatBookingDetails(Booking booking, double totalCost) {
        return String.format("Booking: %s for %d nights (%s member)\nFinal Cost: $%.2f",
                booking.getRoomType(), booking.getNights(), booking.getMemberShipType(), totalCost);    }

    private static double calculateTotalCost(Booking booking) {
        double basePrice = booking.getRoomType().getBasePrice();
        double roomDiscount = booking.getRoomType().getRoomDiscount(booking.getNights());
        double membershipDiscount = booking.getMemberShipType().getDiscount();

        double totalCost = basePrice * booking.getNights();
        totalCost -= totalCost * roomDiscount;
        totalCost -= totalCost * membershipDiscount;

        return totalCost;
    }
}