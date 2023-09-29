#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main() {
	string str;
	cin >> str;

	vector<int> ans;
	for (char ch = 'a'; ch <= 'z'; ch++) {
		ans.push_back(str.find(ch));
	}

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << ' ';
	}
	return 0;
}