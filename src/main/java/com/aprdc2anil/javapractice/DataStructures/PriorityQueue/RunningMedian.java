package com.aprdc2anil.javapractice.DataStructures.PriorityQueue;

import java.util.*;

// netflix
public class RunningMedian {
    private static PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>((a,b) -> a-b);
    private static PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>((a,b) -> b-a);

    private static void insert(int num)
    {
        if(maxPQ.isEmpty() || num<maxPQ.peek())
        {
            maxPQ.add(num);
        } else
        {
            minPQ.add(num);
        }

        resize();
    }

    private static void resize() {
        if(maxPQ.size() > minPQ.size() + 1)
        {
            minPQ.add(maxPQ.poll());
        }
        else if(minPQ.size() > maxPQ.size())
        {
            maxPQ.add(minPQ.poll());
        }
    }

    private static double getMedian()
    {
        if(maxPQ.isEmpty())
            return 0;

        if(maxPQ.size() == minPQ.size())
        {
            return (maxPQ.peek() + minPQ.peek())/2.0;
        } else  return maxPQ.peek();
    }

    public static void mainMethod() {
        // Driver code

       int[] array = {23, 43, 54, 11, 21, 67, 32, 82, 46, 36};
       for(int x: array)
       {
           insert(x);
           System.out.println(getMedian());
       }
    }
}
