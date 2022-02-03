package elevatorstuff;

import java.time.LocalTime;

public class ElevatorData {
	private boolean comesFromFloor;
	private boolean requestDirection;
	
	int sourceFloor;
	int destFloor;
	
	LocalTime time;
	
	public ElevatorData(boolean _comesFromFloor, boolean _requestDirection, int _sourceFloor, int _destFloor, LocalTime _time) {
		comesFromFloor = _comesFromFloor;
		requestDirection = _requestDirection;
		sourceFloor = _sourceFloor;
		destFloor = _destFloor;
		time = _time;
	}
}
