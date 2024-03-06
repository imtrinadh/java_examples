public class SlidingWindowExample {
    public static void main(String[] args) {

        int [] arr={0,1,2,3,4,5,6,7,8,9};
        int k=3;
        int result=maxSumArray(arr,k);
        System.out.println("Maximum subArray sum is :"+result);
    }
    private static int maxSumArray(int[] arr,int k){
        int maxSum=0;
        int windowSum=0;

        for (int i=0;i<k;i++){
            windowSum+=arr[i];
        }
        maxSum=windowSum;

        for (int i=k;i<arr.length;i++){
            windowSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,windowSum);
        }

        return maxSum;
    }
}
