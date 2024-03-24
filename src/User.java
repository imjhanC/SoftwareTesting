package BookingSystem;

public class User {
	// member_type VIP,member,normal

	private String name;
	private int max_room_book;
	// memberType getter
	public String getMemberType() {
		return "User";
	}
	
	// constructor 
	public User(String name) {
		this.name = name;
	}
	
	// set max_room_book
	public void setMax_room_book(int num) {
		max_room_book = num;
	}
	
	// get max_room_book
	public int getmax_room_book(){
		return max_room_book;
	}
}
