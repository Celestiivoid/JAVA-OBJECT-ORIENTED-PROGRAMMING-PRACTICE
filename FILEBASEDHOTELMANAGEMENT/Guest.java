package FILEBASEDHOTELMANAGEMENT;

class Guest {
    private int guestID;
    private String guestName;
    private String contactNumber;

    Guest(int guestID, String guestName, String contactNumber) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.contactNumber = contactNumber;
    }

    int getGuestID() {
        return guestID;
    }
    String getGuestName() {
        return guestName;
    }
    String getContactNumber() {
        return contactNumber;
    }
}
