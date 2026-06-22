package greedy.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestJobFirst {
	
	static class Process {
		int id;
		int arrival;
		int burst;
		
		public Process(int id, int arrival, int burst) {
			this.id = id;
			this.arrival = arrival;
			this.burst = burst;
		}

		@Override
		public String toString() {
			return "Process [id=" + id + ", arrival=" + arrival + ", burst=" + burst + "]";
		}	
	}
	
	private static List<Integer> getOrder(List<Process> list) {
		
		List<Integer> res = new ArrayList<>();
		
		// sort given list according to arrival time
		Collections.sort(list, new Comparator<Process>() {
			public int compare(Process o1, Process o2) {
				if(o1.arrival == o2.arrival)
					return o1.burst - o2.burst;
				return o1.arrival - o2.arrival;
			}
		});	
		
		// Create min-heap according to burst time
		PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>() {
			public int compare(Process o1, Process o2) {
				if(o1.burst == o2.burst)
					return o1.arrival - o2.arrival;
				return o1.burst - o2.burst;
			}
		});
				
		Process p;
		p = list.get(0);
		pq.add(new Process(p.id, p.arrival, p.burst));
		
		int time = 0;
		int i = 1;
		
		while(!pq.isEmpty()) {
			
			p = pq.poll();
			res.add(p.id);
			time += p.burst;
			
//			System.out.printf("id: %d, Completion: %d, Turn-Around: %d,  Waiting: %d", p.id, time, time-p.arrival, time-p.arrival-p.burst);
//			System.out.println();
			
			while(true) {
				if(i < list.size() && list.get(i).arrival <= time) {
					p = list.get(i);
					pq.add(new Process(p.id, p.arrival, p.burst));
					i++;
				} else {
					break;
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		List<Process> list = new ArrayList<>();
		
		list.add(new Process(1, 2, 3));
		list.add(new Process(2, 0, 4));
		list.add(new Process(3, 4, 2));
		list.add(new Process(4, 5, 4));
		
		List<Integer> res = getOrder(list);
		
		System.out.println("Processes will execute in the following order :");
		System.out.println("Process id: " + res);
	}
}

// 1. Completion Time: Time at which process completes its execution.
// 2. Turn Around Time: Time Difference between completion time and arrival time.= Completion Time – Arrival Time
// 3. Waiting Time(W.T): Time Difference between turn around time and burst time. = Turn Around Time – Burst Time