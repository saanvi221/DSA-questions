class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[] heights = new int[matrix[0].length];
        int max = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1')
                    heights[i]++;
                else
                    heights[i] = 0;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }

            stack.push(i);
        }

        return max;
    }
}