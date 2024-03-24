package BookingSystem;

public class Room {
	private int vip = 10;
	private	int deluxe = 20;
	private	int standard = 30;
	
	// check room availability and book room
	public int checkRoom(User user) {
		if(user instanceof VIP && vip > 0) {
			vip--;
			return 1;
		}
		else if((user instanceof Member || user instanceof VIP) && deluxe > 0) {
			deluxe--;
			return 2;
		}
		else if(standard > 0) {
			standard--;
			return 3;
		}
		else
			return 4;
	}
	
	// cancellation of VIP room
	public void removeVIP() {
		vip++;
	}
	
	// cancellation of deluxe room
	public void removeDeluxe() {
		deluxe++;
	}
	
	// cancellation of standard room
	public void removeStandard() {
		standard++;
	}
}
