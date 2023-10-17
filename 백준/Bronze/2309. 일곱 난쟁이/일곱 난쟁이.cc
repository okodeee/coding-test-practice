#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
	int dwarf[10];
	for (int i = 1; i < 10; i++) {
		cin >> dwarf[i];
	}
	vector<int> ans;
	for (int i = 1; i < 10; i++) {
		for (int j = 1; j < 10; j++) {
			if (j == i) continue;

			int sum = 0;
			for (int k = 1; k < 10; k++) {
				if (k == i || k == j) continue;
				sum += dwarf[k];
				ans.push_back(dwarf[k]);
			}
			if (sum == 100) {
				j = 10;
				i = 10;
			}
			else ans.clear();
		}
	}
	sort(ans.begin(), ans.end());
	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << endl;
	}

	return 0;
}