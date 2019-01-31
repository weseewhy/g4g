/*
https://www.geeksforgeeks.org/stock-buy-sell/

The cost of a stock on each day is given in an array, find the days on which to buy and sell to get max profit.

For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.

If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<int[]> buySellDatesForMaxProfit(int[] prices) {
        int start = 0;
        int end = 0;
        List<int[]> dates = new ArrayList<>();

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                end = i - 1;
                if (start != end) {
                    dates.add(new int[]{start, end});
                }
                start = i;
            }
        }

        if (start != prices.length - 1) {
            dates.add(new int[]{start, prices.length - 1});
        }

        return dates;
    }
}
