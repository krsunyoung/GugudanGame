package com.bit2016.gugudangame.test;

import java.util.HashSet;
import java.util.Set;


//Shift + alt + f10

public class SetTest {
    public static void main(String[] args){
        /*for(int i=0;i<10;i++) {
            System.out.println(randomize(1, 9)); //sout
        }*/

        Set<Multiplication> set = new HashSet<Multiplication>();
        while(set.size() !=9){
            int left = randomize(1,9);
            int right=randomize(1,9);
            set.add(new Multiplication(left, right));
        }
        int indexRandom =randomize(0,8);
        int index = 0;
        for(Multiplication mul: set){
            if(index == indexRandom){
                System.out.println("=========");
            }else {
                System.out.println(mul);
            }
        }

    }
    private static int randomize(int from, int to){
        return (int)(Math.random() * to)+from;
    }
    //hashSet
    private static class Multiplication{
        private int left;
        private int right;

        public Multiplication(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Multiplication{" +
                    "left=" + left +
                    ", right=" + right +
                    ", product="+right*left+
                    '}';
        }

        //code ->generate
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Multiplication that = (Multiplication) o;

            return right*left == that.right*that.left;

        }

        @Override
        public int hashCode() {

            return 31 * left + right;
        }
    }


}
