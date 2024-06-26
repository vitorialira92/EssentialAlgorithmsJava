package code.OrderAlgortihms;

public final class QuickSort implements ISort {
    public QuickSort()  {}
    @Override
    public String getName() {
        return "Quick Sort";
    }
    public void sort(int[] v){
        sort(v, 0, v.length - 1);
    }
    private static void sort(int[] v, int b, int e) {
        if (b < e) {
            int index = partition(v, b, e);
            sort(v, b, index - 1);
            sort(v, index + 1, e);
        }
    }

    private static int partition(int[] v, int b, int e){

        int pivot = v[e];
        int pos = b;
        for(int i = b; i < e; i++){
            if(v[i] <= pivot){
                int aux = v[pos];
                v[pos] = v[i];
                v[i] = aux;
                pos++;
            }
        }
        int aux = v[pos];
        v[pos] = v[e];
        v[e] = aux;

        return pos;
    }
}
