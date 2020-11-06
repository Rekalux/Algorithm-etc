package Day1106;

import java.util.Scanner;
import java.util.Stack;

public class Boj_1918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> stack = new Stack<Character>();
		stack.add('(');
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<i+3;j++) {
				if(j>=s.length()) {
					break;
				}
				if(j==i+1 && (s.charAt(j) == '*' || s.charAt(j)=='/')) {
					// 중앙이 *이나 /이면
					Stack<Character> ls = new Stack<Character>();
					Stack<Character> rs = new Stack<Character>();
					int front = j;
					while(true) {
						front--; // 줄여가며
						if(s.charAt(front)==')') {
							ls.add(')');
						}
						if(ls.size()==0) {
							break;
						}
						if(s.charAt(front)=='(') {
							ls.pop();
						}
						if(ls.size()==0) {
							break;
						}
					}
					int end = j;
					while(true) {
						end++; // 줄여가며
						if(s.charAt(end)=='(') {
							rs.add('(');
						}
						if(rs.size()==0) {
							break;
						}
						if(s.charAt(end)==')') {
							rs.pop();
						}
						if(rs.size()==0) {
							break;
						}
					}
					String news = s.substring(0,front)+"("+s.substring(front,end+1)+")"+s.substring(end+1,s.length());
					s = news;
					i += 2; // 괄호가 2개 더 들어갔으므로 2칸 길어짐
				}
			}
		}
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
				System.out.print(s.charAt(i));
				while(!stack.isEmpty() && stack.peek() != '(') {
					System.out.print(stack.pop());
				}
			}
			else if(s.charAt(i)==')') {
				stack.pop();
				while(!stack.isEmpty() && stack.peek() != '(') {
					System.out.print(stack.pop());
				}
			}
			else {
				stack.add(s.charAt(i));
			}
		}
	}
}
