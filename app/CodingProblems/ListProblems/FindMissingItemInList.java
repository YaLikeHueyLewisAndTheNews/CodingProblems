package app.CodingProblems.ListProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMissingItemInList{

    public static void main(String[] args){

        ArrayList<String> firstList = new ArrayList<String>(Arrays.asList("4","12","9","5","6"));
        ArrayList<String> secondList = new ArrayList<String>(Arrays.asList("4","12","9","6"));
        System.out.println(determineMissingItemsXOR(firstList, secondList));

    }

    public static ArrayList<String> determineMissingItems(ArrayList<String> x, ArrayList<String> y){
        ArrayList<String> combined = new ArrayList<String>();
        ArrayList<String> missingItems = new ArrayList<String>();
        combined.addAll(x);
        combined.addAll(y);

        for(String item : combined){
            if(!(x.contains(item) && y.contains(item))){
                System.out.println(item);
                missingItems.add(item);
            }
        }
        return missingItems;
    }

    public static Integer determineMissingItemsXOR(ArrayList<String> x, ArrayList<String> y){

        Integer sum = 0;

        for(String item : x){
            sum ^= Integer.valueOf(item);
        }

        for(String item : y){
            sum ^= Integer.valueOf(item);
        }

        return sum;
    }


}