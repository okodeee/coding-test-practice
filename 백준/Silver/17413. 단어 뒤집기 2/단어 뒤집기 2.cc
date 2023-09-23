#include <iostream>
#include <stack>
#include <vector>
#include <string>
using namespace std;

int main() {
	string S = "";
	getline(cin, S);

	stack<char> st;
	vector<char> ans;

	bool tag = false;

	for (int i = 0; i <= S.size(); i++) {
		if (!tag) {
			if (S[i] == '<') {
				tag = true;
				while (!st.empty()) {
					ans.push_back(st.top());
					st.pop();
				}
				ans.push_back('<');
			}
			else if (S[i] == ' ') {
				while (!st.empty()) {
					ans.push_back(st.top());
					st .pop();
				}
				ans.push_back(' ');
			}
			else if (S[i] == '\0') {
				while (!st.empty()) {
					ans.push_back(st.top());
					st.pop();
				}
			}
			else {
				st.push(S[i]);
			}
		}
		else {
			if (S[i] == '>') {
				tag = false;
				ans.push_back(S[i]);
			}
			else {
				ans.push_back(S[i]);
			}
		}
	}

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i];
	}

	return 0;
}