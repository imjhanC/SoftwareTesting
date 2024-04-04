package BookingSystem;

public class Normal extends User{
	// constructor
	public Normal(String name) {
		super(name);
		setMax_room_book(1);
	}
	
	// member type getter
	public String getMemberType() {
		return "Normal";
	}
}
