package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindSumCombination {
    int[] intArray = {2, 3, 1, 7, 9, 8, 64, 4, 32, 15, 432, 643, 364, 3543, 64, 374, 3532, 423, 62, 0, 4, 53, 54, 24, 32, 4, 253, 24, 3253, -1, 24, 325, 2, 324, 61, 5423, 24, 324, 32, 4, 32, 42, -3, -6};


    public static void main(String[] args) {
        FindSumCombination main = new FindSumCombination();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the target number: ");
        int target = scanner.nextInt();

        List<List<Integer>> results = main.findTargetSum(main.intArray, target, 0);

        if (!results.isEmpty()) {
            System.out.println("Combinations that add up to the target:");
            for (List<Integer> result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println("No combination found that adds up to the target.");
        }
    }

    public List<List<Integer>> findTargetSum(int[] nums, int target, int index) {
        List<List<Integer>> allResults = new ArrayList<>();
        Set<List<Integer>> uniqueResults = new HashSet<>();

        if (target == 0) {
            List<Integer> emptyResult = new ArrayList<>();
            allResults.add(emptyResult);
            uniqueResults.add(emptyResult);
        }

        if (index == nums.length) {
            return allResults;
        }

        if (nums[index] <= target) {
            List<List<Integer>> resultsWithCurrentNum = findTargetSum(nums, target - nums[index], index + 1);

            for (List<Integer> result : resultsWithCurrentNum) {
                List<Integer> newResult = new ArrayList<>(result);
                newResult.add(nums[index]);
                newResult.sort(Integer::compareTo); // Sort the list to make it unique
                uniqueResults.add(newResult);
            }
        }

        List<List<Integer>> resultsWithoutCurrentNum = findTargetSum(nums, target, index + 1);
        uniqueResults.addAll(resultsWithoutCurrentNum);

        allResults.addAll(uniqueResults); // Add all unique combinations to the final result

        return allResults;
    }
}
