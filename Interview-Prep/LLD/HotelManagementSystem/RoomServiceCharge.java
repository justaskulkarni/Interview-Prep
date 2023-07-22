package LLD.HotelManagementSystem;

public class RoomServiceCharge implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    Double getCost(){
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }
}
