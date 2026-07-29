package FILEBASEDHOTELMANAGEMENT;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
class FileManager {

    void saveGuest(ArrayList<Guest> guest) throws IOException{
        BufferedWriter save = new BufferedWriter(new FileWriter("Guest.csv"));
        for(Guest guests : guest) {
            save.write(guests.getGuestID() 
            + "," + guests.getGuestName()
            + ", " + guests.getContactNumber());
        }
        save.close();

    }
    void loadGuest(ArrayList<Guest> guest) throws IOException{
        BufferedReader load = new BufferedReader(new FileReader("Guest.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] guestData = line.split(",");
            int guestID = Integer.parseInt(guestData[0]);
            String guestName = guestData[1];
            String contactNumber = guestData[2];

            guest.add(new Guest(guestID, guestName, contactNumber));
        }
        load.close();
    }
    void saveRoom(ArrayList<Room> rooms) throws IOException{
        BufferedWriter save = new BufferedWriter(new FileWriter("Room.csv"));

        for(Room room : rooms) {
            save.write(room.getRoomNumber()
            + "," + room.getRoomType()
            + "," + room.getRoomCapacity()
            + "," + room.getPricePerNight()
            + "," + room.getStatus());
        }
        save.close();
    }
    void loadRoom(ArrayList<Room> rooms) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("Room.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] roomData = line.split(",");
            String roomNumber = roomData[0];
            String roomType = roomData[1];
            int roomCapacity = Integer.parseInt(roomData[2]);
            double pricePerNight = Double.parseDouble(roomData[3]);
            String status = roomData[4];
            rooms.add(new Room(roomNumber, roomType, roomCapacity, pricePerNight, status));
        }
        load.close();
    }
    void saveReservation(ArrayList<Guest> guest, ArrayList<Room> rooms, ArrayList<Reservation> reservations) throws IOException {

    }
    void loadReservation(ArrayList<Guest> guest, ArrayList<Room> rooms, ArrayList<Reservation> reservations) throws IOException {

    }
}
