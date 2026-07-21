class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        String t = "1" + s + "1";
        int m = t.length();

        int ans = totalOnes;

        int i = 1;
        while (i < m - 1) {

            // Find a block of 1's surrounded by 0's
            if (t.charAt(i) == '1' &&
                t.charAt(i - 1) == '0') {

                int j = i;
                while (j < m && t.charAt(j) == '1') j++;

                if (j < m && t.charAt(j) == '0') {

                    int removed = j - i;

                    int left = i - 1;
                    while (left >= 0 && t.charAt(left) == '0') left--;
                    int leftZeros = (i - 1) - left;

                    int right = j;
                    while (right < m && t.charAt(right) == '0') right++;
                    int rightZeros = right - j;

                    int gain = leftZeros + removed + rightZeros;

                    ans = Math.max(ans, totalOnes - removed + gain);
                }

                i = j;
            } else {
                i++;
            }
        }

        return ans;
    }
}