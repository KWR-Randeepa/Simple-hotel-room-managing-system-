public class DeluxeRoom extends Room{
    private boolean wifiIncluded;
    private boolean breakfastIncluded;

    public DeluxeRoom(int roomNumer, String roomType, double pricePerNight, boolean wifiIncluded,boolean breakfastIncluded) {
        super(roomNumer, roomType, pricePerNight);
        this.wifiIncluded = wifiIncluded;
        this.breakfastIncluded = breakfastIncluded;
    }

    @Override
    public void displayRoomDetails(){
        super.displayRoomDetails();
        System.out.println("WiFi Included: "+(wifiIncluded ? "Yes" : "No"));
        System.out.println("Breakfast Included: "+(breakfastIncluded ? "Yes" : "No"));
    }

}
