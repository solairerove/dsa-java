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

    // time O(n + m), space O(m), m = max weight
    public static int numRescueBoatsCountingSort(int[] people, int limit) {
        int max = 0;
        for (int p : people) if (p > max) max = p;

        int[] cnt = new int[max + 1];
        for (int p : people) cnt[p]++;

        int n = people.length;
        int i = 0, j = 1;
        while (i < n) {
            while (cnt[j] == 0) j++;

            people[i++] = j;
            cnt[j]--;
        }

        int res = 0, l = 0, r = n - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }

        return res;
    }
}
