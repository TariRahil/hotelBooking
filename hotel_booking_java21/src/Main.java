import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Booking> bookingList = List.of(
                new Booking(new Standard(), 2, new Gold()),
                new Booking(new Deluxe(), 4, new Platinum()),
                new Booking(new Suite(), 6, new None())
        );

        bookingList.forEach(booking -> {
            double totalCost = calculateTotalCoast(booking);
            System.out.println(formatBookingDetails(booking, totalCost));
        });
    }

    private static String formatBookingDetails(Booking booking, double totalCost) {
        return """
                Booking: %s for %d nights (%s member)
                Final Cost: $%.2f
                """.formatted(booking.room(), booking.nights(), booking.membership(), totalCost);
    }

    private static double calculateTotalCoast(Booking booking) {
        double basePrice = getBasePrice(booking.room());
        double discount = getDiscount(booking.room(), booking.nights());
        double membershipDiscount = getMembershipDiscount(booking.membership());

        double totalCost = basePrice * booking.nights();
        totalCost -= totalCost * discount;
        totalCost -= totalCost * membershipDiscount;

        return totalCost;
    }

    private static double getMembershipDiscount(Membership membership) {
        return switch (membership) {
            case Gold ignored -> 0.10;
            case Platinum ignored -> 0.20;
            case None ignored -> 0.0;
        };
    }

    private static double getDiscount(Room room, int nights) {
        return switch (room) {
            case Deluxe ignored -> (nights > 3) ? 0.10 : 0.0;
            case Suite ignored -> (nights > 5) ? 0.15 : 0.0;
            default -> 0.0;
        };
    }

    private static double getBasePrice(Room room) {
        return switch (room) {
            case Standard ignored -> 100;
            case Deluxe ignored -> 200;
            case Suite ignored -> 400;
        };
    }
}