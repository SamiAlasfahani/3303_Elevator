package elevatorstuff;

import java.time.LocalTime;

public class Main {
	public static void main(String args[]) {
		
		
		Scheduler scheduler = new Scheduler();
		FloorSubSystem test = new FloorSubSystem(scheduler);
		FloorSubSystem floor2 = new FloorSubSystem(scheduler);
		
		scheduler.registerFloor(test);
		scheduler.registerFloor(floor2);
		ElevatorSubSystem elevator = new ElevatorSubSystem(scheduler);
		scheduler.registerElevator(elevator);
		
		Thread one = new Thread(test);
		Thread floorThread2 = new Thread(floor2);
		Thread elevThread = new Thread(elevator);
		elevThread.start();
		one.start();
		floorThread2.start();
		
		
		
	}
}
