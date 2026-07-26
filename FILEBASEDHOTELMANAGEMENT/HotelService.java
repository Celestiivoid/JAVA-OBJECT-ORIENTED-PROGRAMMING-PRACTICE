package FILEBASEDHOTELMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class HotelService {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Guest> guest = new ArrayList<>();
    static ArrayList<Room> room = new ArrayList<>();
    static ArrayList<Reservation> reservation = new ArrayList<>();

    void addRoom() {
        while(true) {
            System.out.println("=====ADD-ROOM=====");
            System.out.println("Enter room number: (DLX-XXX)");
            String roomNumber = scanner.nextLine();

            for(int i = 0; i < room.size(); i++) {
                Room existing = room.get(i);
                if(roomNumber.equals(existing.getRoomNumber())) {
                    System.out.println("Room " + existing.getRoomNumber() + " is already existing.");
                    return;
                }
            }

            if(!roomNumber.matches("(DLX)-\\d{3}")) {
                System.out.println("Invalid room number format.");
                continue;
            }

            System.out.println("\nRoom types: " 
            + "\nStandard" 
            + "\nDeluxe" 
            + "\nSuite");
            
            System.out.println("Enter room type: ");
            String roomType = scanner.nextLine();

            if(!roomType.matches("(Standard|Deluxe|Suite)")) {
                System.out.println("Invalid room type.");
                continue;
            }

            System.out.println("\nCapacity guide: "
            + "\nStandard: 3 Person"
            + "\nDeluxe: 6 Person"
            + "\nSuite: 10 Person"
            );

            System.out.println("Enter room capacity: ");
            int capacity;

            try {
                capacity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(!roomType.matches("(Standard|Deluxe|Suite)")) {
                System.out.println("Invalid room type.");
            }

            if(capacity > 3 || capacity < 3) {
                if(roomType.equals("Standard")) {
                    System.out.println("Cannot set less or more than 3 person for standard room type.");
                    continue;
                }
            }

            if(capacity > 6 || capacity < 6) {
                if(roomType.equals("Deluxe")) {
                    System.out.println("Cannot set less or more than 6 person for deluxe room type.");
                    continue;
                }
            }

            if(capacity > 10 || capacity < 10) {
                if(roomType.equals("Suite")) {
                    System.out.println("Cannot set less or more than 10 person for suite room type.");
                    continue;
                }
            }
            
            System.out.println("Enter price per night: ");
            double price;

            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(price <= 0.0) {
            System.out.println("Cannot set 0 or negative numbers.");
            }

            Room newRoom = new Room(roomNumber, roomType, capacity, price, "Available");
            room.add(newRoom);
            System.out.println("Successfully created room.");
            return;
        }
    }
    void viewRooms() {
        if(room.isEmpty()) {
            System.out.println("No available rooms.");
            return;
        }

        for(int i = 0; i < room.size(); i++) {
            Room view = room.get(i);
            System.out.println((i + 1) 
                    + ".) " + "Room number: " + view.getRoomNumber() 
                    + " | Room type: " + view.getRoomType() 
                    + " | Room capacity: " + view.getRoomCapacity() 
                    + " | Price per night: $" + view.getPricePerNight()
                    + " | Room status: " + view.getStatus());
        }
    }
    void searchRoom() {
        while(true) {
            System.out.println("=====SEARCH-ROOM=====");
            System.out.println("Enter room number: ");
            String search = scanner.nextLine();

            for(int i = 0; i < room.size(); i++) {
                Room findRoom = room.get(i);
                if(search.contains(findRoom.getRoomNumber())) {
                    System.out.println("Room found!");
                    System.out.println((i + 1) 
                    + ".) " + "Room number: " + findRoom.getRoomNumber() 
                    + " | Room type: " + findRoom.getRoomType() 
                    + " | Room capacity: " + findRoom.getRoomCapacity() 
                    + " | Price per night: $" + findRoom.getPricePerNight()
                    + " | Room status: " + findRoom.getStatus());
                    return;
                }
            }
            System.out.println("Room not found!");
            return;
        }
    }
    void updateRoom() {
        while(true) {
            System.out.println("=====UPDATE-ROOM=====");
            if(room.isEmpty()) {
            viewRooms();
            }

            viewRooms();
            System.out.println("Pick a room to update: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > room.size()) {
                System.out.println("Out of range!");
                continue;
            }
            else {

                Room selectedRoom = room.get(option - 1);

                System.out.println("Enter room number: (DLX-XXX)");
                String roomNumber = scanner.nextLine();

                if(!roomNumber.matches("(DLX)-\\d{3}")) {
                System.out.println("Invalid room number format.");
                continue;
                }

                System.out.println("\nRoom types: " 
                + "\nStandard" 
                + "\nDeluxe" 
                + "\nSuite");
            
                System.out.println("Enter room type: ");
                String roomType = scanner.nextLine();

                if(!roomType.matches("(Standard|Deluxe|Suite)")) {
                System.out.println("Invalid room type.");
                continue;
                }


                System.out.println("\nCapacity guide: "
                + "\nStandard: 3 Person"
                + "\nDeluxe: 6 Person"
                + "\nSuite: 10 Person"
                );

                System.out.println("Enter room capacity: ");
                int capacity;

                try {
                    capacity = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(capacity > 3 || capacity < 3) {
                    if(roomType.equals("Standard")) {
                        System.out.println("Cannot set less or more than 3 person for standard room type.");
                        continue;
                    }
                }

                if(capacity > 6 || capacity < 6) {
                    if(roomType.equals("Deluxe")) {
                        System.out.println("Cannot set less or more than 6 person for deluxe room type.");
                        continue;
                    }
                }

                if(capacity > 10 || capacity < 10) {
                    if(roomType.equals("Suite")) {
                        System.out.println("Cannot set less or more than 10 person for suite room type.");
                        continue;
                    }
                }
            
                System.out.println("Enter price per night: ");
                double price;

                try {
                    price = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(price <= 0.0) {
                System.out.println("Cannot set 0 or negative numbers.");
                }


                System.out.println("\nRoom status: " 
                + "\nAvailable" 
                + "\nReserved" 
                + "\nOccupied");
                System.out.println("Enter room status: ");
                String status  = scanner.nextLine();

                if(!status.matches("(Available|Reserved|Occupied)")) {
                    System.out.println("Invalid room status.");
                    continue;
                }

                for(Room auth : room) {
                    if(status.equals(auth.getStatus())) {
                        System.out.println("Room " + selectedRoom.getRoomNumber() + " is already " + status + ".");
                        return;
                    }
                }

                Room updateRoom = new Room(roomNumber, roomType, capacity, price, status);
                room.set(option - 1, updateRoom);
                System.out.println("Successfully updated room.");
                return;
            }
        }
    }
    void removeRoom() {
        while(true) {
            System.out.println("=====REMOVE-ROOM=====");

            if(room.isEmpty()) {
                viewRooms();
                return;
            }

            viewRooms();
            System.out.println("Pick a room to remove: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > room.size()) {
                System.out.println("Out of range!");
                continue;
            }

            room.remove(option - 1);
            System.out.println("Successfully remove room!");
            return;
        }
    }
    void addGuest() {
        while(true) {
            System.out.println("=====ADD-GUEST=====");
            System.out.println("Enter guest name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            System.out.println("Enter contact number: ");
            String contactNumber = scanner.nextLine();

            if(!contactNumber.matches("\\d{11}")) {
                System.out.println("Invalid contact number. (Must be 11 digits.)");
                continue;
            }
            int guestID = random.nextInt(1000,9999);
            Guest newGuest = new Guest(guestID, name, contactNumber);
            guest.add(newGuest);
            System.out.println("Successfully added guest!");
            System.out.println("Your ID: " + guestID);
            return;
        }
    }
    void searchGuest() {
        while(true) {
            System.out.println("=====SEARCH-GUEST=====");
            System.out.println("Enter guest ID: ");
            int ID;

            try {
                ID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(ID < 1000 || ID > 9999) {
                System.out.println("4 digits only.");
            }

            for(int i = 0; i < guest.size(); i++) {
                Guest find = guest.get(i);
                if(ID == find.getGuestID()) {
                    System.out.println("Guest Found!");
                    System.out.println("Guest ID: " + find.getGuestID() 
                    + " | Guest name: " + find.getGuestName() 
                    + " | Contact number: " + find.getContactNumber());
                    return;
                }
            }
            System.out.println("Guest not found!");
            return;
        }
    }
    void updateGuest() {
        while(true) {
            System.out.println("=====UPDATE-GUEST=====");
            if(guest.isEmpty()) {
                viewGuest();
            }
            viewGuest();
            System.out.println("Pick a guest: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > guest.size()) {
                System.out.println("Out of range!");
                continue;
            }
            else {
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();

                if(newName.isEmpty()) {
                    System.out.println("Name field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new contact number: ");
                String newContactNumber = scanner.nextLine();

                if(!newContactNumber.matches("\\d{11}")) {
                    System.out.println("Invalid contact number. Must be 11 digits.");
                    continue;
                }
                int updguestID = random.nextInt(1000,9999);
                Guest updateGuest = new Guest(updguestID, newName, newContactNumber);
                guest.set(option - 1, updateGuest);
                System.out.println("Successfully updated guests' information.");
                System.out.println("Your new updated ID: " + updguestID);
                return;
            }
        }
        
    }
    void viewGuest() {
        if(guest.isEmpty()) {
            System.out.println("No guest at the moment.");
            return;
        }

        for(int i = 0; i < guest.size(); i++) {
            Guest view = guest.get(i);
            System.out.println((i + 1) + ".) " + " Guest ID: " + view.getGuestID());
            System.out.println();
        }
    }
    void reserveRoom() {
        while(true) {
            System.out.println("=====RESERVE-ROOM=====");
            if(room.isEmpty()) {
                viewRooms();
                return;
            }

            viewRooms();
            System.out.println("Select a room to reserve: ");
            int roomOpt;


            try {
                roomOpt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(roomOpt < 1 || roomOpt > room.size()) {
                System.out.println("Out of range!");
                continue;
            }

            Room selectedRoom = room.get(roomOpt - 1);

            for(Reservation reservations : reservation) {
                if(reservations.getRoom() == selectedRoom
                    && reservations.getReservationStatus().equals(reservations.getReservationStatus())) {
                        System.out.println("Room " + selectedRoom.getRoomNumber() + " is already " + reservations.getReservationStatus() + ".");
                        return;
                }
            }
        
            if(guest.isEmpty()) {
                viewGuest();
                return;
            }

            viewGuest();
            System.out.println("Select a guest: ");
            int guestOpt;

            try {
                guestOpt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(guestOpt < 1 || guestOpt > guest.size()) {
                System.out.println("Out of range!");
                continue;
            }

            Guest selectedGuest = guest.get(guestOpt - 1);
            int reservationID = random.nextInt(1000,9999);
            Reservation newReservation = new Reservation(selectedRoom, selectedGuest, reservationID, "Reserved");
            reservation.add(newReservation);
            selectedRoom.setStatus("Reserved");
            System.out.println("Successfully reserved room " + selectedRoom.getRoomNumber());
            System.out.println("Your reservation ID: " + reservationID);
            return;
        }
    }

    void cancelReservation() {
        while(true) {
            boolean isFound = false;
            Room isFoundR = null; 
            Reservation isFoundRes = null;
            System.out.println("=====CANCEL-RESERVATION=====");
            System.out.println("Enter reservation ID: ");
            int reservationID;

            try {
                reservationID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(reservationID < 1000 || reservationID > 9999) {
                System.out.println("4 digits only.");
                continue;
            }

            for(int i = 0; i < reservation.size() && i < room.size(); i++) {
                Reservation ID = reservation.get(i);
                if(reservationID == ID.getReservationID()) {
                    isFound = true;
                    isFoundR = ID.getRoom();
                    isFoundRes = ID;
                    System.out.println("Guest ID: "+ ID.getGuest().getGuestID() 
                    + " | Guest name: " + ID.getGuest().getGuestName()
                    + " | contact number: " + ID.getGuest().getContactNumber() 
                    + " | Room number: " + ID.getRoom().getRoomNumber()
                    + " | Room type: " + ID.getRoom().getRoomType()
                    + " | Room capacity: " + ID.getRoom().getRoomCapacity()
                    + " | Price per night: " + ID.getRoom().getPricePerNight());
                }
            }

            if(!isFound || isFoundR == null) {
                System.out.println("Room not found!");
                return;
            }

            System.out.println("Cancel reservation? ");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 2) {
                System.out.println("Out of range!");
                continue;
            }

            switch(option) {
                case 1 -> {
                    isFoundR.setStatus("Available");
                    isFoundRes.setReservationStatus("Cancelled");
                    System.out.println("Successfully cancelled reservation for " + isFoundR.getRoomNumber());
                    return;
                }
                case 2 -> {
                    return;
                }
            }
        }
    }
    void checkIn() {
        while(true) {
            boolean isFound = false;
            Room isFoundR = null;
            Reservation isFoundRes = null;
            System.out.println("=====CHECK-IN-RESERVATION=====");
            System.out.println("Enter reservation ID: ");
            int reservationID;

            try {
                reservationID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(reservationID < 1000 || reservationID > 9999) {
                System.out.println("Out of range!");
                continue;
            }

            for(int i = 0; i < reservation.size() && i < room.size(); i++) {
                Reservation ID = reservation.get(i);
                if(reservationID == ID.getReservationID()) {
                    isFound = true;
                    isFoundR = ID.getRoom();
                    isFoundRes = ID;
                    System.out.println("Reservation found!");
                    System.out.println("Guest ID: "+ ID.getGuest().getGuestID() 
                    + " | Guest name: " + ID.getGuest().getGuestName()
                    + " | contact number: " + ID.getGuest().getContactNumber() 
                    + " | Room number: " + ID.getRoom().getRoomNumber()
                    + " | Room type: " + ID.getRoom().getRoomType()
                    + " | Room capacity: " + ID.getRoom().getRoomCapacity()
                    + " | Price per night: " + ID.getRoom().getPricePerNight());
                }
            }

            if(!isFound) {
                System.out.println("Room not found!");
                return;
            }
            System.out.println("Check in reservation? ");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 2) {
                System.out.println("Out of range!");
                continue;
            }

            switch(option) {
                case 1 -> {
                    isFoundR.setStatus("Checked-in");
                    isFoundRes.setReservationStatus("Checked-in");
                    System.out.println("Successfully checked in " + isFoundR.getRoomNumber());
                    return;
                }
                case 2 -> {
                    return;
                }
            }
        }
    }
    void checkOut() {
        while(true) {
            boolean isFound = false;
            Room isFoundR = null;
            Reservation isFoundRes = null;
            System.out.println("=====CHECK-OUT=====");
            System.out.println("Enter reservation ID: ");
            int reservationID;

            try {
                reservationID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(reservationID < 1000 || reservationID > 9999) {
                System.out.println("Invalid reservation ID.");
                continue;
            }
            

            for(int i = 0; i < reservation.size() && i < room.size(); i++) {
                Reservation ID = reservation.get(i);
                if(reservationID == ID.getReservationID()) {
                    isFound = true;
                    isFoundR = ID.getRoom();
                    isFoundRes = ID;
                    System.out.println("Reservation found!");
                    System.out.println("Guest ID: "+ ID.getGuest().getGuestID() 
                    + " | Guest name: " + ID.getGuest().getGuestName()
                    + " | contact number: " + ID.getGuest().getContactNumber() 
                    + " | Room number: " + ID.getRoom().getRoomNumber()
                    + " | Room type: " + ID.getRoom().getRoomType()
                    + " | Room capacity: " + ID.getRoom().getRoomCapacity()
                    + " | Price per night: " + ID.getRoom().getPricePerNight());
                }
            }

            if(!isFound) {
                System.out.println("Room not found!");
                return;
            }
            System.out.println("Check in reservation? ");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 2) {
                System.out.println("Out of range!");
                continue;
            }

            if(!isFoundRes.getReservationStatus().equals("Checked-in")) {
                System.out.println("Room " + isFoundRes.getRoom().getRoomNumber() + " is not yet checked-in.");
                return;
            }

            switch(option) {
                case 1 -> {
                    isFoundR.setStatus("Available");
                    isFoundRes.setReservationStatus("Checked-out");
                    System.out.println("Successfuly checked out.");
                    return;
                }
                case 2 -> {
                    return;
                }
            }
        }
    }

    void viewReservations() {
        System.out.println("=====HOTEL-RESERVATION-HISTORY=====");
        if(reservation.isEmpty()) {
            System.out.println("No reservations at the moment.");
            return;
        }

        for(int i = 0; i < reservation.size(); i++) {
            Reservation display = reservation.get(i);
            System.out.println("Guest ID: "+ display.getGuest().getGuestID() 
            + " | Guest name: " + display.getGuest().getGuestName()
            + " | contact number: " + display.getGuest().getContactNumber() 
            + " | Room number: " + display.getRoom().getRoomNumber()
            + " | Room type: " + display.getRoom().getRoomType()
            + " | Room capacity: " + display.getRoom().getRoomCapacity()
            + " | Price per night: " + display.getRoom().getPricePerNight()
            + " | Status: " + display.getReservationStatus());
        }
    }
}
