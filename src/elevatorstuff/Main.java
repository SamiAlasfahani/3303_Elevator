package elevatorstuff;

import java.time.LocalTime;

public class Main {
	public static void main(String args[]) {
		Scheduler scheduler = new Scheduler();
		FloorSubSystem test = new FloorSubSystem(scheduler);
		FloorSubSystem.updateInput(new ElevatorData(false, false, 0, 0, LocalTime.now()));
	}
}
