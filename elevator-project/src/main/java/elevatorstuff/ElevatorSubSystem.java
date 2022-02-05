package elevatorstuff;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Khanh Vu 
 * 101106673
 */



public class ElevatorSubSystem implements Runnable{

	/**
	 * needed variables for the elevator to operate
	 */
	private Scheduler scheduler;
	private ElevatorData currentRequestedFloor;
	private Deque<ElevatorData> queuedRequests;
	
	//vars for unit testing
	private boolean canStop = false;
	
	/**
	 * Constructor
	 * @param scheduler
	 */
	public ElevatorSubSystem(Scheduler scheduler) {
		this.scheduler = scheduler;
		scheduler.registerElevator(this);
		queuedRequests = new ArrayDeque<ElevatorData>();
	}

	/**
	 * runs elevator thread
	 */
	@Override
	public void run() {
		/*try {
			queuedRequests.add(scheduler.getData()); //add a request to the queue
			
			currentRequestedFloor = queuedRequests.pop();  //pop the first item to get the current request
			scheduler.setRequest(currentRequestedFloor);   //sent info back to the scheduler		
		} catch (InteruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("elevators running");
		while(!canStop){
			
		}
	}
	
	public void getData(ElevatorData data){
		System.out.println(data.getTime());
		Main.elevatorDestData = data; //this is for testing
		sendData(data);
	}
	
	public void sendData(ElevatorData data) {
		scheduler.getData(false, data);
		canStop = true;
	}

}
