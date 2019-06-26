package com.atlassian;

import java.util.*;
import java.util.stream.Collectors;

//Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
//iterator.next(); // return 1
//iterator.next(); // return 2
//iterator.next(); // return 3
//iterator.hasNext(); // return true
//iterator.hasNext(); // return true
//iterator.next(); // return 4
//iterator.hasNext(); // return false

public class Flatten2DVector_251 {

        int listPos = 0;
        int subListPos = 0;
        int[][] v;

        public Flatten2DVector_251(int[][] vl) {
            v = vl;
        }

        public int next() {

            int elem = v[listPos][subListPos];

            subListPos++;

            if(subListPos >= v[listPos].length ) {
                subListPos = 0;
                listPos++;
            }

            System.out.println(elem);

            return elem;

        }

        public boolean hasNext() {
            if(v == null || v.length < 1) return false;

            if(v[listPos] == null || v[listPos].length < 1){
                listPos++;
                return true;
            }

            if( listPos < v.length && subListPos < v[listPos].length){
                System.out.println(true);
                return true;
            }
            System.out.println(false);
            return false;
        }
}
