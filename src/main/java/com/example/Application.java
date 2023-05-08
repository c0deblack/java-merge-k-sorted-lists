package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * Mergek Sorted Lists
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output:[1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example2:
 * Input: lists= []
 * Output: []
 *
 * Example3:
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 *
 *
 *
 * k == lists.length
 *
 * 0 <= k <= 104
 *
 * 0 <= lists[i].length <= 500
 *
 * -104 <= lists[i][j] <= 104
 *
 * lists[i] is sorted in ascending order.
 *
 * The sum of lists[i].length will not exceed 104.
 * </pre>
 */
public class Application {
    public static void main(String[] args){
        println("Enter any number of rows of numbers");

        println("Each row represents a linked list, where numbers are linked in sequence");

        println("Press CTRL+D, or enter 'exit' when you are complete: ");

        List<List<Integer>> input = getInput();

        println(mergeKSortedLists(input));
    }

    public static void println(Object ...o){
        for(var q: o){
            System.out.print(q);
        }
        System.out.println();
    }

    private static List<Integer> mergeKSortedLists(List<List<Integer>> input){
        // combine arrays into one array

        // use selection sort to sort the nodes of the list

        List<Integer> output = new ArrayList<>();

        for(var list : input) {
            output.addAll(list);
        }

        for(int x = 0; x < output.size() - 1; x++){

            int lowestIndex = x;

            for (int y = x + 1; y < output.size(); y ++){
                Integer current = output.get(lowestIndex);
                Integer next = output.get(y);

                if (next < current){
                    lowestIndex = y;
                }
            }

            Integer temp = output.get(x);
            output.set(x, output.get(lowestIndex));
            output.set(lowestIndex, temp);
        }
        return output;
    }

    public static List<List<Integer>> getInput(){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> outputList = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.equals("exit")) break;

            int[] inputList = Stream.of(line.split(" ")).mapToInt(Integer::valueOf).toArray();

            List<Integer> list = new ArrayList<>();

            for (var i : inputList){
                list.add(i);
            }
            outputList.add(list);
        }

        return outputList;
    }
}
