package rappmahaboob.com23Java.lang.packagesCodeAlphaIntermship;

import java.sql.Date;

class Reservation {
	int reservationId;
	String guestName;
	Date checkInDate;
	Date checkOutDate;
	Room room;

	Reservation(int reservationId, String guestName, Date checkInDate, Date checkOutDate, Room room) {
		this.reservationId = reservationId;
		this.guestName = guestName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
	}
}










