package LLD.HotelManagementSystem;
import java.util.Date;
import java.util.List;
public class RoomBooking {
    String bookingId;
    Date startDate;
    Integer durationInDays;
    List<Guest> guestList;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharges;
}
