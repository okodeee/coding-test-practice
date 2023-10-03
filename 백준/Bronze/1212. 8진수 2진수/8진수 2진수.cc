#include <iostream>
#include <vector>
#include <string>
using namespace std;


int main() {
	string input;
	cin >> input;

	vector<int> ans;
	for (int i=0;i<input.length();i++) {
		int temp = input[i] - '0';

		ans.push_back(temp / 4);
		temp = temp % 4;
		ans.push_back(temp / 2);
		temp = temp % 2;
		ans.push_back(temp);
	}

	while (!ans.empty()) {
		if (ans.front() == 1)	break;
		ans.erase(ans.begin());
	}
    if (ans.empty()) cout << 0 << endl;
	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i];
	}

	return 0;
}