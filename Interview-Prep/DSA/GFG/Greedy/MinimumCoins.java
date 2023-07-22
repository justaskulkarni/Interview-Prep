package Greedy;

public class MinimumCoins {
    public static int minimumCoins(int V) {
		int[] coins = new int[]{1000, 500, 100, 50, 20, 10, 5, 2, 1};
		int count = 0;
		while(true){
			for(int i = 0; i < coins.length; i++){
				if(V >= coins[i]){
					count++;
					V -= coins[i];
					break;
				}
				if(V == 0)
					return count;
			}
		}
	}
}
