package BookingSystem;

public class VIP extends User{
	// constructor
	public VIP(String name) {
		super(name);
		setMax_room_book(3);
	}
	
	// member type getter
	public String getMemberType() {
		return "VIP";
	}
}
