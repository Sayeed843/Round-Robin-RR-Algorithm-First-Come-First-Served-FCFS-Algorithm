import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoundRobin extends Algorithm {
	
	private int burst_count;
	private int burst_time;
	private int execution_count=0;
	int j;
	//private int save_burst_time;
	
	private int roundrobin_quantum_time;
	
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	
	//input method....................
	public void input_roundrobin_quantum_time() throws IOException{
		System.out.println("Quantum Time:- ");
		roundrobin_quantum_time=Integer.parseInt(bf.readLine());
	}
	
	//set method...............................
	public void set_roundrobin_counting_time(int counting_time){
		roundrobin_quantum_time=counting_time;
	}
	
	public void set_burst_count(int count){
		burst_count=count;
	}
	
	
	//get method.................
	public int get_roundrobin_counting_time(){
		return roundrobin_quantum_time;
	}
	
	public int get_execution_count(){
		return execution_count ;
	}
	
	public int get_burst_count(){
		return burst_count;
	}

	
	//print method................
	public void print_roundrobin_quantum_time(){
		System.out.println("Quantum Time:- "+roundrobin_quantum_time);
	}

	//.................................................................
	
	
	//////////////////////////
	public void algorithm_action(Process process, int x){	

		if(process.get_process_burst_time()>0){
			process.set_process_execution_time(execution_count);

		}

			burst_count=0;
			for(j=1;j<=get_roundrobin_counting_time();j++){
				if(process.get_process_burst_time()>0){
					System.out.print("*");
					burst_count++;
					execution_count++;

				}
				if(process.get_process_burst_time()==j){
					j=get_roundrobin_counting_time();
				}

			}
			if(process.get_process_burst_time()>0){
				System.out.print(":");
				process.print_process_name();
				System.out.print(":");
			}
			burst_time=process.get_process_burst_time()-get_burst_count();
			
			
			process.set_process_burst_time(burst_time);
			
			if(process.get_process_burst_time()>0){
				process.set_previous_process_execution_time(execution_count);
			}
			else{
				process.set_previous_process_execution_time(0);
			}
			
			

	}
	

}
