#include <iostream>
#include <stack>
#include <string>
using namespace std;


int main() {
	int cnt;
	string exp;

	cin >> cnt >> exp;

	int val[26];
	for (int i = 0; i < cnt; i++) {
		cin >> val[i];
	}

	stack<double> st;
	double temp1, temp2;
	for (int i = 0; i < exp.length(); i++) {
		if (exp[i] >= 'A' && exp[i] <= 'Z') {
			st.push(val[exp[i] - 'A']);
		}
		else if (exp[i] == '*') {
			temp2 = st.top();
			st.pop();
			temp1 = st.top();
			st.pop();
			st.push(temp1*temp2);
		}
		else if (exp[i] == '+') {
			temp2 = st.top();
			st.pop();
			temp1 = st.top();
			st.pop();
			st.push(temp1+temp2);
		}
		else if (exp[i] == '-') {
			temp2 = st.top();
			st.pop();
			temp1 = st.top();
			st.pop();
			st.push(temp1-temp2);
		}
		else if (exp[i] == '/') {
			temp2 = st.top();
			st.pop();
			temp1 = st.top();
			st.pop();
			st.push(temp1/temp2);
		}
	}

	cout << fixed;
	cout.precision(2);
	cout << st.top() << endl;

	return 0;
}