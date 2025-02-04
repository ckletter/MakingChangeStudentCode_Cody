import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Cody Kletter
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static int TARGET = 2500;
    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);
        long[][] numPathsTo = new long[coins.length][TARGET + 1];
        return numPathsTo(coins, target, numPathsTo, 0);
    }
    public static long numPathsTo(int[] coins, int difference, long[][] numPathsTo, int currentCoinIndex) {
        // Base case, we have reached our target number from adding coins
        if (difference == 0) {
            //  Add one to our number of paths
            return 1;
        }
        // Base case, no more coins left to use
        if (currentCoinIndex >= coins.length) {
            return 0;
        }
        // Base case, have passed 0, meaning the target cannot be reached using the coin path
        if (difference < 0) {
            return 0;
        }
        // Base case, number of paths to current coin and target already known
        if (numPathsTo[currentCoinIndex][difference] != 0) {
            return numPathsTo[currentCoinIndex][difference];
        }
        // Remove the current highest coin from the array list, so we are only subtracting coins less than or equal
        // to the current one
        // Loop through each coin less than the highest and subtract it from our difference
        numPathsTo[currentCoinIndex][difference] = numPathsTo(coins, difference - coins[currentCoinIndex], numPathsTo, currentCoinIndex) + numPathsTo(coins, difference, numPathsTo, currentCoinIndex + 1);
        return numPathsTo[currentCoinIndex][difference];
    }
}
