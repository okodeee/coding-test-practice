#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int nums[1001] = { 0, };
	int longest[1001] = { 0, };
	
	int cnt;
	cin >> cnt;

	for (int i = 1; i <= cnt; i++) {
		cin >> nums[i];
		for (int j = 0; j < i; j++) {
			if (nums[j] < nums[i])
				longest[i] = max(longest[i], longest[j] + 1);
		}
	}
	int ans = 0;
	for (int i = 1; i <= cnt; i++) {
		ans = max(ans, longest[i]);
	}
	cout << ans << endl;
	
	return 0;
}