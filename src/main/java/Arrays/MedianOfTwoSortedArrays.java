package Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args){

        int[] nums1 = {1};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1,nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        return findMedianSortedArraysHelper(nums1, 0 , len1 -1 , nums2 , 0, len2 - 1);
    }

    public static double findMedianSortedArraysHelper (int[] nums1, int start1, int end1, int[] nums2, int start2, int end2){

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        double median1 = getMedian(nums1, start1, end1);
        double median2 = getMedian(nums2, start2, end2);

//        if(len1 == 1 && len2 == 1)
//        {
//            return 1.0*(nums1[start1]+nums2[start2])/2;
//        }

        if ((end1 - start1 == 0) && ((end2 - start2 == 0)))
        {
            return (nums1[start1] + nums2[start2])/2;
        }

        if ((end1 - start1 == 1) && ((end2 - start2 == 1)))
        {
            return (1.0*(Math.max(nums1[start1], nums2[start2]) + Math.min(nums1[end1], nums2[end2])))/2;
        }

        if(median1 == median2) return median1;

        if(median1 < median2) {

            int newStart1;
            int newEnd2;

            if(len1 % 2 == 1) {

                newStart1 = (end1 + start1) /2;
                newEnd2 = (end2 + start2) /2;

            } else {

                newStart1 = (end1 + start1) /2 + 1;
                newEnd2 = (end2 + start2) /2;
            }

            return findMedianSortedArraysHelper(nums1, newStart1, end1 , nums2, start2, newEnd2);
        }

        else {

            int newEnd1;
            int newStart2;

            if(len1 % 2 == 1) {

                newEnd1 = (end1 + start1) /2;

            } else {

                newEnd1 = (end1 + start1) /2 + 1;
            }

            if(len2 % 2 == 1) {

                newStart2 = (end2 + start2) /2;

            } else {

                newStart2 = (end2 + start2) /2;
            }

            return findMedianSortedArraysHelper(nums1, start1, newEnd1 , nums2, newStart2, end2);
        }
    }

    public static double getMedian(int[] num , int start, int end) {

        if(end == start) return num[end];

        if((end + start) % 2 == 0) return 1.0*num[(end + start)/2];

        else {

            int x = num[(end + start)/2 + 1];
            int y = num[(end+start)/2];

            return 1.0*(x+ y) /2 ;
        }
    }
}
