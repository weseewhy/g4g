/*
https://practice.geeksforgeeks.org/problems/coin-piles/0

There are N piles of coins each containing  Ai (1<=i<=N) coins.  Now, you have to adjust the number of coins
in each pile such that for any two pile, if a be the number of coins in first pile and b is the number of coins
in second pile then |a-b|<=K. In order to do that you can remove coins from different piles to decrease the
number of coins in those piles but you cannot increase the number of coins in a pile by adding more coins.

Now, given a value of N and K, along with the sizes of the N different piles you have to tell the
minimum number of coins to be removed in order to satisfy the given condition.

Note: You can also remove a pile by removing all the coins of that pile.

Example 1:
Input: [2 2 2 2], k = 0
Output: 0
Explanation: For any two piles the difference in the number of coins is <=0. So no need to remove any coins.

Example 2:
Input: [1 2 5 1 1 1], k = 3
Output: 1
Explanation: If we remove one coin from pile containing 5 coins then for any two piles
the absolute difference in the number of coins is <=3.

Example 3:
Input: [1 5 1 2 5 1], k = 3
Output: 2
Explanation: If we remove one coin each from both the piles containing 5 coins,
then for any two piles the absolute difference in the number of coins is <=3.
*/

import java.util.Arrays;

class Solution {
    public int minCoinsToRemove(int[] arr, int k) {
        if (arr.length <= 1) {
            return 0;
        }

        Arrays.sort(arr);

        int minCoinsToRemove = Integer.MAX_VALUE;
        int numberOfCoinsInAllPreviousPiles = 0;

        // Set each element as lower reference and adjust all other piles
        // When a pile is set as lower ref, all smaller piles have to be removed
        for (int i = 0; i < arr.length && numberOfCoinsInAllPreviousPiles < minCoinsToRemove; i++) {
            int numberOfCoinsToRemoveWithCurPileAsRef = numberOfCoinsInAllPreviousPiles;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i] + k) {
                    numberOfCoinsToRemoveWithCurPileAsRef += (arr[j] - arr[i] - k); // remove extra coins from jth pile
                }
            }

            if (numberOfCoinsToRemoveWithCurPileAsRef < minCoinsToRemove) {
                minCoinsToRemove = numberOfCoinsToRemoveWithCurPileAsRef;
            }

            numberOfCoinsInAllPreviousPiles += arr[i];
        }

        return minCoinsToRemove;
    }
}

/*
Optimization:
No need for inner loop. Use binary search from (i+1 to n) and find the first element that is k greater than cur
Coins will be removed only from that pile onwards
To calculate number of coins to remove from that pile to end, keep track of prefix sum

Hint: https://github.com/ehgh/Coin-Piles/blob/master/CoinPiles.java
*/
