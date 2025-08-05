package CompetitiveCoding;

public class GcdArray {
    int gcd(int a,int b)
    {
        if(b==0)
        return a;
        return gcd(b, a%b);
    }
    public int findGCD(int[] nums) {
        int n = nums.length;
        int gcdValue = nums[0];

        for (int i = 1; i < n; i++) {
            gcdValue = gcd(gcdValue, nums[i]);
        }

        return gcdValue;
    }
    public static void main(String[] args) {
        GcdArray obj = new GcdArray();
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println("GCD of the array: " + obj.findGCD(nums)); // Output: 2
    }
    
}
