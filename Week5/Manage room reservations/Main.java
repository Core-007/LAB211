import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationLogic reservationLogic = new ReservationLogic();

        while (true) {
            System.out.println("*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all reservations");
            System.out.println("6. Exit");

            System.out.print("You choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1: {
                    System.out.println("*** Create new reservation ***");

                    System.out.print("Booking ID: ");
                    String bookingID = scanner.nextLine();

                    System.out.print("Customer Name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Room Number: ");
                    String roomNumber = scanner.nextLine();

                    System.out.print("Booking Date (dd/MM/yyyy): ");
                    String bookingDate = scanner.nextLine();

                    System.out.print("Need airport pick up? (Y/N): ");
                    String pickUpChoice = scanner.nextLine();
                    FlightInformation flightInformation = null;

                    if (pickUpChoice.equalsIgnoreCase("Y")) {
                        System.out.print("Flight Number: ");
                        String flightNumber = scanner.nextLine();

                        System.out.print("Seat Number: ");
                        String seatNumber = scanner.nextLine();

                        System.out.print("Pick Up Time (dd/MM/yyyy HH:mm): ");
                        String timePickUp = scanner.nextLine();

                        flightInformation = new FlightInformation(flightNumber, seatNumber, timePickUp);
                    }

                    Reservation newReservation = new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInformation);
                    boolean success = reservationLogic.addReservation(newReservation);

                    if (success) {
                        System.out.println("Information saved successfully.");
                    } else {
                        System.out.println("Error: Booking ID must be unique.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("*** Update reservation ***");
                    System.out.print("Enter Booking ID to update: ");
                    String bookingID = scanner.nextLine();

                    Reservation existingReservation = reservationLogic.findReservationByID(bookingID);
                    if (existingReservation != null) {
                        System.out.println("Existing Reservation: " + existingReservation.toString());

                        // Nhập lại thông tin mới
                        System.out.print("New Customer Name (leave empty to skip): ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) existingReservation.setCustomerName(newName);

                        System.out.print("New Phone Number (leave empty to skip): ");
                        String newPhone = scanner.nextLine();
                        if (!newPhone.isEmpty()) existingReservation.setPhoneNumber(newPhone);

                        System.out.print("New Room Number (leave empty to skip): ");
                        String newRoom = scanner.nextLine();
                        if (!newRoom.isEmpty()) existingReservation.setRoomNumber(newRoom);

                        System.out.print("New Booking Date (leave empty to skip): ");
                        String newBookingDate = scanner.nextLine();
                        if (!newBookingDate.isEmpty()) existingReservation.setBookingDate(newBookingDate);

                        System.out.print("Update Flight Information? (Y/N): ");
                        String updateFlight = scanner.nextLine();
                        if (updateFlight.equalsIgnoreCase("Y")) {
                            System.out.print("New Flight Number: ");
                            String newFlightNumber = scanner.nextLine();
                            System.out.print("New Seat Number: ");
                            String newSeatNumber = scanner.nextLine();
                            System.out.print("New Pick Up Time: ");
                            String newPickUpTime = scanner.nextLine();
                            FlightInformation newFlightInfo = new FlightInformation(newFlightNumber, newSeatNumber, newPickUpTime);
                            existingReservation.setFlightInformation(newFlightInfo);
                        }

                        reservationLogic.updateReservation(bookingID, existingReservation);
                        System.out.println("Information updated successfully.");
                    } else {
                        System.out.println("No reservation found with ID: " + bookingID);
                    }
                    break;
                }
                case 3: {
                    System.out.println("*** Delete reservation ***");
                    System.out.print("Enter Booking ID to delete: ");
                    String bookingID = scanner.nextLine();

                    boolean deleted = reservationLogic.deleteReservation(bookingID);
                    if (deleted) {
                        System.out.println("Information deleted successfully.");
                    } else {
                        System.out.println("No reservation found with ID: " + bookingID);
                    }
                    break;
                }
                case 4: {
                    System.out.println("*** Flight Information ***");
                    reservationLogic.printFlightInformation();
                    break;
                }
                case 5: {
                    System.out.println("*** Reservation Information ***");
                    reservationLogic.printAllReservations();
                    break;
                }
                case 6: {
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;  // Kết thúc chương trình
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
