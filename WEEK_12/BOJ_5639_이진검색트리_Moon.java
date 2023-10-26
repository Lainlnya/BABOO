package BOJ_5639_이진검색트리;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        // 트리를 전위 순회한 결과를 받으면서 트리를 구성한다.
        void insert(int n) {
            // 부모 노드가 되는 수보다 작으면 왼쪽에 추가 시도한다.
            if (n < this.num) {
                // 왼쪽 노드가 비어있다면 추가한다.
                if (this.left == null)
                    this.left = new Node(n);
                // 비어있지 않다면 그 노드를 부모 노드로 갖고, 왼쪽에 다시 추가 시도한다.
                else this.left.insert(n);
            // 부모 노드가 되는 수보다 크면 오른쪽에 추가 시도한다.
            } else {
                // 오른쪽 노드가 비어있다면 추가한다.
                if (this.right == null)
                    this.right = new Node(n);
                // 비어있지 않다면 그 노드를 부모 노드로 갖고, 오른쪽에 다시 추가 시도한다.
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(sc.nextInt());
        // 입력이 계속 들어오면 트리에 추가한다.
        while (sc.hasNextInt()) {
            root.insert(sc.nextInt());
        }

        // 후위 순회한 결과를 출력하는 method를 실행한다.
        postOrder(root);
        sc.close();
    }

    static void postOrder(Node node) {
        // 노드가 비어있으면 return
        if (node == null)
            return;

        // 비어있지 않으면 왼쪽 오른쪽 자식 노드를 먼저 호출한 후,
        // 자식 노드가 모두 출력된 후 해당 노드를 출력한다.
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}