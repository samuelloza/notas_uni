#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int v[4];
	while(cin>>v[0]>>v[1]>>v[2]>>v[3])
	{
		bool triangle = 0, segment = 0;
		
		for(int i=0; i<4; i++)
		{
			int L[3], k = 0;
			for(int j=0; j<4; j++)
				if(i != j) L[k++] = v[j];
			
			sort(L, L + 3);
			
			if(L[0] + L[1] > L[2]) triangle = 1;
			if(L[0] + L[1] == L[2]) segment = 1;
		}
		
		if(triangle) cout<<"TRIANGLE"<<endl;
		else if(segment) cout<<"SEGMENT"<<endl;
		else cout<<"IMPOSSIBLE"<<endl;
	}
	
	return 0;
}