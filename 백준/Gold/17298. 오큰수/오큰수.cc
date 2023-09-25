#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {;
	int cnt;
	cin >> cnt;

	vector<int> A;
	int n;
	for (int i = 0; i < cnt; i++) {
		cin >> n;
		A.push_back(n);
	}

	stack<int> NGE;
	vector<int> ans;
	ans.push_back(-1);

	for (int i = cnt-1; i > 0; i--) {
		if (A[i-1] < A[i]) NGE.push(A[i]);

		while (!NGE.empty() && A[i - 1] >= NGE.top())
			NGE.pop();

		if (NGE.empty()) {
			ans.push_back(-1);
		}
		else {
			ans.push_back(NGE.top());
		}
	}

	for (int i = ans.size()-1; i >= 0; i--) {
		cout << ans[i] << ' ';
	}

	return 0;
}