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
		for (int i = 0; i < N; i++) {
			if (sequence[cnt - 1] == inputNum[i])
				break;
		}
		for (int index = latestIdx; index < N; index++) {
			if (visited[inputNum[index]] == false) {
				sequence[cnt] = inputNum[index];
				visited[inputNum[index]] = true;
				dfs(cnt + 1, index + 1);
				visited[inputNum[index]] = false;
			}
		}
	}
}