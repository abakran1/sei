package com.sei.assignments.util;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;


/**
 * Utility class to remove duplicate values for any given integer array
 * 
 * @author ahmedbakran
 */
public class DeDup {
	
	private static final Logger logger = Logger.getLogger(DeDup.class);

	/**
	 * Remove and all duplicates from array input, 
	 * @param numbers array you wish to remove duplicates
	 * @return an array in the original order.
	 */
	public static int[] removeDuplicatesOriginalOrder(int[] numbers) {
	    if (numbers.length <= 1) {
	        return numbers;
	    }
		Set<Integer> tmpSet = new LinkedHashSet<Integer>();
		logger.debug("Before array size: "+numbers.length);
		for (int i = 0; i < numbers.length; i++) {
			tmpSet.add(numbers[i]);
		}
		
		Integer[] array = new Integer[tmpSet.size()];
		tmpSet.toArray(array);

		logger.debug("After array size: "+array.length);
		return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
	}
	
	/**
	 * remove duplicates from array, first by sorting, then by comparing adjacent elements.
	 * @param numbers array you wish to remove duplicates 
	 * @return an array without duplicates of original array
	 */
	public static int[] removeDuplicates(int[] numbers) {
		if (numbers.length <= 1) {
	        return numbers;
	    }
	    logger.debug("Original array:" + numbers.length);

        Arrays.sort(numbers);     
      
        int[] result = new int[numbers.length];
        int previous = numbers[0];
        result[0] = previous;

        for (int i = 1; i < numbers.length; i++) {
            int item = numbers[i];

            if (previous != item)
                result[i] = item;
            previous = item;
        }

	    logger.debug("New Array size: " + numbers.length);
		
	    return numbers;

	}
	
	/**
	 * removes duplicates from array, simple 
	 * @param numbers
	 * @return
	 */
	public static int[] removeDuplicatesOriginalOrderFast(int[] numbers) {
		if (numbers.length <= 1) {
	        return numbers;
	    }
		return Arrays.stream(numbers).distinct().toArray();
	}
	
	/**
	 * checks to see if array has any duplicates
	 * @param numbers
	 * @return boolean if array has any duplicate values
	 */
    public static boolean hasDuplicates(int[] numbers) {

		for (Integer i : numbers) {
		    for (int x = i + 1; x < numbers.length; x++) {
				if (numbers[i] == numbers[x]) {
				    return true;
				}
		    }
		}
		return false;
    }


}
