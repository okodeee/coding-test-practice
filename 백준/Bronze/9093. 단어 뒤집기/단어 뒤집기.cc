#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	int i;
	cin >> i;
	cin.ignore();

	while (i--) {
		string s = "";
		getline(cin, s);
		s += ' ';

		stack<char> stack;

		for (int i = 0; i < s.size(); i++) {
			if (s[i] == ' ') {
				while (!stack.empty()) {
					cout << stack.top();
					stack.pop();
				}
				cout << s[i];
			}
			else stack.push(s[i]);
		}
		cout << endl;
	}
}