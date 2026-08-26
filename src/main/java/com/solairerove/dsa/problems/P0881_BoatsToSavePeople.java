package com.solairerove.dsa.problems;

import java.util.Arrays;

public class P0881_BoatsToSavePeople {

    // time O(n*log(n)), space O(log(n))
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;
        int res = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }

        return res;
    }
}
