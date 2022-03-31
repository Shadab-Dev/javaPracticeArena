package com.java.Greedy;

import java.util.Arrays;

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        int[] start = {1,3,2,5};
        int[] end = {2,4,3,6};
        ActivitySelectionProblem c = new ActivitySelectionProblem();
        System.out.println(c.activitySelection(start, end, 4));
    }

    public int activitySelection(int start[], int end[], int n)
    {
        if(n<2) return n;
        int result = 1;
        Activity[] activities = new Activity[start.length];
        for (int i = 0; i < activities.length; i++) {
            activities[i] = new Activity(start[i], end[i]);
        }
        Arrays.sort(activities);
        Activity last = activities[0];
        for (int i = 1; i < activities.length; i++) {
            if(activities[i].start > last.end) {
                result++;
                last = activities[i];
            }
        }
        return result;
    }

    public class Activity implements Comparable<Activity>{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Activity act2) {
            return Integer.compare(this.end, act2.end);
        }

        public String toString() {
            return "["+start+","+end+"]";
        }
    }
}
