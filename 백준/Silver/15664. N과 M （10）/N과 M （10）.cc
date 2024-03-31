#include <iostream>
#include <algorithm>
#define MAX 9
using namespace std;

int N, M;
int sequence[MAX];
bool visited[10001];
int inputNum[MAX];

void dfs(int cnt, int latestIdx);

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> inputNum[i];
	}
	sort(inputNum, inputNum + N);
	dfs(0, 0);
}

void dfs(int cnt, int latestIdx) {
	if (cnt == M) {
		for (int index = 0; index < M; index++)
			cout << sequence[index] << ' ';
		cout << '\n';
	}
	else {
		int tmp = 0;
		for (int index = latestIdx; index < N; index++) {
			if (visited[index] == false && inputNum[index] != tmp) {
				sequence[cnt] = inputNum[index];
				latestIdx = index;
				visited[index] = true;
				dfs(cnt + 1, latestIdx);
				visited[index] = false;
				tmp = inputNum[index];
			}
		}
	}
}