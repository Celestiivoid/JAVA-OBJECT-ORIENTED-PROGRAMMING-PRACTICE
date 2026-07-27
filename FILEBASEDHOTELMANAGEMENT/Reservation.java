package FILEBASEDHOTELMANAGEMENT;

class Reservation {
    private Room room;
    private Guest guest;
    private int reservationID;
    private int numberOfNights;
    private double totalCost;
    private String reservationStatus;

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
    void displayReservation() {

    }
    void displayReceipt() {
        
    }

    String getReservationStatus() {
        return reservationStatus;
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
}
