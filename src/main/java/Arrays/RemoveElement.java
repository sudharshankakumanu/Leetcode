package Arrays;

//https://leetcode.com/problems/remove-element/

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};

        System.out.println(removeElement(arr, 2));
    }

    public static int removeElement(int[] A, int elem) {

       // if(A.length < 2) return A.length; not needed

        int m = 0;
        for(int i = 0; i < A.length; i++){

            if(A[i] != elem){
                A[m] = A[i];
                m++;
            }
        }

        return m;
    }
}
