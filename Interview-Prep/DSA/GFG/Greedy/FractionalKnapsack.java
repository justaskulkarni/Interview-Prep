package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<Item>(){
            public int compare(Item i1, Item i2){
                double cpr1 = new Double((double)i1.value / (double)i1.weight);
                double cpr2 = new Double((double)i2.value / (double)i2.weight);
                if(cpr1 < cpr2)
                    return 1;
                return -1;
            }
        });
        double maxValue = 0;
        for(int i = 0; i < n; i++){
            if(W >= arr[i].weight){
                W -= arr[i].weight;
                maxValue += (double)arr[i].value;
            }
            else{
                maxValue += ((double)W / arr[i].weight * arr[i].value);
                break;
            }
        }
        return maxValue;
    }
}
