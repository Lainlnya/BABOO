package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Node {
    boolean visited;
    int data;
    Node left;
    Node right;
    //이진 트리이므로 왼쪽 노드 오른쪽 노드 그리고 데이터값을 가진 노드를 만들어서 품

    public Node(int data) {
        this.data = data;

    }
}

public class BOJ_5639_이진검색트리_Cho {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(bf.readLine()));
        String input = bf.readLine();
        while (input != null) {
            //입력의 끝이 안나와서 애먹음 인텔리 제이에서 돌리는 것도 애먹음
            int num = Integer.parseInt(input);
            Node curr = root;
            while (true) {
                if (num < curr.data) {
                    if (curr.left == null) {
                        curr.left = new Node(num);
                        break;
                    }
                    curr = curr.left;
                    //그냥 작으면 왼쪽으로 계속보내고 더 갈 곳 없으면 새롭게 노드 만든다음 탈출
                }
                else {

                    if (curr.right == null) {
                        curr.right = new Node(num);
                        break;
                    }
                    curr = curr.right;
                } //비교하는 값보다 크면 오른쪽으로 계속 보내고 더 갈 곳 없으면 새롭게 노드 만든다음 탈출

            }

            input = bf.readLine();

        } //입력 끝날 때까지 받아오기
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node tmpNode = stack.peek(); //슬쩍꺼내서 값 봄
            if (tmpNode.visited) {
                System.out.println(tmpNode.data);
                stack.pop();
                continue;
            } //스택에 넣되, 이미 한번 꺼내본 친구는 후위연산 특성상 다음에 볼 때는 값을 출력해야함
            tmpNode.visited = true; //처음 본 친구면 일단 방문 처리만 하고 진행
            if (tmpNode.left == null && tmpNode.right == null) {
                System.out.println(tmpNode.data);
                stack.pop();
                continue;
            } // 널 처리가 까다워서 이렇게 됨. 둘다 널이면 리프 노드이므로 출력하고 스택에서 제거
            if (tmpNode.right != null) {
                stack.add(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.add(tmpNode.left);
            } //왼쪽 혹은 오른쪽만 널이면 스택에 추가

        } //while stack is empty;
    }//main
}
