package com.code;

import java.util.HashSet;
import java.util.Set;

public class FrogJump {

    public static void main(String[] args) {
        int [] stones = {0,1,3,5,6,8,12,17};

        System.out.println(canCross(stones));
    }

    static boolean canCross(int[] stones) {

        if (stones == null || stones.length == 0) {
            return false;
        }
        int n = stones.length;
        if (n == 1) return true;
        if (stones[1] != 1) return false;
        if (n == 2) return true;

        Set<Integer> stoneSet = new HashSet<>();
        int last = stones[stones.length-1];

        for (int i = 0; i < stones.length; i++) {

            if (i > 3 && stones[i] > stones[i - 1] * 2) {
                return false;
            }
            stoneSet.add(stones[i]);
        }

        return canReach(stoneSet, last, 1, 1);
    }

    static boolean canReach(Set<Integer> stoneSet, int last, int pos, int jump) {

        if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
            return true;
        }

        if(jump > 1 && stoneSet.contains(pos + jump - 1)){
            if(canReach(stoneSet,last,pos + jump -1, jump -1)){
                return true;
            }
        }

        if(stoneSet.contains(pos + jump)){
            if(canReach(stoneSet,last,pos + jump, jump)){
                return true;
            }
        }

        if(stoneSet.contains(pos + jump + 1)){
            if(canReach(stoneSet,last, pos + jump + 1,jump + 1)){
                return true;
            }
        }

        return false;
    }
}
