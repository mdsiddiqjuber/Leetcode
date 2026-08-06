class Solution {
    public int smallestNumber(int n, int t) {
        int temp = n;
        while(true) {
            int temp1 = temp;
            int product = 1;
            while(temp1 > 0) {
                int rem = temp1 % 10;
                product *= rem;
                temp1 /= 10;
            }
            if(product % t == 0) {
                return temp;
            }
            temp++;
        }
    }
}