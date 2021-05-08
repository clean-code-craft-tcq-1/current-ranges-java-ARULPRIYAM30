package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CurrentBatteryReading {

	 public static HashMap<String, Integer> checkCurrentRangeAndsamples(List<Integer> samples) {
		 if(samples.contains(null) ||samples.isEmpty()) {
				return null;
			}
			HashMap<String,Integer> samplesCurrent = new HashMap<String,Integer>();
			Collections.sort(samples);
			int count = 1;
			int	minRange = samples.get(0);
			int maxRange = samples.get(0);
			
			for (int i = 1; i < samples.size(); ++i) {
				 if ((samples.get(i) - samples.get(i-1)) < 2) {		        
				        ++count;
				      }
				      
				      else {		   
				    	  samplesCurrent.put(minRange+ "-"+maxRange, count);
				    	minRange = maxRange = samples.get(i);
				        count = 1;  
		        
				      }
			      maxRange = samples.get(i);
			    }
		    	samplesCurrent.put(minRange+ "-"+maxRange, count);
			return samplesCurrent;
		}

		}

