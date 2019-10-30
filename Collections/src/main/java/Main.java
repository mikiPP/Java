import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[]args){

        List<Integer> integerList = new ArrayList<Integer>();


        for(int i = 0;i < 100;i++){
            integerList.add(i);
         }
//
//        for(int i = 0 ; i < integerList.size();i++){
//            System.out.println(integerList.get(i)+ " ");
//
//        }
//
//        for(int i = 0 ; i < integerList.size();i++){
//            int numeroAleatorio = (int) (Math.random() * integerList.size() - 1);
//            System.out.println(integerList.get(numeroAleatorio)+ " ");
//
//        }
//
//        List<Integer> numerospares  =
//                integerList.stream().filter(e -> e.intValue() % 2 == 1 )
//                .collect(Collectors.toList());




//         Long count =  integerList.stream()
//                .filter(integer -> integer % 2 == 0)
//                .count();
//
//        System.out.println(count);
//
//
//
//        integerList.forEach(System.out::println);


//        integerList.stream()
//                .map(String::valueOf)
//                .map(String::toString)
//                .forEach(System.out::println);
// calls to string by function reference and implicitly set the params


//        System.out.println(
//                integerList.stream()
//                .reduce(0, Integer::sum));
//
//
//
//       System.out.println(
//               integerList.stream()
//               .map(String::valueOf)
//               .reduce("", String::concat));
//
//
//       System.out.println(
//       integerList.stream()
//               .filter(integer -> integer % 2 == 0)
//               .map(integer -> integer * 2)
//               .reduce(0,Integer::sum));
//         this method returns the sum of all the list
//
//
//        //EQUAL THAT THE TOP ONE
//
//       System.out.println(
//                integerList.stream()
//                        .filter(integer -> integer % 2 == 0)
//                        .mapToInt(integer -> integer * 2)
//                        .sum());

        // this method returns the sum of all the list





//        System.out.println(
//                integerList.stream()
//                        .filter(integer -> integer % 2 == 0)
//                        .mapToInt(Main::compute)
//                        .sum());

        System.out.println(
                integerList.parallelStream()
                        .filter(integer -> integer % 2 == 0)
                        .mapToInt(Main::compute)
                        .sum());


        //double the even values and put that into a list

            List<Integer> numbers = Arrays.asList(1,2,3,4,5, 1,2,3,4,5);

            List<Integer> doubleOfEven = numbers.stream()
                      .filter(e -> e % 2 == 0)
                      .map(e -> e* 2)
                      .collect(  toList());

            System.out.println(doubleOfEven);


         //infinite streams

        Stream.iterate(100, e-> e+1); //if we print this will get the memory pointer

        //starts with 100, then create a  series
        //100,101,102,103 ...

        // infinite streams example to work with




        /**
         * Use parallel stream when:
         *  a) makes sense to use it and you can use it
         *  b) to get the answer faster
         *  c) When the data-size is big enough and u will get a benefit on performance
         *  d) When the task computation is big enough and u will get a benefit on performance
         *
         *  Will be faster if we use parallel Stream but will be a bigger cost in resources
         */


        /**
         *  .map Transforms values
         *  number of output == number of input
         *  no guarantee on the type of the output whit respect to the input type
         *  paramater: Stream<T> map takes Function<T,R> to return Stream <R>
         *
         * */

        /**
         * .reduce has an initial value like 0 or "" that is the first element
         *
         * and then produce a result from any computation operation and then,save that value.
         *
         * The next iteration will get the value from the first iteration and then produce another result from
         * any computation operation.
         * parameter: will take the initial value and the computer operation (function)
         *
         * reduce can return only one value or  can return a collection
         * */


            numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .map(e -> e *2);


        /**
         *  Lazy evaluation, if the stream dont return one element or more than one then, the stream will
         *  do nothing. And streams are working for each element goes to top from bottom and then get next element
        * */

        /**
         * lazy evaluation is only if the functions don't have side effects (like print things)
         */



        /**
         * We should not use streams if we want to change the data
         *
         * reference from : https://www.youtube.com/watch?v=1OpAgZvYXLQ
         */

    }


    public static int compute(int k, int n){

        //Given a number k,and a count n, finde the double of n even numbers  starting with k,
        // where sqrt of each number is > 20

        return Stream.iterate(k, e -> e+1)  // unbounded,lazy
                .filter(e-> e % 2 ==0)  // unbounded,lazy
                .filter(e ->Math.sqrt(e) > 20)  // unbounded,lazy
                .mapToInt(e -> e* 2) // unbounded,lazy
                .limit(n) // sized,lazy
                .sum();  // triggers the evaluation without that nothing will work (like all the terminal functions)

    }




    public static int compute(int number) {
        return number * 2;
    }
}
