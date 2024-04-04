package BookingSystem;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class Testing {

    @Mock
    private Room room;

    @Mock
    private WaitingList waitingList;

    private Booking booking;

    @Before
    public void setUp() {
        booking = new Booking();
        booking.room = room;
        booking.waitingList = waitingList;
        booking.vipRoom = new ArrayList<>();
        booking.deluxeRoom = new ArrayList<>();
        booking.standardRoom = new ArrayList<>();
    }

    @Test
    public void test1() {
        VIP vipUser = new VIP("VIP User");
        when(room.checkRoom(vipUser)).thenReturn(1); // VIP room available

        assertTrue(booking.setBooking(vipUser));

        // Verify that VIP room is assigned
        assertEquals(1, booking.vipRoom.size());
        assertTrue(booking.vipRoom.contains(vipUser));

        // Verify that waiting list is not used
        verify(waitingList, never()).addWaiting(any(User.class));
    }

    @Test
    public void test2() {
        VIP vipUser = new VIP("VIP User");
        when(room.checkRoom(vipUser)).thenReturn(4); // VIP room full, Deluxe room available

        assertTrue(booking.setBooking(vipUser));

        // Verify that Deluxe room is assigned
        assertEquals(1, booking.deluxeRoom.size()); // <-- Failing assertion
        assertTrue(booking.deluxeRoom.contains(vipUser));

        // Verify that waiting list is not used
        verify(waitingList, never()).addWaiting(any(User.class));
    }
    
    @Test
    public void test3() {
        VIP vipUser = new VIP("VIP User");
        when(room.checkRoom(vipUser)).thenReturn(3); // VIP and Deluxe rooms full, Standard room available

        assertTrue(booking.setBooking(vipUser));

        // Verify that Standard room is assigned
        assertEquals(1, booking.standardRoom.size());
        assertTrue(booking.standardRoom.contains(vipUser));

        // Verify that waiting list is not used
        verify(waitingList, never()).addWaiting(any(User.class));
    }
    
    
    @Test
    public void test4() {
    	VIP vipUser = new VIP("VIP User");
        when(room.checkRoom(vipUser)).thenReturn(4); // All rooms full

        assertFalse(booking.setBooking(vipUser));

        // Verify that VIP user is added to the waiting list
        verify(waitingList).addWaiting(vipUser);

        // Verify that no room is assigned
        assertTrue(booking.vipRoom.isEmpty());
        assertTrue(booking.deluxeRoom.isEmpty());
        assertTrue(booking.standardRoom.isEmpty());
    }
    
    @Test
    public void test5() {
    	VIP vipUser = new VIP("VIP User");
        when(room.checkRoom(vipUser)).thenReturn(4); // Deluxe and Standard rooms full

        assertFalse(booking.setBooking(vipUser));

        // Verify that VIP user is added to the waiting list
        verify(waitingList).addWaiting(vipUser);

        // Verify that no room is assigned
        assertTrue(booking.vipRoom.isEmpty());
        assertTrue(booking.deluxeRoom.isEmpty());
        assertTrue(booking.standardRoom.isEmpty());
    }
    
    @Test
    public void test6() {
    	VIP vipUser = new VIP("VIP User");
        when(room.checkRoom(vipUser)).thenReturn(1); // VIP room available

        assertFalse(booking.setBooking(vipUser));

        // Verify that no room is assigned
        assertTrue(booking.vipRoom.isEmpty());
        assertTrue(booking.deluxeRoom.isEmpty());
        assertTrue(booking.standardRoom.isEmpty());

        // Verify that waiting list is not used
        verify(waitingList, never()).addWaiting(any(User.class));
    }
}

