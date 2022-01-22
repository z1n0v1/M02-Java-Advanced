package L08IteratorsAndComparators.Exercise.T04Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] lake;
    private int size;

    public Lake(int[] lake) {
        this.lake = lake;
        this.size = lake.length;
    }

    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {

        int place1 = 0;
        int place2 = 1;

        @Override
        public boolean hasNext() {
            if (size == 1 && place1 == 0)
                return true;
            if (size % 2 == 0 && place2 <= size)
                return true;
            if (size % 2 == 1 && place2 < size)
                return true;
            return false;

//            if (place1 + place2 == size)
//                return false;
//            return true;
        }

        @Override
        public Integer next() {
//            int index = 0;
//            if (place < size / 2)
//                return lake[place++*2];
//            else {
//                int cnt = place - size/2 ;
//                place++;
////                if((cnt )*2 + 1 == size)
//
//                return lake[(cnt )*2 + 1];
//                return lake[(place - size / 2)];
//            }


            //            if(place < size / 2)
//                return lake[place++ * 2 + 1];
//            return lake[((place++ - size / 2+1) )*2];


//        }
//            if(size == 1) {
//                return lake[0];
//            } else
                if (place1 < size) {
                int cur = place1;
                place1 += 2;
                return lake[cur];
            } else {
                int cur = place2;
                place2 +=2;
                return lake[cur];
            }

        }
    }
}
