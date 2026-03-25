class Solution {
    int[][] dp;
    int n;
    public boolean isPred(String prev, String curr) {
        if (curr.length() != prev.length() + 1) return false;
        int i = 0, j = 0;
        while (i < prev.length() && j < curr.length()) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == prev.length();
    }
    public int solve(String[] words, int i, int prev) {
        if (i >= n) return 0;
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        int take = 0;
        if (prev == -1 || isPred(words[prev], words[i])) {
            take = 1 + solve(words, i + 1, i);
        }
        int skip = solve(words, i + 1, prev);
        return dp[i][prev + 1] = Math.max(take, skip);
    }
    public int longestStrChain(String[] words) {
        n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(words, 0, -1);
    }
}