/*
https://www.geeksforgeeks.org/weighted-job-scheduling/
https://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/

Given N jobs where every job is represented by following three elements of it.
    1) Start Time
    2) Finish Time
    3) Profit or Value Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.

Example:
Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50}
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3
but the profit with this schedule is 20+50+100 which is less than 250.
*/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxSalaryPossible(Job[] jobs) {
        Arrays.sort(jobs, new JobSorterByEnd());
        int[] maxSalariesByIndex = new int[jobs.length];
        maxSalariesByIndex[0] = jobs[0].salary;

        for (int i = 1; i < jobs.length; i++) {
            int salaryExcludingJobi = maxSalariesByIndex[i - 1];

            // Since we included current job, previous valid job must end before start of current job
            int indexOfPossiblePreviousJob = getIndexOfPossibleJobBefore(jobs, i);
            int maxSalaryFromPreviousJobs = indexOfPossiblePreviousJob != -1 ? maxSalariesByIndex[indexOfPossiblePreviousJob] : 0;
            int salaryIncludingJobi = jobs[i].salary + maxSalaryFromPreviousJobs;

            maxSalariesByIndex[i] = Math.max(salaryExcludingJobi, salaryIncludingJobi);
        }

        return maxSalariesByIndex[jobs.length - 1];
    }

    // This is O(n) time complexity. Use Binary search to reduce it to log(n)
    // Then the overall complexity of algo changes from O(n^2) to O(nlogn)
    private int getIndexOfPossibleJobBefore(Job[] jobs, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (jobs[j].end <= jobs[i].start) {
                return j;
            }
        }

        return -1;
    }
}

class Job {
    int start;
    int end;
    int salary;

    Job(int start, int end, int salary) {
        this.start = start;
        this.end = end;
        this.salary = salary;
    }
}

class JobSorterByEnd implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        if (j1.end != j2.end) {
            return Integer.compare(j1.end, j2.end);
        } else {
            return Integer.compare(j1.start, j2.start);
        }
    }
}
