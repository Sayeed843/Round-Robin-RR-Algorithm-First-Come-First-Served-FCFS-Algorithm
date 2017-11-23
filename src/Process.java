import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Process {
	
	private String process_name;
	private int process_arrival_time;
	private int process_burst_time;
	private int process_save_burst_time;
	private int process_waiting_time;
	private int process_turnaround_time;
	private int process_execution_time;
	private int previous_process_execution_time;
	//private int process_average_time;
	 //int sum_waiting_time=0;
	
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	
	
	//input method ...........................
	
	public void input_process_name() throws IOException{
		System.out.println("Process Name:- ");
		process_name=bf.readLine();
	}
	
	public void input_process_arrival_time() throws IOException{
		System.out.println("Arrival Time:- ");
		process_arrival_time=Integer.parseInt(bf.readLine());
	}
	
	
	public void input_process_burst_time() throws IOException{
		System.out.println("Burst Time:- ");
		process_burst_time=Integer.parseInt(bf.readLine());
	}
	
	
	public void input_process_waiting_time() throws IOException{
		System.out.println("Waiting Time:- ");
		process_waiting_time=Integer.parseInt(bf.readLine());
	}
	
	public void input_process_turnaround_time() throws IOException{
		System.out.println("Turnaround Time:- ");
		process_turnaround_time=Integer.parseInt(bf.readLine());
	}
	
	public void input_process_execution_time() throws IOException{
		System.out.println("Execution Time:- ");
		process_execution_time=Integer.parseInt(bf.readLine());
	}
	
	public void input_process_save_burst_time() throws IOException{
		System.out.println("Save Burst Time:- ");
		process_save_burst_time=Integer.parseInt(bf.readLine());
	}
	
	public void input_previous_process_execution_time() throws IOException{
		System.out.println("previous Process Execution Time:- ");
		previous_process_execution_time=Integer.parseInt(bf.readLine());
	}
	/*
	public void intput_process_average_time() throws IOException{
		System.out.println("Average Time:- ");
		process_average_time=Integer.parseInt(bf.readLine());
	}
	*/
	//Set method.............................
	
	public void set_process_name(String name){
		process_name=name;
	}
	
	public void set_process_arrival_time(int arrival_time){
		process_arrival_time=arrival_time;
	}
	
	public void set_process_burst_time(int burst_time){
		process_burst_time=burst_time;
	}
	
	public void set_process_waiting_time(int waiting_time){
		process_waiting_time=waiting_time;
	}
	/*
	// Method Overread..........
	public void set_process_waiting_time(RoundRobin rr){
		process_waiting_time=rr.get_calculate_waiting_time();
	}*/
	
	public void set_process_turnaround_time(int turnaround_time){
		process_turnaround_time=turnaround_time;
	}
	
	public void set_process_execution_time(int execution_time){
		process_execution_time+=execution_time;
	}
	
	public void set_process_execution_time_fcfs(int execution_time){
		process_execution_time=execution_time;
	}
	
	public void set_process_save_burst_time(int save_burst_time){
		process_save_burst_time=save_burst_time;
	}
	/*
	public void set_process_average_time(int average_time){
		process_average_time=average_time;
	}
	
	
	public void set_sum_waiting_time(){
		//System.out.println("Waiting Time:- ");
		//process.print_process_waiting_time();
		sum_waiting_time=get_process_waiting_time();
		//System.out.println("LOL= "+sum_waiting_time);
	}*/
	
	///Method OverReading..........................
	public void set_process_save_burst_time(){
		process_save_burst_time=get_process_burst_time();
	}
	////////////////////
	
	public void set_previous_process_execution_time(int process_execution_time){
		previous_process_execution_time+=process_execution_time;
	}
	
	public void set_previous_process_execution_time_fcfs(int process_execution_time){
		previous_process_execution_time=process_execution_time;
	}
	
	//get method..........................
	
	public String get_process_name(){
		return process_name;
	}
	
	public int get_process_arrival_time(){
		return process_arrival_time;
	}
	
	public int get_process_burst_time(){
		return process_burst_time;
	}
	
	public int get_process_waiting_time(){
		return process_waiting_time;
	}
	
	public int get_process_turnaround_time(){
		return process_turnaround_time;
	}
	
	public int get_process_execution_time(){
		return process_execution_time;
	}
	
	public int get_process_save_burst_time(){
		return process_save_burst_time;
	}
	
	public int get_previous_process_execution_time(){
		return previous_process_execution_time;
	}

	/*
	public int get_process_average_time(){
		return process_average_time;
	}
	*/
	//print method.................
	
	public void print_process_name(){
		System.out.print(process_name);
	}
	
	public void print_process_arrival_time(){
		System.out.print("\t\t"+process_arrival_time);
	}
	
	public void print_process_burst_time(){
		System.out.print("\t\t"+process_burst_time);
	}
	
	public void print_process_waiting_time(){
		System.out.print("\t\t"+process_waiting_time);
	}
	
	public void print_process_turnaround_time(){
		System.out.print("\t\t"+process_turnaround_time);
	}
	
	public void print_process_execution_time(){
		System.out.println("\t\t"+process_execution_time);
	}
	
	public void print_process_save_burst_time(){
		System.out.print("\t\t"+process_save_burst_time);
	}
	
	public void print_previous_process_execute_time(){
		System.out.println("previous Process Execution Time:- "+previous_process_execution_time);
	}
	
	//public void print_sum_waiting
	
	//other method........................... 
	
	public void calculation_waiting_time(){
		if(get_previous_process_execution_time()!=0){
			process_waiting_time=get_process_execution_time()-get_process_arrival_time()-get_previous_process_execution_time();
		}
		else{
			//System.out.println("LO LO LO");
			process_waiting_time=get_process_execution_time()-get_process_arrival_time();
		}
		
		if(process_waiting_time<0){
			process_waiting_time=0;
		}
		else{
			process_waiting_time=process_waiting_time;
		}
		//sum_waiting_time=process_waiting_time;
	}
	
	public void calculate_turnaround_time(){
		process_turnaround_time=get_process_save_burst_time() + get_process_waiting_time();
	}
	

	/*
	public void calculation_waiting_time_fcfs(){
		process_waiting_time=get_process_execution_time()-get_process_arrival_time();
		if(process_waiting_time<0){
			process_waiting_time=0;
		}
		else{
			process_waiting_time=process_waiting_time;
		}
	}*/
}
