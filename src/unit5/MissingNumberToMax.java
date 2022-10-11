package _268;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumberToMax {
    public static void main(String[] args) {

        int a = 11;
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1, 11};
//        System.out.println(missingNumberToMax(nums, a));
    }

/*
Imagine a list of numbers from 1 to max_num, inclusive - except that one of these numbers will be missing from the list.
Write a function that takes this list of numbers, as well as the max_num, and it should return the missing number.
For example, given a list of numbers, in random order, of 1…10, 8 was removed. If this list and the maxNum of 10 was
passed into the function, it would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8
If there is no missing number, the function should return 0.
*/

//Option 1 O(N)
//    public static int missingNumberToMax(int[] nums, int maxNum) {
//        //exporting int array to set Spase complexity is big O(N)
//        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//
//        for (int i = 1; i <= maxNum; i += 1) { O(N)
//            if (!set.contains(i)) { //id set doesn't have i number O(1)
//                return i;
//            }
//        }
//        return 0;
//    }

//====================================================================================================================
//Option 2 O(n log n) time that doesn’t require creating another large data structure (technically,
// while being O(n log n) in runtime, it is O(1) in “runspace”—it uses the same amount of memory
// no matter how big n is)



//    public static int missingNumberSort(int[] nums, int maxNum) {
//        Arrays.sort(nums); // O(n log n)
//
//        for (int i = 1; i < maxNum; i += 1) {
//            if (i != nums[i - 1]) {
//                return i;
//            }
//        }
//
//        // If none is missing
//        if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
//            return 0;
//        }
//
//        return maxNum;
//    }


//====================================================================================================================
//Option 3 O(n) runtime and O(1) runspace

    public static int missingNumberSum(int[] nums, int maxNum) {
        // Alternate solution: int sum = (nums.length + 1)*(nums.length) / 2
        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }
}
