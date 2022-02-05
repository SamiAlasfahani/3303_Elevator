package elevatorstuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public  class FloorSubSystem implements Runnable {
	private Scheduler scheduler;
	private static boolean full=false;
	public FloorSubSystem(Scheduler scheduler) {
		this.scheduler=scheduler;
	}
	public void sendRequest() {
		scheduler.getData(true, getRequest());
	}
	public static synchronized ElevatorData getRequest(){
		
		ElevatorData data=null;
		try (BufferedReader br = new BufferedReader(new FileReader("src\\elevatorstuff\\input"))) {
                while(!full) {
                	try {
						FloorSubSystem.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            	
            	String[] info = br.readLine().split(" ");
            	Boolean up=false;
            	if(info[2].equals("up")) up=true;
            	
                data=new ElevatorData(false, up, Integer.parseInt(info[1]), Integer.parseInt(info[3]), LocalTime.parse(info[3]));
               
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		full=false;
		FloorSubsystem.class.notifyAll();
		return data;
	}
	
	public static synchronized void updateInput(ElevatorData data) {
		while(full) {
			try {
				FloorSubSystem.class.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\elevatorstuff\\input",true))) {
			
            bw.append(data.time+" "+data.sourceFloor+" "+"up "+data.destFloor);
            bw.newLine();
        }catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		full=true;
		FloorSubSystem.class.notifyAll();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
        

}
