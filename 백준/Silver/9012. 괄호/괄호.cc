#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	int num;
	cin >> num;
	cin.ignore();

	while (num--) {
		string s = "";
		getline(cin, s);
		
		stack<char> stack;
		bool VPS = true;
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == ')') {
				if (!stack.empty() && stack.top() == '(') {
					stack.pop();
				}
				else {
					VPS = false;
					break;
				}
			}
			else stack.push(s[i]);
		}
		if (VPS == true && stack.empty())	cout << "YES" << endl;
		else cout << "NO" << endl;
	}
}