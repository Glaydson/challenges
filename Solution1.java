import java.util.*;
import java.util.stream.Collectors;

import com.sun.source.tree.IfTree;

// sort the list of numbers ascending
// get only the positive and distinct numbers
// iterate and find the first missing positive number

class Solution1 {
    public int firstMissingPositive(int[] nums) {

      // sort the list of numbers ascending
      List<Integer> listNumbers  = Arrays.stream( nums ).boxed().collect(                  Collectors.toList());
      Collections.sort(listNumbers);


      List<Integer> positiveNumbers = listNumbers.stream().distinct().filter( n -> n > 0                 ).collect( Collectors.toList());

      if (positiveNumbers.size() == 0) {
        return 1;
      }

      int currentNumber = 1;

      for (int i = 0; i < positiveNumbers.size(); i++) {
        if (positiveNumbers.get(i) != currentNumber) {
          return currentNumber;
        }
        currentNumber = positiveNumbers.get(i) + 1;  
      }
    
      return currentNumber;
    }
}
