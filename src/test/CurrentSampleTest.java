package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.CurrentBatteryReading;

public class CurrentSampleTest {
	CurrentBatteryReading sampleReaading;
	List<Integer> readings;
		
	@Test
	public void givenSample_whenEmpty_thenReturnNull() {
		readings = new ArrayList<Integer>();
		assertNull(sampleReaading.checkCurrentRangeAndsamples(readings));
	}
	
	@Test
	public void givenSamples_whenContainsNull_thenReturnNull() {
		readings = new ArrayList<Integer>(Arrays.asList(1,3,2,1,7,6,8,null));
		assertNull(sampleReaading.checkCurrentRangeAndsamples(readings));
	}

	@Test
	public void givenSamples_whenContainsValues_thenReturnRangeAndCount() {
		HashMap<String,Integer> sampleRange = new HashMap<String,Integer>();
		sampleRange.put("1-3", 6);
		sampleRange.put("6-8", 3);
		readings = new ArrayList<Integer>(Arrays.asList(1,3,2,2,3,1,7,6,8));		
		assertEquals(sampleRange, sampleReaading.checkCurrentRangeAndsamples(readings));
	}
	
}
