#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	string str;
	cin >> str;

	stack<char> left;
	stack<char> right;

	for (int i = 0; i < str.size(); i++) {
		left.push(str[i]);
	}

	int cnt = 0;
	cin >> cnt;

	while (cnt--) {
		char input;
		cin >> input;

		if (input == 'L' && !left.empty()) {
			right.push(left.top());
			left.pop();
		}
		else if (input == 'D' && !right.empty()) {
			left.push(right.top());
			right.pop();
		}
		else if (input == 'B' && !left.empty()) {
			left.pop();
		}
		else if (input == 'P') {
			cin >> input;
			left.push(input);
		}
	}

	while (!left.empty()) {
		right.push(left.top());
		left.pop();
	}
	while (!right.empty()) {
		cout << right.top();
		right.pop();
	}

	return 0;
}