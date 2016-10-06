package common.sei.assignment.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sei.assignments.util.DeDup;

/**
 * Unit tests for dedup class
 * @author ahmedbakran
 *
 */
public class DeDupTest {

	private static final Logger logger = Logger.getLogger(DeDupTest.class);
	
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34,
			86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15,
			6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17,
			16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17,
			10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };
	
	@Test
	public void testRemoveDuplicatesOriginalOrder() {
		int [] response = DeDup.removeDuplicatesOriginalOrder(randomIntegers.clone());
		assertNotNull(response);
		assertArrayEquals(response,new int[]{1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7});
	}

	@Test
	public void testRemoveDuplicates() {
		int [] response = DeDup.removeDuplicates(randomIntegers.clone());
		assertNotNull(response);
		assertArrayEquals(response,new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,25,26,34,43,45,85,86,10000});
	}
	
	@Test
	public void testIsDuplicatesRemoveDuplicates() {
		boolean response = DeDup.hasDuplicates(randomIntegers.clone());
		assertTrue(response);
	}
	
	@Test
	public void testIsDuplicatesJava8() {
		int [] response = DeDup.removeDuplicatesOriginalOrderFast(randomIntegers.clone());
		assertNotNull(response);
		assertArrayEquals(response,new int[]{1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7});
	}
	
	@Test
	public void testTimer() {
		int a[] = new int[50000];

	    Random random = new Random();
	    for (int i = 0; i < 50000; i++) {
	        a[i] = random.nextInt(5000);
	    }
	    for(int k=0;k<100;k++) {
		    long start = System.nanoTime();
		    DeDup.removeDuplicatesOriginalOrder(a.clone());
		    long time = System.nanoTime() - start;
		    System.out.printf("removeDuplicatesOriginalOrder took %.1f ms%n", time / 1e6);
		    
		    start = System.nanoTime();
		    DeDup.removeDuplicates(a.clone());
		    time = System.nanoTime() - start;
		    System.out.printf("removeDuplicates took %.1f ms%n", time / 1e6);
		    
		    start = System.nanoTime();
		    DeDup.removeDuplicatesOriginalOrderFast(a.clone());
		    time = System.nanoTime() - start;
		    System.out.printf("removeDuplicatesOriginalOrderFast took %.1f ms%n", time / 1e6);
	    }
	}
	
}
