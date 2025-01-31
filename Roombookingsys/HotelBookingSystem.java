import java.util.ArrayList;
import java.util.Scanner;

public class HotelBookingSystem {
    private static ArrayList<Room> rooms = new ArrayList<>(); //array object
    private static Scanner scanner = new Scanner (System.in);
   
   public static void main(String[] args) {
       int choice;
       do{
           System.out.println("=== Hotel Room Booking System ===");
           System.out.println("1. Add a New Room");
           System.out.println("2. View All Rooms");
           System.out.println("3. search Room by Type");
           System.out.println("4. Reserve a Room");
           System.out.println("5. Cancel Reservation");
           System.out.println("6. Exit system");
           System.out.print("Please select an option: ");
           choice = scanner.nextInt();
           scanner.nextLine();
   
           switch(choice){
               case 1:
               addRoom();
               break;
   
               case 2:
               displayAllRooms();
               break;
   
               case 3:
               searchRoomByType();
               break;
   
               case 4:
               bookRoom();
               break;
   
               case 5:
               cancelBooking();
               break;
   
               case 6:
               System.out.println("Exiting System..!!");
               break;
   
               default:
               System.out.println("Invalid choice. Please Enter valid choice.");
           }
   
           }
           while (choice !=6);
       }
   
   
   public static void addRoom(){
       System.out.print("Enter Room Number :");
       int roomNumer = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter Room Type(Single,Double,Suite): ");
       String roomType = scanner.nextLine();
       System.out.print("Enter Price Per Night :");
       double pricePerNight = scanner.nextDouble();
       scanner.nextLine();
       System.out.print("Is this a Deluxe Room? (Yes/No): ");
       String isDeluxe = scanner.nextLine();
   
       if(isDeluxe.equalsIgnoreCase("yes")){
           System.out.print("Is WiFi Included? (Yes/No): ");
           boolean wifiIncluded =scanner.nextLine().equalsIgnoreCase("yes");
           System.out.print("Is Breakfast Included? (Yes/No)");
           boolean breakfastIncluded =scanner.nextLine().equalsIgnoreCase("yes");
           rooms.add(new DeluxeRoom(roomNumer, roomType, pricePerNight, wifiIncluded, breakfastIncluded));
       }
       else {
           rooms.add(new Room(roomNumer, roomType, pricePerNight));
       }
       System.out.println("Room added successfully!");
   }
   
   public static void displayAllRooms(){
       if(rooms.isEmpty()){
           System.out.println("No rooms are available");
       }
       else{
           for(Room room : rooms){
               room.displayRoomDetails();
               System.out.println("--------------------");
           }
       }
   }
   
   private static void searchRoomByType(){
       System.out.println("Enter Room Type to Search (Single, Double, Suite): ");
       String roomType = scanner.nextLine();
       boolean found = false;
       for(Room room : rooms){
           if(room.getRoomType().equalsIgnoreCase(roomType)){
               room.displayRoomDetails();
               System.out.println("----------------");
               found = true;
           }
       }
       if(!found){
           System.out.println("No rooms found for Search");
       }
   
   }
   
   private static void bookRoom(){
       System.out.print("Enter Room Number to Book: ");
       int roomNumer = scanner.nextInt();
       scanner.nextLine();
       for(Room room :rooms){
           if(room.getRoomNumer() == roomNumer){
               if(room.isAvailable()){
                   room.setAvailability(false);
                   System.out.println("Room booked successfully!");
   
               }
               else{
                   System.out.println("Room is already booked");
               }
               return;
           }
       }
       System.out.println("Room not found");
   }
   public static void cancelBooking(){
       System.out.print("Enter room Number to cancel booking");
       int roomNumer = scanner.nextInt();
       scanner.nextLine();
       for(Room room : rooms){
           if(room.getRoomNumer() == roomNumer){
               if(!room.isAvailable()){
                   room.setAvailability(true);
                   System.out.println("Booking cancelled successfully");
               }
               else{
                   System.out.println("Room is not booked");
               }
               return;
               }
           }
           System.out.println("Room not found.");
       }
   
   
}
