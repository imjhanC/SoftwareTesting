package BookingSystem;

import java.util.ArrayList;
public class Booking {
	Room room;
	WaitingList waitingList;
	ArrayList<User> vipRoom, deluxeRoom, standardRoom; 
	
	// set booking
	public boolean setBooking(User user) {
		int check = room.checkRoom(user);
		if(check == 4) { // all room full
			waitingList.addWaiting(user);
			return false;
		}
		else {
			user.setMax_room_book(user.getmax_room_book()-1);
			switch(check) {
				case 1:
					vipRoom.add(user);
					break;
				case 2:
					deluxeRoom.add(user);
					break;
				case 3:
					standardRoom.add(user);
					break;
			}
			return true;
		}
	}
	
	public void cancelBooking(User user) {
		if(standardRoom.contains(user)) {
			standardRoom.remove(user);
			user.setMax_room_book(user.getmax_room_book()+1);
			room.removeStandard();
		}
		else if(deluxeRoom.contains(user)) {
			deluxeRoom.remove(user);
			user.setMax_room_book(user.getmax_room_book()+1);
			room.removeDeluxe();
		}
		else if(vipRoom.contains(user)) {
			vipRoom.remove(user);
			user.setMax_room_book(user.getmax_room_book()+1);
			room.removeVIP();
		}		
	}
}
