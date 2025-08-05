// package CompetitiveCoding;

// public class MaximumProductSubarray {
//     public static int maxProduct(int[] nums) {
//         int maxProd = Integer.MIN_VALUE;
//         int prefix = 1;
//         int suffix = 1;
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             if (prefix == 0) prefix = 1;
//             if (suffix == 0) suffix = 1;

//             prefix *= nums[i];
//             suffix *= nums[n - 1 - i];

//             maxProd = Math.max(maxProd, Math.max(prefix, suffix));
//         }

//         return maxProd;
//     }

//     public static void main(String[] args) {
//         int[] arr = {2, 3, -2, 4};
//         System.out.println("Maximum Product Subarray: " + maxProduct(arr));  // Output: 6
//     }
// }


// Using Kadane's Algorithm
package CompetitiveCoding;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int currProd = 1;

        for (int num : nums) {
            currProd *= num;
            maxProd = Math.max(maxProd, currProd);
            if (currProd == 0) currProd = 1;
        }


        return maxProd;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3,-2,4,-3};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr));  // Output: 24
    }
}
