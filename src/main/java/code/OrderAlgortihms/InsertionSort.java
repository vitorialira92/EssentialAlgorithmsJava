package code.OrderAlgortihms;

public class InsertionSort {
    private InsertionSort() {}
    public static void sort(int[] v){
        for(int i = 1; i < v.length; i++){

            int p = v[i];
            int j;

            for(j = i -1; j>=0 && v[j] > p; j--)
                v[j + 1] = v[j];

            v[j + 1] = p;
        }
    }
}
