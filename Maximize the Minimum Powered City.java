class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        // Precompute the initial power for each city using sliding window
        long[] power = new long[n];
        long windowSum = 0;

        // Initial window
        for (int i = 0; i <= r && i < n; i++) {
            windowSum += stations[i];
        }

        for (int i = 0; i < n; i++) {
            power[i] = windowSum;
            if (i - r >= 0) windowSum -= stations[i - r];
            if (i + r + 1 < n) windowSum += stations[i + r + 1];
        }

        long lo = 0, hi = 0;
        for (int s : stations) hi += s;
        hi += k; // upper bound (max possible total power)

        long ans = 0;

        // Binary search for the maximum possible minimum power
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (canAchieve(mid, power.clone(), r, k)) {
                ans = mid;
                lo = mid + 1; // try for a higher minimum power
            } else {
                hi = mid - 1; // too high, reduce
            }
        }

        return ans;
    }

    // Helper function to check if we can achieve at least 'target' power everywhere
    private boolean canAchieve(long target, long[] power, int r, long k) {
        int n = power.length;
        long[] diff = new long[n + 1]; // difference array to track added power
        long added = 0; // running sum of difference array (active added power)

        for (int i = 0; i < n; i++) {
            added += diff[i]; // apply difference updates
            power[i] += added;

            if (power[i] < target) {
                long need = target - power[i];
                if (need > k) return false; // not enough stations left
                k -= need;
                added += need;

                // add station effect in range [i, i + 2r]
                if (i + 2 * r + 1 < n) diff[i + 2 * r + 1] -= need;
            }
        }
        return true;
    }
}
