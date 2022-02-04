package elevatorstuff;

public class Scheduler implements Runnable{

	//private List<Elevator> elevators;
	//private List<Floors> floors;
	//these lists are commented out so the code doesn't crash and burn before we've added the Elevator and Floor classes
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	public void getData(boolean sendToElevator) {
		//since ElevatorData no longer tells the scheduler where to send the data, we need to tell the scheduler where to send it
		//we could also break this up into two methods like I've done with the sendTo methods
	}
	
	private void sendToElevator(ElevatorData data) {
		//selects which elevator to send to, then sends data
		//might make elevator selection its own method later
	}
	
	private void sendToFloor() {
		//same idea as sendToElevator
		//I've split these two up for now in case sending data to a floor or an elevator differs later on
	}
}
