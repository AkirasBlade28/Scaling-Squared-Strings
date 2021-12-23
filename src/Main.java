import java.util.ArrayList;
import java.util.List;
/*<Taken From codewars.com>
 * You are given a string of n lines, each substring being n characters long. For example:

s = "abcd\nefgh\nijkl\nmnop"

We will study the "horizontal" and the "vertical" scaling of this square of strings.

A k-horizontal scaling of a string consists of replicating k times each character of the string (except '\n').

    Example: 2-horizontal scaling of s: => "aabbccdd\neeffgghh\niijjkkll\nmmnnoopp"

A v-vertical scaling of a string consists of replicating v times each part of the squared string.

    Example: 2-vertical scaling of s: => "abcd\nabcd\nefgh\nefgh\nijkl\nijkl\nmnop\nmnop"

Function scale(strng, k, v) will perform a k-horizontal scaling and a v-vertical scaling.

Example: a = "abcd\nefgh\nijkl\nmnop"
scale(a, 2, 3) --> "aabbccdd\naabbccdd\naabbccdd\neeffgghh\neeffgghh\neeffgghh\niijjkkll\niijjkkll\niijjkkll\nmmnnoopp\nmmnnoopp\nmmnnoopp"

Printed:

abcd   ----->   aabbccdd
efgh            aabbccdd
ijkl            aabbccdd
mnop            eeffgghh
                eeffgghh
                eeffgghh
                iijjkkll
                iijjkkll
                iijjkkll
                mmnnoopp
                mmnnoopp
                mmnnoopp

 * 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String t = "abcd\nefgh\nijkl\nmnop";
		 System.out.println(scale (t,10, 8));
	}
	 public static String scale(String strng, int k, int v) {
	     // your code
		 List <String> list = getListOfStrings(strng);  
		 String s = "";
		 String element = "";
		 int count1 = 0;
		 int count2 = 0;
		 
		 for(int i=0; i<list.size();++i){
			 element = list.get(i);
			 while(count2 < v ) {
			 for(int r=0; r<element.length(); ++r) {
				
				 while(count1 < k ){
					 s += element.charAt(r);
					 ++count1;
				 }
				 count1= 0;
				 }
			 ++count2;
			 }
			 count2 = 0;	 
		 }
		 String str = s.trim().replaceAll("[\n]{2,}", "\n");
		 return str;
	 }
	private static List<String> getListOfStrings(String strng) {
		strng += "\n"+" ";
		 List<String> list = new ArrayList<>();
		 String subStr = "";
		 for(int i=0; i<strng.length(); ++i) {;
			 if(subStr.endsWith("\n")) {
				 list.add(subStr);
				 subStr = ""; //reset
			 }
			 subStr = subStr + strng.charAt(i); 
		 }
	return list;
	}
}
