package com.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
    public static void main(String[] args) {

        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));

        int[] nums1 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums1));
    }

    static int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;

       for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num) > nums.length/2){
                result = num;
                break;
            }
       }
        return result;
    }
}
