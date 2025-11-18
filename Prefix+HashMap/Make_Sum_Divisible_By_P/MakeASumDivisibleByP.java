import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;

        // Calculate total sum
        for (int num : nums) total += num;

        long target = total % p;
        if (target == 0) return 0; // Already divisible

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1); // Base case

        long prefix = 0;
        int minLen = n;

        for (int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;

            // Required prefix
            long need = (prefix - target + p) % p;

            if (map.containsKey(need)) {
                minLen = Math.min(minLen, i - map.get(need));
            }

            // Store latest index of this prefix mod
            map.put(prefix, i);
        }

        return minLen == n ? -1 : minLen;
    }
}
