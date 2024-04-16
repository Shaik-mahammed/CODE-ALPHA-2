package rappmahaboob.com23Java.lang.packagesCodeAlphaIntermship;

class Room {
	int roomNumber;
	String type;
	boolean available;
	double price;

	Room(int roomNumber, String type, double price) {
		this.roomNumber = roomNumber;
		this.type = type;
		this.available = true;
		this.price = price;
	}

	// Method to book the room
	void bookRoom() {
		this.available = false;
	}

	// Method to cancel the booking of the room
	void cancelBooking() {
		this.available = true;
	}
}




