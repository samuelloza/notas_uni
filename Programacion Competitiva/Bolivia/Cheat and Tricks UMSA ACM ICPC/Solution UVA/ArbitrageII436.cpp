#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

static const int max_countries = 30;

double exchange[max_countries][max_countries];
string countries[max_countries];

int getCountryCode(string country){
	
	for(int i=0; i< max_countries; i++){
			if(countries[i]==country){
				return i;
			}
		}
	return -1;
}

void resetExchange(){
	for(int i=0; i< max_countries; i++){
			for(int j=0; j< max_countries; j++){
			exchange[i][j]=0;
		}
	}
}



int main(){
	int case_number=0;
	int currencies;
	while(cin>>currencies){
		case_number++;
		if(currencies==0)return 0;
		
		resetExchange();
		
		for(int i=0; i< max_countries; i++){
			countries[i]="";
		}
		
		for(int i=0; i< currencies; i++){
			string country;
			cin>>country;	
			countries[i]=country;
		}
		int ex_rates;
		cin>>ex_rates;
		
		for(int i=0; i< ex_rates; i++){
			string tmp;
			double rate;
			cin>>tmp;
			int from_country = getCountryCode(tmp);
			cin>>rate;
			cin>>tmp;
			int to_country = getCountryCode(tmp);
			exchange[from_country][to_country] = rate;//exchanges are directed can only go one way
			//exchange[to_country][from_country] = 1/rate;			
		}
		
		//run folyd warshall to see if we can make money through arbitrage
		//if we can find a "longest path"
		
		for(int k=0; k< currencies; k++){
			for(int i=0; i<currencies; i++){
			for(int j=0; j<currencies; j++){
				
				exchange[i][j] = max(exchange[i][j],  exchange[i][k]*exchange[k][j]);
				
			}				
			}		
			
		}
		
		bool profit = false;
				
		for(int i=0; i<currencies; i++){
			if(exchange[i][i]>1){
				profit = true;
			}
		//	cout<<exchange[i][i]<<"  ";
		}
		
		if(profit){
			cout<<"Case " << case_number<<": Yes"<<endl;
		}else{
			cout<<"Case " << case_number<<": No"<<endl;
		}
	
	
	}
}