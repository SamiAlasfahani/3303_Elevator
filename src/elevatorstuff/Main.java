package elevatorstuff;

public class Main {
	public static void main(String args[]) {
		Scheduler scheduler = new Scheduler();
		ElevatorSubSystem elevator = new ElevatorSubSystem(scheduler);
		
		new Thread(elevator).start();
		new Thread(scheduler).start();
	}
}
