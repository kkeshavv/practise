// Question 17: Hotel Booking: Given room bookings (check-in date, check-out date, room type, guest name),
// find the most popular room type and total revenue per room type.

import java.time.*;
import java.util.*;
import java.util.stream.*;

class Booking {
    LocalDate checkIn, checkOut;
    String roomType, guest;
    double amount;

    Booking(LocalDate checkIn, LocalDate checkOut, String roomType, String guest, double amount) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.guest = guest;
        this.amount = amount;
    }

    String getRoomType() { return roomType; }
    double getAmount() { return amount; }
}

public class Q17_HotelBookingAnalysis {
    public static void main(String[] args) {
        List<Booking> bookings = Arrays.asList(
                new Booking(LocalDate.now(), LocalDate.now(), "Deluxe", "A", 3000),
                new Booking(LocalDate.now(), LocalDate.now(), "Suite", "B", 5000),
                new Booking(LocalDate.now(), LocalDate.now(), "Deluxe", "C", 3500)
        );

        String popular = bookings.stream()
                .collect(Collectors.groupingBy(Booking::getRoomType, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();

        Map<String, Double> revenue = bookings.stream()
                .collect(Collectors.groupingBy(
                        Booking::getRoomType,
                        Collectors.summingDouble(Booking::getAmount)
                ));

        System.out.println(popular);
        System.out.println(revenue);
    }
}
