package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import MathUtil.DigitUtil;

public class P62 {

	public static void main(String[] args) {
		Map<Long, ArrayList<String>> cubes = new HashMap<Long, ArrayList<String>>();
		
		int factor = 1;
		Long cube = (long) Math.pow(factor, 3);
		Long limit = (long) 10;
		
		while(true){
			System.out.println("Computing: " + factor);
			
			cube = (long) Math.pow(factor, 3);
			
			if(cube >= limit){
				if(!checkMap(cubes)){
					cubes.clear();
					limit = limit * 10;
					continue;
				}else{
					break;
				}
			}
			
			long permutation = DigitUtil.getDigPermutation(cube);
			System.out.println("Permutation: " + permutation);
			if(cubes.containsKey(permutation)){
				cubes.get(permutation).add(cube.toString());
			}
			else{
				ArrayList<String> list = new ArrayList<String>();
				System.out.println(cube.toString());
				list.add(cube.toString());
				cubes.put(permutation, list);
			}
			
			factor ++;
		}
		
		System.out.println("FINISH......");
	}
	
	private static boolean checkMap(Map<Long, ArrayList<String>> cubes){
		for(Long key : cubes.keySet()){
			if(cubes.get(key).size()==5){
				ArrayList<String> list = cubes.get(key);
				System.out.println(String.format("Result found: %s", list.get(0)));
				return true;
			}
		}
		return false;
	}

}
