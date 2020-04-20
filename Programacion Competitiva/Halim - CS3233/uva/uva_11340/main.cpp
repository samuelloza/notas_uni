#include <string.h>
#include <iostream>
#include <stdio.h>
//#include <fstream>
using namespace std;
int main()
{
    //ofstream fout ("test.out");
    // ifstream fin ("test.in");
    int n=0;
    double pre=0;
    cin>>n;
    while(n--)
    {
        int n2=0,n3=0;
        char cad=0;
        char cade2[10000+10];
        double vec[256]= {0.0},vec2[256]= {0.0};
        cin>>n2;
        while(n2--)
        {
            cin>>cad;
            cin>>pre;
            vec[int(cad)]=pre;
        }
        cin>>n3;
        char x;
        string adsadas;
        getline(cin,adsadas);
        while(n3--)
        {
           // cout<<"*****"<<endl;
            while ((x = getchar()) != '\n')
            {
               // cout<<int(x)<<endl;
                vec2[int(x)]++;
            }
        }
        double  sum=0;
        for(int i=0; i<256; i++)
        {
            sum+=vec2[i]*vec[i];
        }
        int dol = sum / 100;
        int su2=int(sum)%100;
        //sum =
        cout << dol << "." << (su2 < 10 ? "0": "") << su2 << "$" << endl;
        // printf("%.2f$\n",sum/100);
        //printf("%0.2lf$\n",sum/100.0);
    }
    return 0;
}
