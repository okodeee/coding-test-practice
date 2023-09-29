#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
	string str;
	cin >> str;

	vector<string> ans;
	for (int i = 0; i < str.length(); i++) {
		ans.push_back(str.substr(i));
	}

	sort(ans.begin(), ans.end());

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << endl;
	}

	return 0;
}