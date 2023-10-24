package LeetCode;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月17日 11:45 PM
 */
public class _84_LargestRectangleInHistogram {
    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        int[] heights2 = {2,4};
        //System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea2(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        if(heights.length==1){
            return heights[0];
        }

        int lowerLeft =-1;
        int lowerRight = -1;
        int sum = 0;
        int i=0;
        while(i<heights.length){
            lowerLeft=heights[i];
            lowerRight=heights[i];
            int leftIndex=i;
            int rightIndex=i;
            while(!(lowerLeft<heights[i]) || lowerLeft==heights[i]){
                if(leftIndex==0){
                    leftIndex-=1;
                    break;
                }
                leftIndex-=1;
                lowerLeft=heights[leftIndex];
            }
            while(!(lowerRight<heights[i]) || lowerRight==heights[i]){
                if(rightIndex==heights.length-1){
                    rightIndex+=1;
                    break;
                }
                rightIndex+=1;
                lowerRight=heights[rightIndex];
            }
//            if(rightIndex!=heights.length-1){
//                rightIndex-=1;
//                lowerRight=heights[rightIndex];
//            }
//            if(leftIndex!=0){
//                leftIndex+=1;
//                lowerLeft=heights[leftIndex];
//            }
            rightIndex-=1;
            leftIndex+=1;
            lowerLeft=heights[leftIndex];
            lowerRight=heights[rightIndex];


            int width = rightIndex-leftIndex+1;
            int high = Math.min(lowerLeft,lowerRight);
            high = Math.min(heights[i],high );
            sum = Math.max(sum,width*high);
            i++;

        }
        return sum;
    }

    public static int largestRectangleArea2(int[] heights) {
        if(heights.length==1){
            return heights[0];
        }
        int max = 0;
        //preLow and preHigh, is the memory to store the left boundary and right boundary
        //the algorithm using there is like dp
        //it store the previous lower number in the array
        // and jump to that index, to see is it less than current value
        //for example:
        //  1,4,7,6
        //current is 6, than it looking for which value is less than 7, which is 4, so it is 4;
        int[] preLow = new int[heights.length];
        int[] preHigh = new int[heights.length];
        preLow[0]=-1;
        preHigh[heights.length-1]=heights.length;
        for (int i = 1; i < heights.length; i++) {
            int left = i-1;

            // ex: -1, 2, 5, 6,2,3
            //if height[left] >= height[i]
            // then the it will looking for the previous element in preLow, util it find the smaller number
            //i=1, height[i]=1, height[left] = -1, so the preLow[i]=-1,
            //this time,it find the index that is less than the height[left], which is -1;
            //i=2, height[i]=1, height[left] = 5, so this time it not going into the while loop, so just store it to the preLow[i]
            //...
            while(left>=0 && heights[left]>=heights[i]){
                left=preLow[left];
            }
            preLow[i]=left;

        }


        for (int i = heights.length-2; i >=0; i--) {
            int right = i+1;
            while(right<heights.length && heights[right]>=heights[i]){
                right=preHigh[right];
            }
            preHigh[i] = right;

        }


        System.out.println(Arrays.toString(preLow));
        System.out.println(Arrays.toString(preHigh));

        for (int i = 0; i < heights.length; i++) {
            int width = preHigh[i]-preLow[i]-1;
            int high = Math.min(heights[preLow[i]+1],heights[preHigh[i]-1]);
            high = Math.min(high,heights[i]);
            System.out.println("width: "+width+", high: "+high);
            max = Math.max(max,width*high);
            System.out.println(max);
        }

        return max;
    }
}
