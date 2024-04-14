package code.OrderAlgortihms;

public class BubbleSort implements ISort {
    public BubbleSort() {}
    @Override
    public String getName() {
        return "Bubble Sort";
    }
    public void sort(int[] v){
        for(int i = 0; i < v.length; i++){
            for(int j = 1; j < v.length; j++){
                if(v[j - 1] > v[j]){
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
    }
}
