
package org.echocat.kata.java.part1;
import java.util.*;
class Main {

    public static String GasStation(String[] strArr) {
        // code goes here
        int index=0;
        List<Map<Integer, Integer>> pairs= new ArrayList<>();
        for (String str: strArr)
        {
            if (index!=0)
            {
                String[] split = str.split(":");
                Map<Integer,Integer> pair=new HashMap();

                pair.put(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
                pairs.add(pair);
            }
            index++;
        }

        int remain = 0;
        for(int i=1;i<strArr.length;i++)
        {
            int complete=0;
            outerloop:
            for(Map<Integer, Integer> pair :pairs)
            {
                complete++;
                if(pair.keySet().stream().findAny().get()+ remain< pair.get(pair.keySet().stream().findAny().get()))
                    break outerloop;
                else
                    remain=pair.keySet().stream().findAny().get()+ remain- pair.get(pair.keySet().stream().findAny().get());
            }
            if(complete==strArr.length-1)
                return String.valueOf(i);
            Collections.rotate(pairs,-1);
        }
        return "impossible";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String[] strings= new String[]{"4","0:1","2:2","1:2","3:1"};
        System.out.print(GasStation(strings));
    }






}