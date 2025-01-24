/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author [YOUR NAME HERE]
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        return 0;
    }
    public static long tryCoin(int target, int[] coins, int sum, long totalCount) {
        // Base case, we have reached our target number from adding coins
        if (sum == target) {
            //  Add one to our total count of permutations
            return 1;
        }
        // Base case, have passed target number from adding coins
        if (sum > target) {
            return 0;
        }
        for (int coin : coins) {
            totalCount = totalCount + tryCoin(target, coins, sum + coin, totalCount);
        }
        return totalCount;
    }
}
