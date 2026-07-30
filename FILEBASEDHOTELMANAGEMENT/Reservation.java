package FILEBASEDHOTELMANAGEMENT;
import java.util.ArrayList;
class Reservation {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private Room room;
    private Guest guest;
    private int reservationID;
    private int numberOfNights;
    private double totalCost;
    private String reservationStatus;
    private double change;
    private int guestID;
    private String guestName;
    private String contactNumber;
    private String roomNumber;
    private String roomType;
    private int capacity;
    private double pricePerNight;

    Reservation(Room rooms,
        Guest guest,
        int reservationID,
        String reservationStatus, 
        int numberOfNights) {

        this.room = rooms;
        this.guest = guest;
        this.reservationID = reservationID;
        this.reservationStatus = reservationStatus;
        this.numberOfNights = numberOfNights;
    }

    Reservation(Guest guest,
        int reservationID, 
        String guestName, 
        String contactNumber,
        String roomNumber,
        String roomType,
        int capacity,
        String reservationStatus,
        Double pricePerNight,
        int numberOfNights,
        Double totalCost,
        Double change
        ) {
        this.guest = guest;
        this.reservationID = reservationID;
        this.guestName = guestName;
        this.contactNumber = contactNumber;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.reservationStatus = reservationStatus;
        this.pricePerNight = pricePerNight;
        this.numberOfNights = numberOfNights;
        this.totalCost = totalCost;
        this.change = change;
    }


    void calculateTotal() {
        totalCost = numberOfNights * room.getPricePerNight();
    }

    double calculateChange(double cash) {
        if(totalCost > cash) {
            System.out.println("Insufficient amount.");
        }
        return change = cash - totalCost;
    }


    /*Getters*/

    int getGuestID() {
        return guestID;
    }

    String getGuestName() {
        return guestName;
    }

    String getContactNumber() {
        return contactNumber;
    }

    String getReservationStatus() {
        return reservationStatus;
    }
    String getRoomNumber() {
        return roomNumber;
    }

    String getRoomType() {
        return roomType;
    }
    
    int getCapacity() {
        return capacity;
    }

    double getPricePerNight() {
        return pricePerNight;
    }

    double getChange() {
        return change;
    }
    int getNumberOfNights() {
        return numberOfNights;
    }
    double getTotalCost() {
        return totalCost;
    }
    void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    int getReservationID() {
        return reservationID;
    }
    Room getRoom() {
        return room;
    }
    Guest getGuest() {
        return guest;
    }

    ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
