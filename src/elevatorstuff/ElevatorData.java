package elevatorstuff;

import java.time.LocalTime;

public class ElevatorData {
	private boolean requestDirection;
	
	Integer sourceFloor;
	Integer destFloor;
	
	LocalTime time;
	
	public ElevatorData( boolean _requestDirection, Integer _sourceFloor, Integer _destFloor, LocalTime _time) {
		requestDirection = _requestDirection;
		sourceFloor = _sourceFloor;
		destFloor = _destFloor;
		time = _time;
	}
	
	//dummy constructor
	public ElevatorData(){
		
	}
}
