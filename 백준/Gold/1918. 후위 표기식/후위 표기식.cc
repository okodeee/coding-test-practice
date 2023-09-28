#include <iostream>
#include <stack>
#include <string>
using namespace std;

string str, ans;

int main() {
	
	cin >> str;

	stack<char> st;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') {
			cout << str[i];
		}
		else {
			if (str[i] == '(')
				st.push(str[i]);
			else if (str[i] == ')') {
				while (!st.empty() && st.top() != '(') {
					cout << st.top();
					st.pop();
				}
				st.pop();
			}
			else if (str[i] == '*' || str[i] == '/') {
				while (!st.empty() && (st.top() == '*' || st.top() == '/')) {
					cout << st.top();
					st.pop();
				}
				st.push(str[i]);
			}
			else if (str[i] == '+' || str[i] == '-') {
				while (!st.empty() && st.top() != '(') {
					cout << st.top();
					st.pop();
				}
				st.push(str[i]);
			}
		}
	}
	while (!st.empty()) {
		cout << st.top();
		st.pop();
	}

	return 0;
}