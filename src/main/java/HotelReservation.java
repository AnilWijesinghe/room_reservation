import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservation {

    String[] allRooms = {"r1","r2","r3","r4"};
    List<Booking> bookingList = new ArrayList<>();


    public String bookARoom(Booking booking){
        String message = "";
        ReservationValidation reservationValidation = new ReservationValidation();
        if(reservationValidation.isRoomAvailable(bookingList,booking)){
            bookingList.add(booking);
            message = booking.getRoomName().concat(" room booked.");
        }else{
            message = booking.getRoomName().concat(" room is already booked.");
        }
        return message;
    }

}
