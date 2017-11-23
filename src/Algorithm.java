import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Algorithm {
	private int max_value_index=-1;
	private int mini_value_index=0;
	private int max_value=0;
	private int lower_value=-1;
	private int arrival_value=0;
	private int burst_value=0;
	private int count=-1;
	private int lower_count=0;
	
	
	
	private String activity_name;

	
	BufferedReader bf=new BufferedReader (new InputStreamReader(System.in));
	
	
	//set method.....................
	

	
	//get method..................

	
	public int get_max_value_index(){
		return max_value_index;
	}
	
	public int get_mini_value_index(){
		return mini_value_index;
	}
	
	
	//print method.....................
	
	
	
	//other method.......................
public void sorting_arrival_time(Process process,Process process1) throws IOException{
		
		if(process.get_process_arrival_time() > process1.get_process_arrival_time()){
		arrival_value=process.get_process_arrival_time();
		burst_value=process.get_process_burst_time();
		activity_name=process.get_process_name();
		process.set_process_name(process1.get_process_name());
		process.set_process_arrival_time(process1.get_process_arrival_time());
		process.set_process_burst_time(process1.get_process_burst_time());
		process1.set_process_name(activity_name);
		process1.set_process_arrival_time(arrival_value);
		process1.set_process_burst_time(burst_value);
		//process1.set_process_save_burst_time(burst_value);
		
		}
	}
	
	public void find_max_value_index(Process process){
		if(max_value<process.get_process_burst_time()){
			max_value=process.get_process_burst_time();
			count++;
			max_value_index=count;
			
		}
		else{
			count++;
			max_value_index=max_value_index;
		}
	}
	
	public void find_mini_value_index(Process process){
		if(lower_value==-1){
			lower_value=process.get_process_burst_time();
			//System.out.println("Lol:- "+lower_value);
		}
		else if(lower_value>process.get_process_burst_time()){
				lower_value=process.get_process_burst_time();
				lower_count++;
				mini_value_index=lower_count;
				//System.out.println("Lower value:- "+lower_value);
			}
			else{
				lower_count++;
				lower_value=lower_value;
				mini_value_index=mini_value_index;

		}
		
	}
	
	
	public abstract void algorithm_action(Process process, int x);

}
