package elevatorstuff;

import java.time.LocalTime;

/**
 * 
 * @author Sami Alasfahani
 * 101161597
 */

public class Main {
	
	public static ElevatorData elevatorDestData;
	public static ElevatorData floorDestData;
	public static ElevatorData elevatorSourceData;
	public static ElevatorData floorSourceData;
	
	public static void main(String args[]) throws InterruptedException {
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
		
		testData();
		
	}
	
	//non-framework testing because configuring Junit is kicking my ass
	private static void testData() {
		if(elevatorDestData.getTime() == LocalTime.MIDNIGHT) System.out.println("elevator has received correct data!");
		else System.out.println("elevator has received incorrect data");
		
		if(floorDestData.getTime() == LocalTime.MIDNIGHT) System.out.println("floor has received correct data!");
		else System.out.println("floor has received incorrect data...");
		
		if(elevatorSourceData.getTime() == LocalTime.MIDNIGHT) System.out.println("scheduler has received correct data from elevator!");
		else System.out.println("scheduler has received incorrect data from elevator...");
		
		if(floorSourceData.getTime() == LocalTime.MIDNIGHT) System.out.println("scheduler has received correct data from floor!");
		else System.out.println("scheduler has received incorrect data from floor...");
	}
}
