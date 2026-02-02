package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencing{

	static class Job {
		int id;
		int deadline;
		int profit;

		public Job(int id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	private static int getMaxProfit(List<Job> jobs, int n) {

		int maxProfit = 0;
		boolean[] isTaken = new boolean[n];
		boolean[] finished = new boolean[n+1];

		Collections.sort(jobs, (a, b) -> b.profit - a.profit);
		
		for (int i = 0; i < n; i++) {
			for(int j = Math.min(n-1, jobs.get(i).deadline-1) ; j >= 0; j--) {
				if(!isTaken[j]) {
					
					isTaken[j] = true;
					finished[jobs.get(i).id] = true;
					maxProfit += jobs.get(i).profit;
					break;
				}
			}
		}
		
		System.out.print("Finished jobs: ");
		for (int i = 0; i < n+1; i++) {
			if(finished[i])
				System.out.print(i + " ");
		}
		System.out.println();
		
		return maxProfit;
	}

	public static void main(String[] args) {

		int n = 4;
		List<Job> jobs = new ArrayList<>();
		
		jobs.add(new Job(1, 4, 20));
		jobs.add(new Job(2, 1, 10));
		jobs.add(new Job(3, 1, 40));
		jobs.add(new Job(4, 1, 30));

		int res = getMaxProfit(jobs, n);
		System.out.println(res);
	}
}
