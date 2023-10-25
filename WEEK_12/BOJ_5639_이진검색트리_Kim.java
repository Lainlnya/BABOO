package WEEK_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20m
public class BOJ_5639_이진검색트리_Kim {
    static StringBuilder sb;
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
    static class Tree {
        public Node root;

        private Node insertNode(Node node, int value) {
            if (node == null) {
                node = new Node(value);
            } else if (value < node.value) {
                node.left = insertNode(node.left, value);
            } else if (value > node.value) {
                node.right = insertNode(node.right, value);
            }
            return node;
        }

        public void insert(int value) {
            this.root = insertNode(this.root, value);
        }

        public void postOrder(Node node) {
            if (node != null) {
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

        tree.postOrder(tree.root);
        System.out.println(sb);
    }

}

