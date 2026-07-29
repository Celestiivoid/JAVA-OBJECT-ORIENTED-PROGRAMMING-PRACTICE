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

    Reservation(Room rooms, Guest guest, int reservationID, String reservationStatus, int numberOfNights) {
        this.room = rooms;
        this.guest = guest;
        this.reservationID = reservationID;
        this.reservationStatus = reservationStatus;
        this.numberOfNights = numberOfNights;
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

    String getGuestName() {
        return guest.getGuestName();
    }

    String getGuestID() {
        return guest.getGuestName();
    }

    String getContactNumber() {
        return guest.getContactNumber();
    }

    String getRoomNumber() {
        return room.getRoomNumber();
    }

    String getRoomType() {
        return room.getRoomType();
    }

    Double getPricePerNight() {
        return room.getPricePerNight();
    }

    int getCapacity() {
        return room.getRoomCapacity();
    }

    String getReservationStatus() {
        return reservationStatus;
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
