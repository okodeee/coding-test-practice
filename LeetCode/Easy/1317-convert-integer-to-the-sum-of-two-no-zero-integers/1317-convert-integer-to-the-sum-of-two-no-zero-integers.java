class Solution {
    public int[] getNoZeroIntegers(int n) {
        int first = 1;
        int second = n - first;

        for (first = 1; first < n; first++) {
            boolean valid = true;
            int temp = first;

            while (temp > 0) {
                if (temp % 10 == 0) {
                    valid = false;
                    break;
                }
                temp /= 10;
            }
            if (!valid) continue;
            
            second = n - first;
            temp = second;

            while (temp > 0) {
                if (temp % 10 == 0) {
                    valid = false;
                    break;
                }
                temp /= 10;
            }
            if (!valid) continue;
            return new int[] { first, second };
            
        }

        return new int[] { first, second };
    }
}