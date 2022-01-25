import java.util.List;
import java.util.stream.Collectors;

public class ReservationValidation {

    public boolean isRoomAvailable(List<Booking> bookedList,Booking bookingDet){
        return bookedList.stream()
                .filter(booked -> booked.getRoomName().equals(bookingDet.getRoomName()) && (
                                bookingDet.getArrivalDate().isEqual(booked.getArrivalDate())
                                || (bookingDet.getArrivalDate().isBefore(booked.getDepartureDate())
                                && bookingDet.getArrivalDate().isAfter(booked.getArrivalDate()) || bookingDet.getArrivalDate().isEqual(booked.getDepartureDate()))
                        )).count() == 0;
    }
}
