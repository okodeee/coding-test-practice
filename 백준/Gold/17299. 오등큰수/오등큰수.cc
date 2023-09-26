#include <iostream>
#include <stack>
#include <vector>
using namespace std;
#define MAX 1000000


int main() {
	vector<int> A;
	vector<int> temp(MAX+1, 0);
	vector<int> F;
	stack<int> NGF;
	stack<int> NGA;
	vector<int> ans;

	int cnt, n;
	cin >> cnt;
	for (int i = 0; i < cnt; i++) {
		cin >> n;
		A.push_back(n);
		temp[A[i]]++;
	}

	for (int i = 0; i < cnt; i++) {
		F.push_back(temp[A[i]]);
	}

	ans.push_back(-1);
	for (int i = cnt - 2; i >= 0; i--) {
		if (F[i] < F[i + 1]) {
			NGF.push(F[i + 1]);
			NGA.push(A[i + 1]);
		}
		while (!NGF.empty() && F[i] >= NGF.top()) {
			NGF.pop();
			NGA.pop();
		}
		if (NGF.empty()) ans.push_back(-1);
		else	ans.push_back(NGA.top());
	}
	
	for (int i = cnt-1; i >=0; i--) {
		cout << ans[i] << ' ';
	}

	return 0;
}