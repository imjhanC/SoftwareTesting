package BookingSystem;

public class Member extends User{
	private boolean excl_reward;
	
	// constructor 
	public Member(String name) {
		super(name);
		setMax_room_book(2);
	}
	
	// member type getter
	public String getMemberType() {
		return "Member";
	}
	
	// check reward
	public boolean checkExcl_reward() {
		return excl_reward;
	}
}
