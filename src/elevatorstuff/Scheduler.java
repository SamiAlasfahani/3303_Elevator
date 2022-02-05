package elevatorstuff;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the class for the scheduler subsystem
 * it receives data from the elevator subsystem and floor subsystem
 * it takes this data and sends it to the appropriate destination
 * 
 * @author Sami Alasfahani
 * 101161597
 */

public class Scheduler implements Runnable{

	private Deque<ElevatorSubSystem> elevators;
	private Deque<FloorSubSystem> floors;
	
	public Scheduler(){
		elevators = new ArrayDeque<ElevatorSubSystem>();
		floors = new ArrayDeque<FloorSubSystem>();
	}
	
	@Override
	public void run() {
		
	}
	
	/**
	 * registers an ElevatorSubSystem so that it can be sent commands
	 * 
	 * @param e
	 * ElevatorSubSystem to be registered
	 */
	public void registerElevator(ElevatorSubSystem e){
		elevators.push(e);
	}
	
	/**
	 * unregisters an ElevatorSubsystem so that it will not receive commands
	 * 
	 * @param e
	 * ElevatorSubSystem to be unregistered
	 */
	public void unregisterElevator(ElevatorSubSystem e){
		elevators.remove(e);
	}
	
	/**
	 * registers a FloorSubsystem so that it will receive commands
	 * 
	 * @param f
	 * FloorSubsystem to be registered
	 */
	public void registerFloor(FloorSubSystem f){
		floors.push(f);
	}
	
	/**
	 * unregisters a FloorSubsystem so that it will not nreceive commands
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
		if(sendToElevator)
			sendToElevator(data);
		else
			sendToFloor(data);
	}
	
	/**
	 * sends ElevatorData to an appropriate ElevatorSubsystem
	 * NOTE: for now, we are only sending data to 1 specific ElevatorSubsystem
	 * 		 later on the logic of deciding which system to send the data to will be improved
	 * 		 and also encapsulated elsewhere
	 * 
	 * @param data
	 * the data to send
	 */
	private void sendToElevator(ElevatorData data) {
		//ONLY SENDING PINGS TO HEAD FOR NOW, THIS WILL CHANGE IN LATER ITERATIONS
		elevators.peek().getData(data);
	}
	
	/**
	 * sends ElevatorData to an appropriate ElevatorSubsystem
	 * NOTE: for now, we are only sending data to 1 specific FloorSubsystem
	 * 		 later on the logic of deciding which system to send the data to will be improved
	 * 		 and also encapsulated elsewhere
	 * 
	 * @param data
	 * the data to send
	 */
	private void sendToFloor(ElevatorData data) {
		//ONLY SENDING PINGS TO HEAD FOR NOW, THIS WILL CHANGE IN LATER ITERATIONS
		floors.peek().getData(data);
	}
}
