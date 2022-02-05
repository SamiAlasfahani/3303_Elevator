package elevatorstuff;

import java.time.LocalTime;

public class Main {
	public static void main(String args[]) {
		FloorSubsystem test = new FloorSubsystem();
		test.updateInput(new ElevatorData(false, false, 0, 0, LocalTime.now()));
	}
}
