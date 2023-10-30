package BOJ_5639_이진검색트리;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static class Node {
		int data; // 값
		Node left; // 왼쪽 자식 노드
		Node right; // 오른쪽 자식 노드

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class Tree {
		Node node;

		// 기본 생성자
		public Tree() {
		}

		// 값을 트리에 넣어보자
		public void insert(int n) {
			node = insertNode(node, n);
		}

		public Node insertNode(Node curr, int n) {
			// curr이 null이면 root
			if (curr == null) {
				curr = new Node(n);
			} else {
				// 현재 노드의 값보다 새로 넣을 값이 작으면 왼쪽자식노드
				if (curr.data > n) {
					curr.left = insertNode(curr.left, n);

				}
				// 현재 노드의 값보다 새로 넣을 값이 크면 오른쪽자식노드
				else if (curr.data < n) {
					curr.right = insertNode(curr.right, n);
				}
			}
			return curr;
		}

		// 전위순회(root->왼->오)
		public void preOrder(Node node) {
			if (node != null) {
				System.out.println(node.data);
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		
		// 후위순회(왼->오->root)
		public void postOrder(Node node) {
			if (node != null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.println(node.data);
			}
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/BOJ_5639_이진검색트리/input.txt");
		
		Scanner sc = new Scanner(file);
		Tree tree = new Tree();

		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			tree.insert(num);
		}

		tree.postOrder(tree.node);

	} // main

} // class
