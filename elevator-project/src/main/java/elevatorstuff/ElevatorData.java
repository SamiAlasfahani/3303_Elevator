package elevatorstuff;

import java.time.LocalTime;

/**
 * 
 * @author Sami Alasfahani
 * 101161597
 *
 */

public class ElevatorData {
	private boolean requestDirection;
	
	private Integer sourceFloor;
	private Integer destFloor;
	
	private LocalTime time;
	
	/**
	 * constructor for ElevatorData, fills all fields
	 * 
	 * @param _requestDirection
	 * @param _sourceFloor
	 * @param _destFloor
	 * @param _time
	 */
	public ElevatorData( boolean _requestDirection, Integer _sourceFloor, Integer _destFloor, LocalTime _time) {
		requestDirection = _requestDirection;
		sourceFloor = _sourceFloor;
		destFloor = _destFloor;
		time = _time;
	}
	
	/**
	 * dummy constructor to create an empty ElevatorData
	 */
	public ElevatorData(){
		
	}
	
	/**
	 * returns the direction that the request wants to go in
	 * 
	 * @return requestDirection
	 */
	public boolean getRequestDirection() {
		return requestDirection;
	}
	
	/**
	 * returns the floor that a request was sourced from, can return null if the request was from an elevator
	 * 
	 * @return sourceFloor
	 */
	public Integer getSourceFloor() {
		return sourceFloor;
	}
	
	/**
	 * returns the floor that a request is destined for, can return null if the request is calling an elevator car
	 * 
	 * @return destFloor
	 */
	public Integer getDestFloor() {
		return destFloor;
	}
	
	/**
	 * returns the time a request was made at
	 * 
	 * @return time
	 */
	public LocalTime getTime() {
		return time;
	}
}

