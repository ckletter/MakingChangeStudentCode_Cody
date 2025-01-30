import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Integer> sortedCoins = new ArrayList<Integer>();
        for (Integer coin : coins) {
            sortedCoins.add(coin);
        }
        sortedCoins.sort(Collections.reverseOrder());
        long[] numPathsTo = new long[TARGET + 1];
        return numPathsTo(sortedCoins, target, target, numPathsTo, 0);
    }
    public static long numPathsTo(ArrayList<Integer> coins, int difference, long totalCount, long[] numPathsTo, int currentCoinIndex) {
        // Base case, we have reached our target number from adding coins
        if (difference == 0) {
            //  Add one to our number of paths
            return 1;
        }
        // Base case, no more coins left to use
        if (coins.size() == currentCoinIndex) {
            return 0;
        }
        // Base case, have passed 0, meaning the target cannot be reached using the coin path
        if (difference < 0) {
            return 0;
        }
        // Base case, we have reached a number we already know the number of paths to
        // Increment number of paths by one
        if (numPathsTo[difference] != 0) {
            numPathsTo[difference] = numPathsTo[difference] + 1;
            return numPathsTo[difference] + 1;
        }
        long pathsToCurrent = 0;
        // Subtract the highest current coin from our difference
        pathsToCurrent += numPathsTo(coins, difference - coins.get(currentCoinIndex), totalCount, numPathsTo, currentCoinIndex);
        // Remove the current highest coin from the array list, so we are only subtracting coins less than or equal
        // to the current one
        // Loop through each coin less than the highest and subtract it from our difference
        for (int i = 0; i < coins.size() - currentCoinIndex; i++) {
            pathsToCurrent += numPathsTo(coins, difference - coins.get(currentCoinIndex + i), totalCount, numPathsTo, currentCoinIndex + 1);
        }
        return pathsToCurrent;
    }
}
