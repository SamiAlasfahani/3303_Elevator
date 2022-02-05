package elevatorstuff;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @author Sami Alasfahani
 * 101161597
 */

public class Scheduler implements Runnable{

	private Deque<ElevatorSubSystem> elevators;
	//private Deque<FloorSubSystem> floors;
	
	public Scheduler(){
		elevators = new ArrayDeque<ElevatorSubSystem>();
		//elevators = new ArrayDeque<FloorSubSystem>();
	}
	
	@Override
	public void run() {
		
		//gonna send some dummy data to an elevator just to show how this works
		getData(true, new ElevatorData());
		
	}

	public void registerElevator(ElevatorSubSystem e){
		elevators.push(e);
	}
	
	public void unregisterElevator(ElevatorSubSystem e){
		elevators.remove(e);
	}
	
	public void registerFloor(ElevatorSubSystem e){
		//floors.push(e);
	}
	
	public void unregisterFloor(ElevatorSubSystem e){
		//floors.remove(e);
	}

	/*
	* @params sendToElevator
	*			boolean that tells the scheduler if the request is going to an elevator car or a floor
	*/
	public void getData(boolean sendToElevator, ElevatorData data) {
		if(sendToElevator)
			sendToElevator(data);
		else
			sendToFloor(data);
	}
	
	private void sendToElevator(ElevatorData data) {
		//ONLY SENDING PINGS TO HEAD FOR NOW, THIS WILL CHANGE IN LATER ITERATIONS
		elevators.peek().getData(data);
	}
	
	private void sendToFloor(ElevatorData data) {
		//ONLY SENDING PINGS TO HEAD FOR NOW, THIS WILL CHANGE IN LATER ITERATIONS
		//floors.peek().getData(data);
	}
}
