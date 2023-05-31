import java.util.*;

public class FrequencyOnMaps {
	Map<Integer,Integer> myMap = new HashMap<>();

	public void insertArray(int[] arr) {
		for(int elem : arr) {
			myMap.put(elem,myMap.getOrDefault(elem,0)+1);
		}
	}

	public int getFrequencies(int numb) {
		return myMap.getOrDefault(numb,0);
	}
	public static void main(String[] args) {
		FrequencyOnMaps fm = new FrequencyOnMaps();
		fm.insertArray(new int[]{1,1,3,5,7,4,2,1,8,5,3,5,7,3,4,6});
		System.out.println("The frequency of 1 is "+fm.getFrequencies(1));
		System.out.println("The frequency of 3 is "+fm.getFrequencies(3));
		System.out.println("The frequency of 5 is "+fm.getFrequencies(5));
		System.out.println("The frequency of 7 is "+fm.getFrequencies(7));
		System.out.println("The frequency of 4 is "+fm.getFrequencies(4));
		System.out.println("The frequency of 2 is "+fm.getFrequencies(2));
		System.out.println("The frequency of 8 is "+fm.getFrequencies(8));
		System.out.println("The frequency of 6 is "+fm.getFrequencies(6));
		System.out.println("The frequency of 9 is 0 => "+fm.getFrequencies(9));
	}
}