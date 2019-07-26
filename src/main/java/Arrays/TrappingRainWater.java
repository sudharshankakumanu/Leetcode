package Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] arr = {1,7,5};

        System.out.println(trap(arr));

    }

    public static int trap(int[] height) {

        if(height == null || height.length < 3) return 0;
        int len = height.length;

        int water = 0;

        int rightMax = height[len - 1];
        int leftMax = height[0];

        int i = 1;
        int j = len-2;

        while(i <= j){

            leftMax = Math.max(leftMax , height[i]);
            rightMax = Math.max(rightMax , height[j]);

            if (leftMax <= rightMax){

                water += leftMax - height[i];
                i++;
            }

            else {
                water += rightMax - height[j];
                j--;
            }
        }

        return water;

    }
}
