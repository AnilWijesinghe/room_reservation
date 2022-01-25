import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HotelReservationTest {

    @Test
    public void bookARoom(){
        long clientId = 1;
        String room = "r1";
        LocalDate arrivalDate = LocalDate.of(2021, 2, 1);
        LocalDate departureDate = LocalDate.of(2021, 2, 10);
        Booking booking = new Booking(clientId,room,arrivalDate,departureDate);

        HotelReservation hotelReservation = new HotelReservation();
        String bookedRoom = hotelReservation.bookARoom(booking);

        assertEquals("r1 room booked.",bookedRoom);
    }

    @Test
    public void alreadyBookRoom(){
        long clientId = 1;
        String room = "r1";
        LocalDate arrivalDate = LocalDate.of(2021, 2, 1);
        LocalDate departureDate = LocalDate.of(2021, 2, 10);
        Booking booking = new Booking(clientId,room,arrivalDate,departureDate);

        HotelReservation hotelReservation = new HotelReservation();
        String bookedRoom = hotelReservation.bookARoom(booking);

        long newClientId = 2;
        String newRoom = "r1";
        LocalDate newArrivalDate = LocalDate.of(2021, 2, 3);
        LocalDate newDepartureDate = LocalDate.of(2021, 2, 6);
        Booking newBooking = new Booking(newClientId,newRoom,newArrivalDate,newDepartureDate);
        String newBookedRoom = hotelReservation.bookARoom(newBooking);

        assertEquals("r1 room is already booked.",newBookedRoom);
    }

}