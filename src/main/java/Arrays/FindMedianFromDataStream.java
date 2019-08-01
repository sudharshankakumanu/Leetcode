package Arrays;

import java.util.PriorityQueue;

//[6.0,8.0,6.0,6.0,6.0,5.5,6.0,5.5,5.0,4.0,3.0]
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(6);
        System.out.print(f.findMedian()  + ",");
        f.addNum(10);
        System.out.print(f.findMedian()+ ",");
        f.addNum(2);
        System.out.print(f.findMedian()+ ",");
        f.addNum(6);
        System.out.print(f.findMedian()+ ",");
        f.addNum(5);
        System.out.print(f.findMedian()+ ",");
        f.addNum(0);
        System.out.print(f.findMedian()+ ",");
        f.addNum(6);
        System.out.print(f.findMedian()+ ",");
        f.addNum(3);
        System.out.print(f.findMedian()+ ",");
        f.addNum(1);
        System.out.print(f.findMedian()+ ",");
        f.addNum(0);
        System.out.print(f.findMedian()+ ",");
        f.addNum(0);
        System.out.print(f.findMedian()+ ",");

    }

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    /** initialize your data structure here. */
    public FindMedianFromDataStream() {

         minHeap = new PriorityQueue();
         maxHeap = new PriorityQueue<>((a,b) -> b-a);

    }

    public void addNum(int num) {

        if(minHeap.size() == maxHeap.size()){
            if(maxHeap.size()> 0 && num < maxHeap.peek()){
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else{
                minHeap.add(num);
            }

        }


        if(minHeap.size() > maxHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {

        if(minHeap.size() == maxHeap.size())
            return (double) ( maxHeap.peek() + minHeap.peek() ) / 2 ;
        else
            return minHeap.peek();
    }
}
