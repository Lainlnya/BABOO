import java.util.*;
 
public class BOJ_1068_트리_Yoo {
 
    static int n, delete;
    static int[] parent;
    static int count;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        parent = new int[n];
        visited = new boolean[n];
        
        //기본 입력
        int root = 0;
        for(int i = 0; i < n; i++) {
            parent[i] = sc.nextInt();        
            if(parent[i] == -1) {
            	root = i;            	
            }
        }
        //지우자
        delete = sc.nextInt();
        deleteNode(delete);
            
        count = 0;
        
        countLeaf(root);
            
        System.out.println(count);
    }
    
    public static void deleteNode(int d) {
        parent[d] = -2; //삭제된 노드 -2로 표시
        for(int i = 0; i < n; i++) {
            if(parent[i] == d) {
                deleteNode(i);
            }
        }
    }
    
    public static void countLeaf(int s) {
        boolean isLeaf = true;
        visited[s] = true;
        
        //삭제된거 아닐때
        if(parent[s] != -2) {
            for(int i = 0; i < n; i++) {
                if(parent[i] == s && visited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}
