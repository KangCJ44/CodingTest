import java.util.*;

public class Main{
    
    private static int max_result = 0;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        perm(arr, 0);
        System.out.println(max_result);
    }
    
    public static void perm(int[] arr, int depth){
        if(depth == arr.length){
            max_result = Math.max(max_result, calculate(arr));
        }
        else{
            for(int i = depth; i < arr.length; i++){
                swap(arr, depth, i);
                perm(arr, depth + 1);
                swap(arr, depth, i);
            }
        }
    }
    
    public static int calculate(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length - 1; i++){
            sum += Math.abs(arr[i] - arr[i+1]);
        }
        return sum;
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}