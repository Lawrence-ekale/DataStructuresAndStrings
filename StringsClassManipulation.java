import java.util.*;

public class StringsClassManipulation{
	public String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);

		return sb.reverse().toString();
	}

	public Boolean isEmpty(String str) {
		return str.length() == 0 ? true : false;
	}

	public Boolean ifContainSubstring(String fullString, String substr) {
		return fullString.contains(substr);
	}

	public Integer stringLength(String str) {
		return str.length();
	}

	public Boolean isEquals(String first, String second) {
		return first.equals(second);
	}

	public int[] returnNewArray(int[] a) {
		/**
		 * Given an array of integers a,
		 * Return another array b,
		 * where b[i] = a[i-1] + a[i] + a[i+1]
		 * if element does not exist it should be 0
		 * */
		 int[] b = new int[a.length];
		 for(int i = 0; i < a.length; i++) {
		 	int first = i-1 >= 0 ?  i-1 : i;
		 	int second = i+1 <= a.length-1 ? a.length-1 : i;

		 	if(first == i) {
		 		b[i] = a[i] + a[i+1];
		 	}else if(second == i) {
		 		b[i] = a[i-1] + a[i];
		 	}else
		 		b[i] = a[i-1] + a[i] + a[i+1]; 
		 }

		 return b;
	}

	/**
	 * Given a list of words(consists of lowercase english letters)
	 * and a complex WORD in camelCase(consisting of English letters),
	 * Check if the complex WORD consists of words from the given list.
	 * 
	 * */
	 public Boolean checkComplexWord(ArrayList<String> words, String complexWord) {
	 	complexWord = complexWord.toLowerCase();
	 	for(String word: words) {
	 		if(complexWord.contains(word))
	 			return true;
	 	}
	 	return false;
	 }

	 public void getSplittedStrings() {
	 	String sent = "Hello, world! This is a sample sentence.";
	 	String[] words = sent.split(" ");

	 	for(String word : words) {
	 		System.out.println("To lower case is => " + word.toLowerCase());
	 		System.out.println("To upper case is => " + word.toUpperCase());
	 		System.out.println("Word length is => " + word.length());
	 		System.out.println("Replaced letters 'e' to 'o' " + word.replace('e','o'));
	 		System.out.println("The word starts with => '" + word.charAt(0) + "' and ends + '" + word.charAt(word.length() -1 ) + "'");
	 	} 
	 }

	 public void appendArrays() {
	 	int[] array1 = {1, 2, 3};
		int[] array2 = {4, 5, 6};

		int[] result = new int[array1.length + array2.length];
		System.arraycopy(array1,0,result,0,array1.length);
		System.arraycopy(array2,0,result,array1.length,array2.length);

		StringBuilder sb = new StringBuilder();
		for (int numb : result)
			sb.append(numb + " ,");

		System.out.println(sb.toString().substring(0,sb.length()-1));
	 }

	 public void capitalizeStart() {
	 	String str = "hello world, how is the place you are?";
	 	String[] words = str.split(" ");

	 	StringBuilder sb = new StringBuilder();

	 	for (String word: words) {
	 		sb.append(word.substring(0,1).toUpperCase() + word.substring(1) + " ");
	 	}

	 	System.out.println(sb);
	 }

	 public Boolean checkIfBracketsUsedCorrectly(String str) {
	 	Stack<Character> st = new Stack<>();

	 	for (char c : str.toCharArray()) {
	 		if (c == '(' || c == '{' || c == '[' || c == '"') {
	 			st.push(c);
	 		} else if(c == ')' || c == '}' || c == ']') {
	 			if(st.isEmpty() || !isMatchingPair(st.pop(),c)) {
	 				return false;
	 			}
	 		} else if(c == '"') {
	 			if(st.isEmpty() && st.peek() == '"')
	 				st.pop();
	 			else
	 				st.push(c);
	 		}
	 	}

	 	return st.isEmpty();
	 }

	 public Boolean isMatchingPair(char opening, char closing) {
	 	return 	opening == '(' && closing == ')' ||
	 			opening == '{' && closing == '}' ||
	 			opening == '[' && closing == ']';
	 }

	 public Boolean checkAnagrams(String s1,String s2) {
	 	s1 = s1.toLowerCase().replaceAll("\\s","");
	 	s2 = s2.toLowerCase().replaceAll("\\s","");
	 	if(s1.length() != s2.length())
	 		return false;

	 	Map<Character,Integer> letterCounts = new HashMap<>();
	 	Map<Character,Integer> letterCounts1 = new HashMap<>();


	 	for(char c : s1.toCharArray()) {
	 		if(Character.isLetter(c))
	 			letterCounts.put(c,letterCounts.getOrDefault(c,0) + 1);
	 	}

	 	for(char c : s2.toCharArray()) {
	 		if(Character.isLetter(c))
	 			letterCounts1.put(c,letterCounts1.getOrDefault(c,0) + 1);
	 	}

	 	return letterCounts.equals(letterCounts1);
	 }

	 public Boolean checkAnagramsEfficiently(String s1, String s2) {
	 	s1 = s1.toLowerCase().replaceAll("\\s","");
	 	s2 = s2.toLowerCase().replaceAll("\\s","");
	 	if(s1.length() != s2.length())
	 		return false;
	 	char[] s1Chars = s1.toCharArray();
	 	char[] s2Chars = s2.toCharArray();

	 	Arrays.sort(s1Chars);
	 	Arrays.sort(s2Chars);

	 	return Arrays.equals(s1Chars,s2Chars);
	 }

	 public String getLongestCommonPrefix(String[] strs) {
	 	if(strs == null || strs.length ==0)
	 		return "";
	 	String prefix = strs[0];

	 	for(int i = 1; i < strs.length; i++) {
	 		while(!strs[i].startsWith(prefix)) {
	 			prefix = prefix.substring(0,prefix.length()-1);
	 			if(prefix.isEmpty())
	 				return "";
	 		}
	 	}

	 	return prefix;
	 }

	 public int removingDuplicates(int[] arr) {//removing duplicates in a sorted array
	 	if(arr == null || arr.length == 0)
	 		return 0;
	 	int uniqueElements = 1;
	 	for(int i = 1; i < arr.length; i++) {
	 		if(arr[i-1] != arr[i]) {
	 			arr[uniqueElements] = arr[i];
	 			uniqueElements++;
	 		}
	 	}

	 	for (int i = 0; i < arr.length; i++)
	 		System.out.println(arr[i]);
	 	
	 	return uniqueElements;
	 }

	public static void main(String[] args) {
		StringsClassManipulation obj = new StringsClassManipulation();
		System.out.println(obj.reverseString("Hello"));
		System.out.println("This should be 'true' => "+obj.isEmpty(""));
		System.out.println("This should be 'false' => "+obj.isEmpty("Hello"));
		System.out.println("This should be '5' => "+obj.stringLength("Hello"));
		System.out.println("This should be 'true' => "+obj.isEquals("Hello","Hello"));
		System.out.println("This should be 'false' => "+obj.isEquals("Hello","Helli"));
		System.out.println("This should be 'false' => "+obj.isEquals("Hello","hello") + "\n\n\n");
		//For others
		System.out.println("This should be 'false' => "+obj.ifContainSubstring("I miss you","Hello"));
		System.out.println("This should be 'true' => "+obj.ifContainSubstring("I miss you","you") + "\n\n\n");

		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("world");
		words.add("how");
		words.add("are");
		words.add("you");
		System.out.println("This should be 'false' => "+obj.checkComplexWord(words,"HiwAriYoi"));
		System.out.println("This should be 'true' => "+obj.checkComplexWord(words,"HowAreYou"));
		System.out.println("This should be 'true' => "+obj.checkComplexWord(words,"HoiwAreYou"));

		obj.getSplittedStrings();

		obj.appendArrays();

		obj.capitalizeStart();

		System.out.println("\n\n\n\n"+obj.checkIfBracketsUsedCorrectly("(([{Hello}]))"));

		//int[] array1 = {1, 2, 3};
		int[] arra = {1, 2,4,6,8,10};
		int[] b = obj.returnNewArray(arra);
		for (int a : b)
			System.out.print(a + ", ");

		System.out.println("\n\n\n\nThis should be 'true' => " + obj.checkAnagrams("listen","silent"));
		System.out.println("This should be 'false' => " + obj.checkAnagrams("listen","silenti"));
		System.out.println("This should be 'true' => " + obj.checkAnagrams("heart","earth"));
		System.out.println("This should be 'true' => " + obj.checkAnagrams("debit card","bad credit"));
		System.out.println("This should be 'true' => " + obj.checkAnagrams("astronomer","moon starer"));
		System.out.println("This should be 'true' => " + obj.checkAnagrams("schoolmaster","the classroom"));

		System.out.println("\n\n\n\nThis should be 'true' => " + obj.checkAnagramsEfficiently("listen","silent"));
		System.out.println("This should be 'false' => " + obj.checkAnagramsEfficiently("listen","silenti"));
		System.out.println("This should be 'true' => " + obj.checkAnagramsEfficiently("heart","earth"));
		System.out.println("This should be 'true' => " + obj.checkAnagramsEfficiently("debit card","bad credit"));
		System.out.println("This should be 'true' => " + obj.checkAnagramsEfficiently("astronomer","moon starer"));
		System.out.println("This should be 'true' => " + obj.checkAnagramsEfficiently("schoolmaster","the classroom"));//check spaces

		String[] strings = { "hello", "help", "heir", "hey" };
		System.out.println("\n\n\n\nThe longest common prefix is => " + obj.getLongestCommonPrefix(strings));

		int[] arr = {1,2,3,4,5,6,6,7,8,9,10,10,10,11,12,13};
		System.out.println("\n\n\n\n"+obj.removingDuplicates(arr));

		String mainString = "percolateDown";

		String[] words1 = mainString.split("(?=[A-Z])");


		System.out.println(String.join(" ",words1));
	}
}