/*Given a amount ‘A’ and n coins,   v1<v2<v3<………..<vn .
 *  Write a program to find out minimum numbers of coins required to make the change for the amount ‘A’.*/
public class CoinChange {
    public int minCoinDynamic(int amount, int[] coins) {
        // this will store the optimal solution
        // for all the values -- from 0 to given amount.
        int[] coinReq = new int[amount+1];
        
        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1,coinReq[amt]) ;
                }
            }
        }
        //return the optimal solution for amount
        return coinReq[amount];

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int amount = 20;
        CoinChange m = new CoinChange();
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + m.minCoinDynamic(amount, coins));
    }
}