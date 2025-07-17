package Array.BuyAndSellStocks;

class Solution {
    public int maxProfit(int[] prices) {
        int minval =  prices[0];
        int profit = 0;
        for(int i = 0;i< prices.length;i++){
            minval = Math.min(minval,prices[i]);
            profit = Math.max(prices[i] - minval,profit);
        }
        return profit;
    }
}
// i
//[7,1,5,3,6,4]
// time complixity = O(n)
