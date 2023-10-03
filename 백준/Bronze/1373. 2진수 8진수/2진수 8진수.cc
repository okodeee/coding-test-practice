#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main() {
	string input;
	cin >> input;

	vector<int> ans;
	while (!input.empty()) {
		int digit = 0;

		if (!input.empty()) {
			digit += (input.back() - '0') * 1;
			input.pop_back();
		}
		if (!input.empty()) {
			digit += (input.back() - '0') * 2;
			input.pop_back();
		}
		if (!input.empty()) {
			digit += (input.back() - '0') * 4;
			input.pop_back();
		}
		ans.push_back(digit);
	}
	for (int i = ans.size() - 1; i >= 0; i--) {
		cout << ans[i];
	}

	return 0;
}