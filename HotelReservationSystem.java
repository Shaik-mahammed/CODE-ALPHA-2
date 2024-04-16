package rappmahaboob.com23Java.lang.packagesCodeAlphaIntermship;

import java.util.*;

import java.sql.Date;
import java.util.List;

public class HotelReservationSystem {
	List<Room> rooms;
	List<Reservation> reservations;
	static int reservationCounter;

	public HotelReservationSystem() {
		rooms = new ArrayList<>();
		reservations = new ArrayList<>();
		reservationCounter = 1;
	}

	// Method to add rooms to the hotel
	public void addRoom(int roomNumber, String type, double price) {
		Room room = new Room(roomNumber, type, price);
		rooms.add(room);
	}

	// Method to search for available rooms
	public List<Room> searchAvailableRooms(Date checkInDate, Date checkOutDate) {
		List<Room> availableRooms = new ArrayList<>();
		for (Room room : rooms) {
			if (room.available) {
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}

	// Method to make a reservation
	public Reservation makeReservation(String guestName, Date checkInDate, Date checkOutDate, Room room) {
		Reservation reservation = new Reservation(reservationCounter++, guestName, checkInDate, checkOutDate, room);
		room.bookRoom();
		reservations.add(reservation);
		return reservation;
	}

	// Method to cancel a reservation
	public void cancelReservation(int reservationId) {
		for (Reservation reservation : reservations) {
			if (reservation.reservationId == reservationId) {
				reservation.room.cancelBooking();
				reservations.remove(reservation);
				break;
			}
		}
	}

	// Method to display booking details
	public void displayBookingDetails() {
		System.out.println("Booking Details:");
		for (Reservation reservation : reservations) {
			System.out.println("Reservation ID: " + reservation.reservationId);
			System.out.println("Guest Name: " + reservation.guestName);
			System.out.println("Room Number: " + reservation.room.roomNumber);
			System.out.println("Check-In Date: " + reservation.checkInDate);
			System.out.println("Check-Out Date: " + reservation.checkOutDate);
			System.out.println("--------------------------------------");
		}
	}

	public static void main(String[] args) {
		HotelReservationSystem hotel = new HotelReservationSystem();

		// Adding rooms to the hotel
		hotel.addRoom(101, "Single", 50.0);
		hotel.addRoom(102, "Double", 75.0);
		hotel.addRoom(103, "Suite", 100.0);

		// Searching for available rooms
		@SuppressWarnings("deprecation")
		List<Room> availableRooms = hotel.searchAvailableRooms(
				new Date(reservationCounter, reservationCounter, reservationCounter),
				new Date(reservationCounter, reservationCounter, reservationCounter));

		if (availableRooms.isEmpty()) {
			System.out.println("No rooms available for the selected dates.");
		} else {
			// Making reservation for the first available room
			Room room = availableRooms.get(0);
			@SuppressWarnings("deprecation")
			Reservation reservation = hotel.makeReservation("John Doe", new Date(reservationCounter),
					new Date(reservationCounter, reservationCounter, reservationCounter), room);
			System.out.println("Reservation made successfully with ID: " + reservation.reservationId);
		}

		// Displaying booking details
		hotel.displayBookingDetails();
	}
}








