
public class Room {
        private int roomNumer;
        private String roomType;
        private double pricePerNight;
        private boolean isAvailable;
    
        public Room(int roomNumer, String roomType, double pricePerNight) {
            this.roomNumer = roomNumer;
            this.roomType = roomType;
            this.pricePerNight = pricePerNight;
            this.isAvailable =true;
        }
    
        //getters and setters for room
        public int getRoomNumer() {
            return roomNumer;
        }
    
        public String getRoomType() {
            return roomType;
        }
    
        public double getPricePerNight() {
            return pricePerNight;
        }
    
        public boolean isAvailable() {
            return isAvailable;
        }
    
        public void setAvailability(boolean isAvailable){
            this.isAvailable = isAvailable;
        }
    
        public void displayRoomDetails(){
            System.out.println("Room Number: "+roomNumer);
            System.out.println("Room Type: "+roomType);
            System.out.println("Price Per Night: "+pricePerNight);
            System.out.println("Availability: "+(isAvailable ? "Available" : "Booked"));
        }
    }
    

