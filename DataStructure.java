import java.util.*;

public class DataStructure {
	/**
	 * Create a data structure that allows the following operations.
	 * insert x y - insert an object with key x and value y.
	 * get x - return the value of an object with key x.
	 * addToKey x - add x to all keys in map.
	 * addToValue y - add y to all values in map
	 * Time complexity of each operation should be O(log(N))
	 * */
	 private TreeMap<Integer,Integer> myMap;
	 public DataStructure() {
	 	myMap = new TreeMap<>();
	 }

	 public void insert(int key,int value) {
	 	this.myMap.put(key,value);
	 }

	 public int get(int x) {
	 	return myMap.getOrDefault(x,-1);
	 }

	 public void addToKey(int x) {
	 	TreeMap<Integer,Integer> newMap = new TreeMap<>();

	 	for(int key : myMap.keySet()) {
	 		int newValue = myMap.get(key);
	 		newMap.put(key + x , newValue);
	 	}
	 	this.myMap = newMap;
	 }

	 public void addToValue(int y) {
	 	for(int key : myMap.keySet()) {
	 		int newValue = myMap.get(key);
	 		myMap.put(key,newValue);
	 	}
	 }
}