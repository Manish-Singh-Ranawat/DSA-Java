// Maximum meetings - https://www.naukri.com/code360/problems/maximum-meetings_1062658?leftPanelTabValue=PROBLEM

// You are given the schedule of 'N' meetings with their start time 'Start[i]' and end time 'End[i]'.
// You have only 1 meeting room. So, you need to return the maximum number of meetings you can organize.

// Note: The start time of one chosen meeting can’t be equal to the end time of the other chosen meeting.

// Input: 'N' = 3, Start = [1, 3, 6], End = [4, 8, 7].
// Output: 2
// Explanation: You can organize a maximum of 2 meetings. Meeting number 1 from 1 to 4, Meeting number 3 from 6 to 7.

import java.util.Arrays;

class meeting {
    int start;
    int end;

    meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MaximumMeetings {
    public static int maximumMeetings(int[] start, int[] end) {
        int n = start.length;
        meeting[] meetingsArr = new meeting[n];
        for (int i = 0; i < n; i++) {
            meetingsArr[i] = new meeting(start[i], end[i]);
        }
        Arrays.sort(meetingsArr, (a, b) -> (a.end - b.end));
        int lastEnd = meetingsArr[0].end;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (meetingsArr[i].start > lastEnd) {
                count++;
                lastEnd = meetingsArr[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 6 };
        int[] end = { 4, 8, 7 };
        System.out.println(maximumMeetings(start, end));
        // 2
    }
}
