package LLD.HotelManagementSystem;

public class InRoomPurchase implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    Double getCost(){
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }
}
