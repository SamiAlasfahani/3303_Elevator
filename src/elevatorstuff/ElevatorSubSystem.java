/**
 * ElevatorSubclass
 */

import java.util.*;

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
	
	/**
	 * Constructor
	 * @param scheduler
	 */
	public ElevatorSubSystem(Scheduler scheduler) {
		this.scheduler = scheduler;
		queuedRequests = new ArrayDeque<ElevatorData>();
	}

	/**
	 * runs elevator thread
	 */
	@Override
	public void run() {
		try {
			queuedRequests.add(scheduler.getData()); //add a request to the queue
			
			currentRequestedFloor = queuedRequests.pop();  //pop the first item to get the current request
			scheduler.setRequest(currentRequestedFloor);   //sent info back to the scheduler		
		} catch (InteruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * main()
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
