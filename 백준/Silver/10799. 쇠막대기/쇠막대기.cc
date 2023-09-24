#include <iostream>
#include <stack>
#include <string>
using namespace std;


int main() {
	string input = "";
	cin >> input;

	stack<char> st;
	int ans = 0;

	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '(') {
			st.push('(');
		}
		else {
			if (input[i - 1] == '(') { //레이저
				st.pop();
				ans += st.size();
			}
			else { //쇠막대기 끝
				st.pop();
				ans += 1;
			}
		}
	}

	cout << ans << endl;

	return 0;
}