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
	 * this is the direction that the elevator is requested to go in
	 * @param _sourceFloor
	 * this is the floor that a request came from
	 * @param _destFloor
	 * this is the destination floor of the request
	 * @param _time
	 * this is the time the request was made at
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
	 * the floor the request came from
	 */
	public Integer getSourceFloor() {
		return sourceFloor;
	}
	
	/**
	 * returns the floor that a request is destined for, can return null if the request is calling an elevator car
	 * 
	 * @return destFloor
	 * the floor the request is sending the elevator to
	 */
	public Integer getDestFloor() {
		return destFloor;
	}
	
	/**
	 * returns the time a request was made at
	 * 
	 * @return time
	 * the time the request was made
	 */
	public LocalTime getTime() {
		return time;
	}
}

