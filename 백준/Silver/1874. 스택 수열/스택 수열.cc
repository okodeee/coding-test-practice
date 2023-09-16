#include <iostream>
#include <stack>
#include <vector>
using namespace std;


int main() {
	vector<char> ans;
	stack<int> st;
	st.push(0);
	int cnt = 1;
	bool valid = true;
	int n;
	cin >> n;

	while (n--) {
		int input;
		cin >> input;

		if (st.top() > input) {
			valid = false;
			break;
		}
		else {
			while (st.top() != input) {
				st.push(cnt++);
				ans.push_back('+');
			}
			st.pop();
			ans.push_back('-');
		}	
	}
	if (valid == true) {
		for (int i = 0; i < ans.size(); i++) {
			cout << ans[i] << "\n";
		}
	}
	else cout << "NO" << endl;
}
