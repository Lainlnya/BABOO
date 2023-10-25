
public class BOJ_11279_최대힙_Yoo {
/*

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main ()
{
 	// 입출력 빠르게 도핑
    ios::sync_with_stdio(false);
    cin.tie(NULL);

// 선언, 입력
    int n;
    cin >> n;

//우선순위 큐
    priority_queue<int> q;
		
		for(int i =0; i<n; i++) {
			int a;
            cin >> a;
            
			if(a==0) {
			
			//비었으면 0
				if(q.empty()) {
					cout << 0<< "\n";
				}
				// 가장 위에 출력
				else {
                    cout << q.top() << "\n";
                    q.pop();
				}
			}
			
			//아니라면 집어넣기
			else {
				q.push(a);				
			}
		}
    return 0;
}

 */
}
