package BookingSystem;
import java.util.ArrayList;
public class WaitingList {
	private ArrayList<User> vip_waiting_list, member_waiting_list, non_member_waiting_list;
	
	// adding user to waiting queue
	public void addWaiting(User user) {
		if(user.getMemberType().equals("vip")){
			vip_waiting_list.add(user);
		}else if(user.getMemberType().equals("member")){
			member_waiting_list.add(user);
		}else if(user.getMemberType().equals("non_member")){
			non_member_waiting_list.add(user);
		}
	}
	
	// return waiting list by inserting member type in String
	public ArrayList<User> getWaiting(String member_type) {
		switch(member_type.toLowerCase()){
			case "vip": 
				return vip_waiting_list;
			case "member":  
				return member_waiting_list;
			case "non_member":
				return non_member_waiting_list;
		}
		return null;
	}
	
	// remove user by entering user
	public void removeWaiting(User user) {
		
	}
}
