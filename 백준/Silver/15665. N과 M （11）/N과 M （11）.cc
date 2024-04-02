#include <iostream>
#include <algorithm>
#define MAX 9
using namespace std;

int N, M;
int sequence[MAX];
//bool visited[10001];
int inputNum[MAX];

void dfs(int cnt);

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> inputNum[i];
	}
	sort(inputNum, inputNum + N);
	dfs(0);
}

void dfs(int cnt) {
	if (cnt == M) {
		for (int index = 0; index < M; index++)
			cout << sequence[index] << ' ';
		cout << '\n';
	}
	else {
		int tmp = 0;
		for (int index = 0; index < N; index++) {
			if (inputNum[index] != tmp) {
				sequence[cnt] = inputNum[index];
				//latestIdx = index;
				//visited[index] = true;
				dfs(cnt + 1);
				//visited[index] = false;
				tmp = inputNum[index];
			}
		}
	}
}