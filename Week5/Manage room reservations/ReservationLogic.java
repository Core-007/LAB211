//logic xử lý như kiểm tra tính hợp lệ, thêm, cập nhật, xóa, v.v.

import java.util.ArrayList;
import java.util.List;

public class ReservationLogic {
    private List<Reservation> reservations = new ArrayList<>();

    // Thêm đặt phòng
    public boolean addReservation(Reservation reservation) {
        for (Reservation r : reservations) {
            if (r.getBookingID().equals(reservation.getBookingID())) {
                return false; // ID phải duy nhất
            }
        }
        reservations.add(reservation);
        return true;
    }

    // Tìm kiếm đặt phòng theo ID
    public Reservation findReservationByID(String bookingID) {
        for (Reservation reservation : reservations) {
            if (reservation.getBookingID().equals(bookingID)) {
                return reservation;
            }
        }
        return null; // Không tìm thấy
    }

    // Cập nhật đặt phòng
    public boolean updateReservation(String bookingID, Reservation updatedReservation) {
        Reservation existing = findReservationByID(bookingID);
        if (existing != null) {
            existing.setCustomerName(updatedReservation.getCustomerName());
            existing.setPhoneNumber(updatedReservation.getPhoneNumber());
            existing.setRoomNumber(updatedReservation.getRoomNumber());
            existing.setBookingDate(updatedReservation.getBookingDate());
            existing.setFlightInformation(updatedReservation.getFlightInformation());
            return true;
        }
        return false;
    }

    // Xóa đặt phòng
    public boolean deleteReservation(String bookingID) {
        Reservation reservation = findReservationByID(bookingID);
        if (reservation != null) {
            reservations.remove(reservation);
            return true;
        }
        return false;
    }

    // In tất cả đặt phòng
    public void printAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservation data available.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.toString());
            }
        }
    }

    // In thông tin chuyến bay cần đón
    public void printFlightInformation() {
        if (reservations.isEmpty()) {
            System.out.println("No reservation data available.");
        } else {
            for (Reservation reservation : reservations) {
                if (reservation.getFlightInformation() != null && !reservation.getFlightInformation().getFlightNumber().isEmpty()) {
                    System.out.println("Flight Information: " + reservation.getFlightInformation().toString());
                }
            }
        }
    }
}
