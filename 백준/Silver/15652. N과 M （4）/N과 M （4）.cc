#include <iostream>
#define MAX 9
using namespace std;

int N, M;
int sequence[MAX];
//bool visited[MAX];

void dfs(int cnt);

int main() {
	cin >> N >> M;
	sequence[0] = 1;
	dfs(0);
}

void dfs(int cnt) {
	if (cnt == M) {
		for (int index = 1; index <= M; index++)
			cout << sequence[index] << ' ';
		cout << '\n';
	}
	else {
		for (int num = sequence[cnt]; num <= N; num++) {
			sequence[cnt + 1] = num;
			dfs(cnt + 1);
		}
	}
}