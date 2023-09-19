#include <iostream>
#include <queue>
using namespace std;


int main() {
	int n, k;
	cin >> n >> k;

	queue<int> q;
	for (int i = 0; i < n; i++) {
		q.push(i + 1);
	}
	queue<int> ans;
	while (!q.empty()) {
		for (int i = 1; i < k; i++) {
			q.push(q.front());
			q.pop();
		}
		ans.push(q.front());
		q.pop();
	}

	cout << "<";
	for (int i = 0; i < n - 1; i++) {
		cout << ans.front() << ", ";
		ans.pop();
	}
	cout << ans.front() << ">" << endl;

	return 0;
}