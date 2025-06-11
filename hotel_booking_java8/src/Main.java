import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Booking> bookingList = Arrays.asList(
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
        return String.format("Booking: %s for %d nights (%s member) \nFinal Cost: $%.2f",
                booking.getRoomType(), booking.getNights(), booking.getMemberShip(), totalCost);
    }

    private static double calculateTotalCost(Booking booking) {
        double basePrice = getBasePrice(booking.getRoomType());
        double discount = getDiscount(booking.getRoomType(), booking.getNights());
        double membershipDiscount = getMemberShipDiscount(booking.getMemberShip());

        double totalPrice = basePrice * booking.getNights();
        totalPrice *= (1 - discount);
        totalPrice *= (1 - membershipDiscount);

        return Math.round(totalPrice * 100) / 100.0;
    }

    private static double getMemberShipDiscount(String memberShip) {
        switch (memberShip) {
            case "gold": return 0.10;
            case "platinum": return 0.20;
            default: return 0.0;
        }
    }

    private static double getDiscount(String roomType, int nights) {
        switch (roomType) {
            case "deluxe": return (nights > 3) ? 0.10 : 0.0;
            case "suite": return (nights > 5) ? 0.15 : 0.0;
            default: return 0.0;
        }
    }

    private static double getBasePrice(String roomType) {
        switch (roomType) {
            case "standard": return 100;
            case "deluxe": return 200;
            case "suite": return 400;
            default: return 0;
        }
    }
}