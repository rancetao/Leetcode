package com.ran.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of
 * the stock), design an algorithm to find the maximum profit.
 * 
 * @author rantao
 *
 */
public class BestTimetoBuyandSellStock {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
      return 0;
    int local = 0;
    int global = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      local = Math.max(local + prices[i + 1] - prices[i], 0);
      global = Math.max(local, global);
    }
    return global;
  }
}
