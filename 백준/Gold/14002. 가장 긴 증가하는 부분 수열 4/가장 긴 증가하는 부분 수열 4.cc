#include <iostream>
//#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int nums[1001] = { 0, };
	int longest[1001] = { 0, };
	int prior[1001] = { 0, };

	int cnt;
	cin >> cnt;

	for (int i = 1; i <= cnt; i++) {
		cin >> nums[i];
		for (int j = 0; j < i; j++) {
			if (nums[j] < nums[i]) {
				if (longest[i] < longest[j] + 1) {
					longest[i] = longest[j] + 1;
					prior[i] = j;
				}
			}
		}
	}
	int len = 0;
	int last = 0;
	for (int i = 1; i <= cnt; i++) {
		if (len < longest[i]) {
			len = longest[i];
			last = i;
		}
	}
	vector<int> subseq;
	while (last) {
		subseq.push_back(last);
		last = prior[last];
	}
	cout << len << endl;
	for (int i = subseq.size()-1; i >= 0; i--) {
		cout << nums[subseq[i]] << ' ';
	}

	return 0;
}