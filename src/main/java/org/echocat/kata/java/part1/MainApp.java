package org.echocat.kata.java.part1;

import business.OrchestrationService;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class MainApp {

    public static int LongestWord(int num) {
        int[] intArray = new int[]{11,9,7,5,1};

        if(num==0) return 0;
        int index=0;
        int result = 0;

        for (int i= 0 ;i<intArray.length ;i++)
        {
            if  (intArray[i]==num)
                return 1;

            result = intArray[i];
            for(int j =i  ; j< intArray.length;j++)
            {
                if(result+ intArray[j]<=num)
                {
                    result=result+intArray[j];
                    index++;
                }
                if(result==num)
                    return index+1;

            } index=0;
        }
        return index+1;
    }

    public static void main (String[] args) {
        System.out.println(LongestWord(8));
    }

    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }


    static int max(int a, int b) {
        return (a > b) ? a : b;
    }


    protected static String getHelloWorldText() throws IOException {

        OrchestrationService.INSTANCE.printAll();

        return "Hello world!";
    }

}
