package com.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * <p>
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 * <p>
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * <p>
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        int[] time = {60, 60, 60};

        System.out.println(numsPairsDivisibleBy60(time));
    }

    static int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        int[] values = new int[60];

        for (int t : time) {
            if (t % 60 == 0) {
                count += values[0];
            } else {
                count += values[60 - t % 60];

                System.out.println(values[60 - t % 60]);

                values[t % 60]++;
            }
        }

        return count;
    }

    static int numsPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;

        for (int t : time) {
            int mod = t % 60;
            int compliment = mod == 0 ? 0 : 60 - mod;
            count += countMap.getOrDefault(compliment,0);
            countMap.put(mod,countMap.getOrDefault(mod,0)+1);
        }

        return count;
    }
}
