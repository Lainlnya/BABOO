package WEEK_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20m
public class BOJ_5639_이진검색트리_Kim {
    static StringBuilder sb;
    
    // tree에 넣을 노드 객체
    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
    
    // 트리 객체
    static class Tree {
        public Node root;

        // 노드 추가할 때
        private Node insertNode(Node node, int value) {
            if (node == null) {
                node = new Node(value);
                // 현재 node 보다 작은 값은 왼쪽으로
            } else if (value < node.value) {
                node.left = insertNode(node.left, value);
                // 현재 node 보다 큰 값은 오른쪽으로
            } else if (value > node.value) {
                node.right = insertNode(node.right, value);
            }
            return node;
        }

        public void insert(int value) {
            this.root = insertNode(this.root, value);
        }

        // 후위순회
        public void postOrder(Node node) {
            if (node != null) {
            	// 왼쪽 -> 오른쪽 -> 가운데
                postOrder(node.left);
                postOrder(node.right);
                sb.append(node.value + "\n");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        Tree tree = new Tree();

        String input;
        // leaf 넣자
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            tree.insert(value);
        }

        // root부터 시작해서 후위순회
        tree.postOrder(tree.root);
        System.out.println(sb);
    }

}

