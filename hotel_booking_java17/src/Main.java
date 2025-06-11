import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Booking> bookingList = List.of(
                new Booking("standard", 2, "gold"),
                new Booking("deluxe", 4, "platinum"),
                new Booking("suite", 6, "none")
        );

        bookingList.forEach(booking -> {
            double totalCost = calculateTotalCost(booking);
            System.out.println(formatBookingDetails(booking, totalCost));
        });
    }

    private static String formatBookingDetails(Booking booking, double totalCost) {
        return """
                Booking: %s for %d nights (%s member)
                Final Cost: $%.2f
                """.formatted(booking.roomType(), booking.nights(), booking.membership(), totalCost);
    }

    private static double calculateTotalCost(Booking booking) {
        double basePrice = getBasePrice(booking.roomType());
        double discount = getDiscount(booking.roomType(), booking.nights());
        double membershipDiscount = getMembershipDiscount(booking.membership());

        double totalCost = basePrice * booking.nights();
        totalCost *= (1 - discount);
        totalCost *= (1 - membershipDiscount);

        return Math.round(totalCost * 100.0) / 100.0;
    }

    private static double getMembershipDiscount(String membership) {
        return switch (membership) {
            case "gold" -> 0.10;
            case "platinum" -> 0.20;
            default -> 0.0;
        };
    }

    private static double getDiscount(String roomType, int nights) {
        return switch (roomType) {
            case "deluxe" -> (nights > 3) ? 0.10 : 0.0;
            case "suite" -> (nights > 5) ? 0.15 : 0.0;
            default -> 0.0;
        };
    }

    private static double getBasePrice(String roomType) {
        return switch (roomType) {
            case "standard" -> 100;
            case "deluxe" -> 200;
            case "suite" -> 400;
            default -> 0;
        };
    }
}
