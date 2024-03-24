package BookingSystem;
import java.util.ArrayList;
public class WaitingList {
	private ArrayList<User> VIP,member,normal;
	
	// adding user to waiting queue
	public void addWaiting(User user) {
		if(user instanceof VIP)
			VIP.add(user);
		else if(user instanceof Member)
			member.add(user);
		else
			normal.add(user);
	}
	
	// return waiting list by inserting member type in String
	public ArrayList<User> getWaiting(String member_type) {
		if(member_type.equals("VIP"))
			return VIP;
		else if(member_type.equals("Member"))
			return member;
		else
			return normal;
	}
	
	// remove user by entering user
	public void removeWaiting(User user) {
		if(VIP.contains(user))
			VIP.remove(user);
		else if(member.contains(user))
			member.remove(user);
		else
			normal.remove(user);
	}
}
