import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmOperation {

	
	static int i, j, x=4,sum_waiting_time=0;
	static double average_time;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Process [] process=new Process[x];
		Process [] p=new Process[x];
		
		RoundRobin rr=new RoundRobin();
		FCFS fcfs=new FCFS();
		
		
		for( i=0;i<x;i++){
			process[i]=new Process();
			p[i]=new Process();
			process[i].input_process_name();
			process[i].input_process_arrival_time();
			process[i].input_process_burst_time();
			process[i].set_process_execution_time(0);
			
		}
		
		
		
		//OutPut..................
		System.out.println("Activity Name"+"\tArrival Time"+"\tBurst Time");
		for(i=0;i<x;i++){
			process[i].print_process_name();
			process[i].print_process_arrival_time();
			process[i].print_process_burst_time();

			System.out.println();
			
		}
		
		for(i=0;i<x;i++){
			for(j=i+1;j<x;j++){
				rr.sorting_arrival_time(process[i],process[j]);
				//fcfs.sorting_arrival_time(process[i],process[j]);
			}
			process[i].set_process_save_burst_time();
			
		}
		/*
		//output again....................
		System.out.println("%%%%Sorted Table%%%");
		System.out.println("Activity Name"+"\tArrival Time"+"\tBurst Time"+"\tSave Burst Time");
		for(i=0;i<x;i++){
			process[i].print_process_name();
			process[i].print_process_arrival_time();
			process[i].print_process_burst_time();
			process[i].set_process_save_burst_time();
			process[i].print_process_save_burst_time();
			System.out.println();
			
		}*/
		
		// RoundRobin Operation.....................
		for(i=0;i<x;i++){
			rr.find_max_value_index(process[i]);
			rr.find_mini_value_index(process[i]);
		}
		rr.input_roundrobin_quantum_time();
		
		
		for(i=0;i<x;i++){
			rr.algorithm_action(process[i],x);
			if(process[rr.get_max_value_index()].get_process_burst_time()<=0){
				break;
			}
			if(i==x-1){
				i=-1;

			}	
		}
		
		System.out.println("");
		System.out.println("Final Table For RoundRobin");
		System.out.println("Activity Name"+"\tArrival Time"+"\tWaiting Time"+"\tBurst Time"+"\tTurnaround Time");
		for(i=0;i<x;i++){
			process[i].print_process_name();
			process[i].print_process_arrival_time();
			//process[i].print_process_burst_time();
			process[i].calculation_waiting_time();
			process[i].calculate_turnaround_time();
			process[i].print_process_waiting_time();
			process[i].print_process_save_burst_time();
			process[i].print_process_turnaround_time();
			sum_waiting_time+=process[i].get_process_waiting_time();
			
			if(i==x-1){
				System.out.println();
				System.out.println();
				average_time=sum_waiting_time/x;
				System.out.println("Average Waiting Time:- "+average_time);
			}
			
			System.out.println();
			
		}
		
		//FCFS Operation.............................
		for(i=0;i<x;i++){
			
			process[i].set_process_execution_time_fcfs(0);
			process[i].set_previous_process_execution_time_fcfs(0);
			
		}
		
		for(i=0;i<x;i++){
			fcfs.algorithm_action(process[i], x);
		}
		
		System.out.println();
		System.out.println("Final Table For FCFS");
		System.out.println("Activity Name"+"\tArrival Time"+"\tWaiting Time"+"\tBurst Time"+"\tTurnaround Time");
		for(i=0;i<x;i++){
			process[i].print_process_name();
			process[i].print_process_arrival_time();
			//process[i].print_process_burst_time();
			process[i].calculation_waiting_time();
			process[i].calculate_turnaround_time();
			process[i].print_process_waiting_time();
			process[i].print_process_save_burst_time();
			process[i].print_process_turnaround_time();
			sum_waiting_time+=process[i].get_process_waiting_time();
			
			if(i==x-1){
				System.out.println();
				System.out.println();
				average_time=sum_waiting_time/x;
				System.out.println("Average Waiting Time:- "+average_time);
			}
			
			System.out.println();
			
		}
		

	}

}
