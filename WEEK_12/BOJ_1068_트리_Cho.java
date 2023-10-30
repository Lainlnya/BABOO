package tree;

import java.util.*;

public class BOJ_1068_트리_Cho {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pN = new int[N];
        //부모노드 저장용
        ArrayList<Integer>[] tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        } //트리를 어레이리스트로 표현 자식 노드들을 다 넣어둠
        for (int idx = 0; idx < N; idx++) {
            int treeN = sc.nextInt();
            pN[idx] = treeN;
            //부모노드 기록
            if (treeN == -1) {
                continue;
            } //-1이면 루트이므로 무시
            tree[treeN].add(idx);
            //그 외에는 어레이 리스트에 넣기
        }
        int deleteN = sc.nextInt();
        //지울 노드 받기
        if (pN[deleteN] != -1)
            tree[pN[deleteN]].removeIf(item ->item.equals(deleteN));
        //루트가 아닌 경우에는 부모가 있으므로 그 부모로 가서 노드를 잘라버린다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(deleteN); //queue에 넣고 bfs
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int num : tree[idx]) {
                queue.add(num);
            }
            tree[idx] = null;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (tree[i] != null && tree[i].size() == 0)
                count++;
        } // null이 아니면 그 노드가 살아있는거고 사이즈가 0이면 리프임을 뜻함 그 경우에 +1씩 count해줌
        System.out.println(count);
        //출력

    }
}
