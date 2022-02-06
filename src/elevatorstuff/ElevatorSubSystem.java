/**
 * ElevatorSubclass
 */

package elevatorstuff;
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
	
	//DELETE THIS VARIABLE IN THE REAL THING
	//IT'S JUST HERE FOR TESTING
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
		while(!canStop) {
			
		}
	}
	
	public void getData(ElevatorData data) {
		System.out.println("We are at: " + data.sourceFloor + "we need to get to floor: " + data.destFloor);
		canStop = true;
		//just small change to show that the classes are working with each other
	}
}