package BookingSystem;

import java.util.ArrayList;
public class Booking {
	Room room;
	WaitingList waitingList;
	ArrayList<ArrayList<String>> room_booked; 

	// set booking
	public boolean setBooking(User user) {
		int count = 0;
		for (ArrayList<String> sublist : room_booked) {
			if(sublist.get(0).equals(user.getName())) {
				count++;
				if(user.getMaxRoomBook() >= count) {
					return false;
				}
			}
        }

		ArrayList<String> booking_info = new ArrayList<>();
		switch (user.getMemberType().toLowerCase()) {
			case "vip":
				if(room.checkRoom("vip")){
					booking_info.add(user.getName());
					booking_info.add("vip");

					room_booked.add(booking_info);
					booking_info.clear();
					return true;
				}else if(room.checkRoom("deluxe")){
					booking_info.add(user.getName());
					booking_info.add("deluxe");

					room_booked.add(booking_info);
					booking_info.clear();
					return true;
				}else if(room.checkRoom("standard")){
					booking_info.add(user.getName());
					booking_info.add("standard");

					room_booked.add(booking_info);
					booking_info.clear();
					return true;
				}else{
					waitingList.addWaiting(user);
					return false;
				}
			case "member":
				if(user.getExclReward()){
					if(room.checkRoom("vip")){
						booking_info.add(user.getName());
						booking_info.add("vip");

						room_booked.add(booking_info);
						booking_info.clear();
						return true;
					}
				}else if(room.checkRoom("deluxe")){
					booking_info.add(user.getName());
					booking_info.add("deluxe");

					room_booked.add(booking_info);
					booking_info.clear();
					return true;
				}else if(room.checkRoom("standard")){
					booking_info.add(user.getName());
					booking_info.add("standard");

					room_booked.add(booking_info);
					booking_info.clear();
					return true;
				}else{
					waitingList.addWaiting(user);
					return false;
				}

			case "non_member":
				if(room.checkRoom("standard")){
					booking_info.add(user.getName());
					booking_info.add("standard");

					room_booked.add(booking_info);
					booking_info.clear();
					return true;
				}else{
					waitingList.addWaiting(user);
					return false;
				}
			default:
				return false;
		}
	}
	
	public void cancelBooking(User user, int bookingNumber){
		int count = 0, i = 0;

		for (ArrayList<String> sublist : room_booked) {
			if(sublist.get(0).equals(user.getName())) {
				if(bookingNumber == count) {
					room_booked.remove(i);
				}
				count++;
			}
			i++;
        }
	}
}
