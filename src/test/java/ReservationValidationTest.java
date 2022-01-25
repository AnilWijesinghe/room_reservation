import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationValidationTest {

    @Test
    public void checkRoomAvailabilityInBetweenDates(){
        List<Booking> bookedList = new ArrayList<>();
        long clientId = 1;
        String bookedRoom = "r1";
        LocalDate arrivalDate = LocalDate.of(2021, 2, 1);
        LocalDate departureDate = LocalDate.of(2021, 2, 10);
        Booking booking = new Booking(clientId,bookedRoom,arrivalDate,departureDate);
        bookedList.add(booking);

        long newClientId = 2;
        String room = "r1";
        LocalDate newArrivalDate = LocalDate.of(2021, 2, 3);
        LocalDate newDepartureDate = LocalDate.of(2021, 2, 6);
        Booking newBooking = new Booking(newClientId,room,newArrivalDate,newDepartureDate);

        ReservationValidation rv = new ReservationValidation();
        boolean isAvailable = rv.isRoomAvailable(bookedList,newBooking);
        assertFalse(isAvailable);
    }

    @Test
    public void checkRoomAvailabilitySameArrivalDate(){
        List<Booking> bookedList = new ArrayList<>();
        long clientId = 1;
        String bookedRoom = "r1";
        LocalDate arrivalDate = LocalDate.of(2021, 2, 1);
        LocalDate departureDate = LocalDate.of(2021, 2, 10);
        Booking booking = new Booking(clientId,bookedRoom,arrivalDate,departureDate);
        bookedList.add(booking);

        long newClientId = 2;
        String room = "r1";
        LocalDate newArrivalDate = LocalDate.of(2021, 2, 1);
        LocalDate newDepartureDate = LocalDate.of(2021, 2, 6);
        Booking newBooking = new Booking(newClientId,room,newArrivalDate,newDepartureDate);

        ReservationValidation rv = new ReservationValidation();
        boolean isAvailable = rv.isRoomAvailable(bookedList,newBooking);
        assertFalse(isAvailable);
    }

    @Test
    public void checkRoomAvailabilityWhenArrivalInDepartureDate(){
        List<Booking> bookedList = new ArrayList<>();
        long clientId = 1;
        String bookedRoom = "r1";
        LocalDate arrivalDate = LocalDate.of(2021, 2, 1);
        LocalDate departureDate = LocalDate.of(2021, 2, 10);
        Booking booking = new Booking(clientId,bookedRoom,arrivalDate,departureDate);
        bookedList.add(booking);

        long newClientId = 2;
        String room = "r1";
        LocalDate newArrivalDate = LocalDate.of(2021, 2, 4);
        LocalDate newDepartureDate = LocalDate.of(2021, 2, 10);
        Booking newBooking = new Booking(newClientId,room,newArrivalDate,newDepartureDate);

        ReservationValidation rv = new ReservationValidation();
        boolean isAvailable = rv.isRoomAvailable(bookedList,newBooking);
        assertFalse(isAvailable);
    }

}