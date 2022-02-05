package elevatorstuff;

import java.time.LocalTime;

public class ElevatorData {
	Boolean requestDirection;
	
	Integer sourceFloor;
	Integer destFloor;
	
	LocalTime time;
	
	public ElevatorData(Boolean _comesFromFloor, Boolean _requestDirection, Integer _sourceFloor, Integer _destFloor, LocalTime _time) {
		requestDirection = _requestDirection;
		sourceFloor = _sourceFloor;
		destFloor = _destFloor;
		time = _time;
	}
}
