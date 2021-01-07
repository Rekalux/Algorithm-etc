package Day1024;

import java.util.Scanner;

public class Boj_1991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tree[] t = new tree[n];
		char temp;
		for (int j = 0; j < n; j++) {
			int i = sc.next().charAt(0)-'A';
			t[i] = new tree();
			temp = sc.next().charAt(0);
			if (temp == '.') {
			} else {
				t[i].left = (temp - 'A');
			}
			temp = sc.next().charAt(0);
			if (temp == '.') {
			} else {
				t[i].right = (temp - 'A');
			}
		}
		preorder(0, t);
		System.out.println();
		inorder(0, t);
		System.out.println();
		postorder(0, t);
	}

	static void preorder(int node, tree[] t) {
		if (node == -1) {
			return;
		}
		System.out.print((char) (node + 'A'));
		preorder(t[node].left, t);
		preorder(t[node].right, t);
	}

	static void inorder(int node, tree[] t) {
		if (node == -1) {
			return;
		}
		inorder(t[node].left, t);
		System.out.print((char) (node + 'A'));
		inorder(t[node].right, t);
	}

	static void postorder(int node, tree[] t) {
		if (node == -1) {
			return;
		}
		postorder(t[node].left, t);
		postorder(t[node].right, t);
		System.out.print((char) (node + 'A'));
	}

}

class tree {
	int left = -1;
	int right = -1;
}