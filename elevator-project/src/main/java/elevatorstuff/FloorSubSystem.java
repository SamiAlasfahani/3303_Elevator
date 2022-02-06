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
/**
 * @Author: Thomas Knechtel
 * 101160636
 */
public  class FloorSubSystem implements Runnable {
	private Scheduler scheduler;
	private static boolean full=true;
	/**
	 * Create instance of FloorSubSystem
	 * @param scheduler the Scheduler to send and receive data from
	 */
	public FloorSubSystem(Scheduler scheduler) {
		this.scheduler=scheduler;
	}
	/**
	 * sends new requests of ElevatorData to scheduler
	 */
	public  synchronized void sendRequest() {
		for(ElevatorData data: getRequest()) {
			scheduler.getData(true, data );
			
		}
		
		
		notifyAll();
	}
	/**
	 * parses String x into an Integer object
	 * @param x the String to parse
	 * @return the Integer value
	 */
	static private Integer parseVal(String x) {
		if(x.equals("null"))return null;
		else return Integer.parseInt(x);
		
	}
	/**
	 * If input.txt contains requests that have not been sent to Scheduler than attempt to acquire lock and parse input.txt 
	 * @return list of ElevatorData from input.txt
	 * 
	 */
	private static synchronized List<ElevatorData> getRequest(){
		
		List<ElevatorData> elevatorList=new ArrayList<>();
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
            for(String line=br.readLine(); line!=null; line=br.readLine()) {
                //line = br.readLine();
            	String[] info = line.split(" ");
            	Boolean up=false;
            	if(info[2].equals("up")) up=true;
            	if(info[2].equals("null"))up=null;
            	Integer startFloor = parseVal(info[1]);
            	Integer destFloor = parseVal(info[3]);
            	data=new ElevatorData(false, up, startFloor, destFloor, LocalTime.parse(info[0]));
            	elevatorList.add(data);
            }
            
            	
            	
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		full=false;
		//FloorSubSystem.class.notifyAll();
		return elevatorList;
	}
	/**
	 * If all data in input.txt has been processed overwrite file with new Elevator data
	 * @param data the ElevatorData to be written into input.txt
	 */
	public static synchronized void updateInput(ElevatorData data) {
		while(full) {
			try {
				FloorSubSystem.class.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\elevatorstuff\\input"))) {
			String dir = "null";
			if(data.requestDirection)dir="up";
			else if(!data.requestDirection)dir ="down";
            bw.append(data.time+" "+data.sourceFloor+" "+dir+" "+data.destFloor);
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
		while(true) {
			sendRequest();
		}
		
	}
        

}
