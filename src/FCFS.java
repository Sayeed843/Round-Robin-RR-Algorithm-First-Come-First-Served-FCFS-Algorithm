
public class FCFS extends Algorithm {
	
	private int burst_count;
	private int burst_time;
	private int execution_count=0;
	
	public int get_burst_count(){
		return burst_count;
	}
	
	@Override
	public void algorithm_action(Process process, int x) {
		// TODO Auto-generated method stub
		
		if(execution_count==0){
			process.set_process_execution_time(0);

		}
		else{/*
			System.out.println("LO LO LO");
			System.out.println(execution_count);*/
			process.set_process_execution_time_fcfs(execution_count);
			//System.out.println("Super Execution:- ");
			//process.print_previous_process_execute_time();
		}
		//burst_count=0;
		
		for(int j=1;j<=process.get_process_save_burst_time();j++){
			System.out.print("*");
			//burst_count++;
			execution_count++;

		}
		System.out.print(":");
		process.print_process_name();
		System.out.print(":");
		
		//burst_time=process.get_process_burst_time()-get_burst_count();
		//process.set_process_burst_time(burst_time);
		
	}
	

}
