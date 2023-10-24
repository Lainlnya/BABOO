import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int[] parent; //부모 노드 저장 배열
    static Set<Integer>[] tree; //연결 노드 저장된 셋 배열 혹시 모를 중복 낚시 피하기 위함
    static int[] size; // 자기 아래 자식들이 몇개인지 세는거


    //메모리 초과 떠서 조금 갈아 엎음
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int root = sc.nextInt();
        int Q = sc.nextInt();
        parent = new int[N+1];
        size = new int[N + 1];
        tree = new TreeSet[N + 1];
        for (int i =0 ; i< N+1; i++) {
            tree[i] = new TreeSet();
        }
        for (int i = 0; i < N - 1; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            tree[num1].add(num2);
            tree[num2].add(num1);
        } //입력 끝 부모 자식 구분없이 연결된거 전부 기록
        makeTree(root);
        countSubTreeNodes(root);
        for (int i = 0; i < Q; i++) {
            int subTreeRoot = sc.nextInt();
            System.out.println(size[subTreeRoot]);
        }

    }

    static void makeTree(int cN) {
        for (int Node : tree[cN]) {
            if (Node != parent[cN]) {
                parent[Node] = cN;
                makeTree(Node);
            }
        }

    } //재귀로 트리 만들기 자기랑 연결된 것 중에 부모노드가 아닌 모든 노드들 검사하며 재귀
    // 루트는 부모가 초기값 0 ( 배열 idx가 1부터 시작하기에 0은 불가능한 값) 이기에 문제 없이 돌아간다.
    static void countSubTreeNodes(int cN) {
        size[cN] = 1;
        for (int Node : tree[cN]) {
            if (Node != parent[cN]) {
                countSubTreeNodes(Node);
                size[cN] += size[Node];
            }
        }
    } //역시 재귀로 사이즈 계산해주는 함수
    //처음 크기(자기 자신도 포함시키기 때문에) 는 1이고 그 외에는 연결된 모든 자식 노드들의 size를 더한 값이 본인의 노드 size가 된다.
    //재귀이기에 결국 리프노드 도달까지 반복되며 리프노드 도달시 size[cN] =1로 바로 반환되어 계산됨

}
