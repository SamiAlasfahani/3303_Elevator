package elevatorstuff;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Eyas Valdez
 * 101114308
 */

class MainTest {
	
	@BeforeEach
	void setUp() {
		try {
			
		
			Scheduler scheduler = new Scheduler();
			ElevatorSubSystem elevator = new ElevatorSubSystem(scheduler);
			FloorSubSystem floor = new FloorSubSystem(scheduler);
			
			Thread t1 = new Thread(elevator);
			Thread t2 = new Thread(scheduler);
			Thread t3 = new Thread(floor);
			
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail(e);
		}
	}

	
	@Test
	void testElevatorDestData() {
		
		assertEquals(LocalTime.MIDNIGHT, Main.elevatorDestData.getTime());
		
	}
	
	@Test
	void testFloorDestData() {
		
		assertEquals(LocalTime.MIDNIGHT, Main.floorDestData.getTime());
		
	}
	
	@Test
	void testElevatorSourceData	() {
		
		assertEquals(LocalTime.MIDNIGHT, Main.elevatorSourceData.getTime());
		
	}
	
	@Test
	void testFloorSourceData() {
		
		assertEquals(LocalTime.MIDNIGHT, Main.floorSourceData.getTime());
		
	}
	

}
