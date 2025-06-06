class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;

        int prev1 = 1; // dp[i-1]
        int prev2 = 1;  //dp[i-2]
        int current = 0;

        for(int i = 2; i <= n; i++) {
            current = prev1 + prev2; 
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}