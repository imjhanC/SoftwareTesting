package BookingSystem;

public class Room {
	//Set arbitrary numbers for the rooms available
	private int vip_room, deluxe_room, standard_room;
	
	public Room(int vip_room, int deluxe_room, int standard_room) {
		this.vip_room = vip_room;
		this.deluxe_room =	deluxe_room;
		this.standard_room = standard_room;
	}

	// check room availability and book room
	public boolean checkRoom(String room_type) {
		if (room_type.toLowerCase().equals("vip")) {
			if (vip_room > 0) {
				return true;
			}else{
				return false;
			}
		}else if(room_type.toLowerCase().equals("deluxe")) {
			if (deluxe_room > 0) {
				return true;
			}else{
				return false;
			}
		}else if(room_type.toLowerCase().equals("standard")) {
			if (standard_room > 0){
				return true;
			}else{
				return false;
			}
		}
		return false; //Room does not exist
	}
	
	// Working in progress
}
