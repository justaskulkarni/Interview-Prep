package LLD.HotelManagementSystem;

public class RoomCharge implements BaseRoomCharge{
    double cost;
    Double getCost(){
        return cost;
    }
    void setCost(double cost){
        this.cost = cost;
    }
}
