package code.OrderAlgortihms;

public class MergeSort {
    private MergeSort() {}
    public static void sort(int[] v){
        sort(v, 0, v.length);
    }
    private static void sort(int[] v, int b, int e){
        if(e > b + 1){
            int m = (b + e) / 2;
            sort(v, b, m);
            sort(v, m, e);
            interleave(v, b, m, e);
        }
    }

    private static void interleave (int[] v, int b, int m, int e){
        int f = b, s = m;
        int cont = 0;
        int[] aux = new int[e - b];

        //primeira ordenação -> adiciona os f menores que os de s
        while(f < m && s < e){
            if(v[f] <= v[s])
                aux[cont ++] = v[f++];
            else
                aux[cont ++] = v[s++];
        }

        //segunda ordenação -> adiciona o resto dos f (são maiores que todos os outros)
        while( f < m )
            aux[cont ++] = v[f++];

        //ultima ordenação -> adiciona o resto dos s
        while( s < e )
            aux[cont ++] = v[s++];

        //transfere para o vetor certo
        for(cont = 0; cont < (e - b); cont ++){
            v[b + cont] = aux [cont];
            System.out.println("V em " + (b+cont) + " tem valor " + aux[cont]);
        }

    }
}
