package elevatorstuff;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This is the class for the scheduler subsystem
 * it receives data from the elevator subsystem and floor subsystem
 * it takes this data and sends it to the appropriate destination
 * 
 * @author Sami Alasfahani
 * 101161597
 */

public class Scheduler implements Runnable{

	private BlockingQueue<ElevatorSubSystem> elevators;
	private BlockingQueue<FloorSubSystem> floors;
	
	public static boolean stopper = false;
	
	public Scheduler(){
		elevators = new ArrayBlockingQueue<ElevatorSubSystem>(10);
		floors = new ArrayBlockingQueue<FloorSubSystem>(10);
	}
	
	@Override
	public void run() {
		System.out.println("scheduler running");
		while(!stopper) {
			
		}
	}
	
	/**
	 * registers an ElevatorSubSystem so that it can be sent commands, this method is thread safe because of BlockingQueue
	 * 
	 * @param e
	 * ElevatorSubSystem to be registered
	 */
	public void registerElevator(ElevatorSubSystem e){
		elevators.add(e);
	}
	
	/**
	 * unregisters an ElevatorSubsystem so that it will not receive commands, this method is thread safe because of BlockingQueue
	 * 
	 * @param e
	 * ElevatorSubSystem to be unregistered
	 */
	public void unregisterElevator(ElevatorSubSystem e){
		elevators.remove(e);
	}
	
	/**
	 * registers a FloorSubsystem so that it will receive commands, this method is thread safe because of BlockingQueue
	 * 
	 * @param f
	 * FloorSubsystem to be registered
	 */
	public void registerFloor(FloorSubSystem f){
		floors.add(f);
	}
	
	/**
	 * unregisters a FloorSubsystem so that it will not receive commands, this method is thread safe because of BlockingQueue
	 * 
	 * @param f
	 * FloorSubsystem to be unregistered
	 */
	public void unregisterFloor(FloorSubSystem f){
		floors.remove(f);
	}

	/**
	 * receives data from either a FloorSubsystem or ElevatorSubsystem
	 * sends that data to the appropriate destination
	 * 
	 * @param sendToElevator
	 * tells the function whether or not the data needs to be sent to an ElevatorSubsystem or not
	 * if not, sends it to a FloorSubsystem instead
	 * 
	 * @param data
	 * this is the data to be sent
	 */
	public void getData(boolean sendToElevator, ElevatorData data) {
		System.out.println("scheduler received some data");
		if(sendToElevator)
			sendToElevator(data);
		else
			sendToFloor(data);
	}
	
	/**
	 * sends ElevatorData to an appropriate ElevatorSubsystem, this method is thread safe because of BlockingQueue
	 * NOTE: for now, we are only sending data to 1 specific ElevatorSubSystem
	 * 		 later on the logic of deciding which system to send the data to will be improved
	 * 		 and also encapsulated elsewhere
	 * 
	 * @param data
	 * the data to send
	 */
	private void sendToElevator(ElevatorData data) {
		System.out.println("sending data to elevator system...");
		Main.floorSourceData = data;
		elevators.peek().getData(data);
	}
	
	/**
	 * sends ElevatorData to an appropriate ElevatorSubsystem, this method is thread safe because of BlockingQueue
	 * NOTE: for now, we are only sending data to 1 specific FloorSubsystem
	 * 		 later on the logic of deciding which system to send the data to will be improved
	 * 		 and also encapsulated elsewhere
	 * 
	 * @param data
	 * the data to send
	 */
	private synchronized void sendToFloor(ElevatorData data) {
		System.out.println("sending data to floor system...");
		Main.elevatorSourceData = data;
		floors.peek().getData(data);
	}
}
