package org.lasencinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Collections.list;
import static java.util.Collections.swap;

public class ListMethods {


    public static boolean binarySearch(List<Integer> list,Integer target){

        if (list.isEmpty()) {
            return false;
        }

        Integer last = list.size()-1;
        Integer first = 0;


        while (last >= first){

            Integer center = (last+first)/2;

            if (list.get(center) == target){
                return  true;

            }else{

                if(list.get(center) > target) {
                    last = center -1;

                }else {
                    first = center +1;
                }
            }

        }
   return false; }





   public static List<Integer> bubbleSort(List<Integer> list){

        Boolean swap = true;
        Integer aux = 0;

        while(swap){

            swap = false;

            for (int index = 0;index<list.size()-1; index++){

                if(list.get(index) > list.get(index+1)){
                    aux = list.get(index);
                    list.set(index,list.get(index+1));
                    list.set(index+1,aux);
                    swap = true;

                }else {
                    continue;
                }

            }
        }
    return list;
   }


//   public static List<Integer> getPrimeNumbers(List<Integer> list){
//
//        List<Integer> primeNumbers = new ArrayList<>();
//
//
//
//   }


    public static List<Integer> Quicksort(List<Integer> list){

        Stack<Task> tasks  = new Stack<>();


        tasks.push(new Task(0,(list.size()-1)));

        while (!tasks.empty()){

           Task task = tasks.pop();

          if (task.getFirst() < task.getLast()){
              int pivot = quickSortOneStep(task,list);
              tasks.push(new Task(task.getFirst(),pivot));
              tasks.push(new Task(pivot+1,task.getLast()));
          }
        }

        return list;
    }



    private static Integer quickSortOneStep(Task task,List<Integer> subList){

        Integer pivot = subList.get(task.getFirst());
        Integer leftWall = task.getFirst();

        for(int index = task.getFirst(); index <= task.getLast(); index++){

            if(subList.get(index) < pivot){
                swap(subList,index,leftWall+1);
                leftWall++;
            }



        }
        swap(subList,subList.indexOf(pivot),leftWall);
        return leftWall;
    }


    private static void swap(List<Integer> list,Integer i, Integer j) {



        int aux = list.get(i);
        list.set(i,list.get(j));
        list.set(j,aux);

    }


}
