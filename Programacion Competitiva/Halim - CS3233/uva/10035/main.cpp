#include <iostream>
using namespace std;
int main()
{
    int sum,aca=0,a=0,b=0;
    string a1="0",b1="0";
    cin>>a1>>b1;
    while(!a1.compare("0")==0||!b1.compare("0")==0)
    {
        int nro=0;
        a=b=0;
        int ma=max(a1.length(),b1.length());
        int taA=a1.length()-1,taB=b1.length()-1;
        for(int i=0; i<ma; i++)
        {
            if(i<a1.length())
            {
                a=a1.at(taA-i)-'0';
            }
            if(i<b1.length())
            {
                b=b1.at(taB-i)-'0';
            }
            if((a+b+aca)>=10)
            {
                aca=(a+b+aca)/10;
                nro++;
            }
            else
            {
                aca=0;
            }
            a=b=0;
        }

        if(nro==0)
            cout<<"No carry operation."<<endl;
        else
        {
            if(nro!=1)
                cout<<nro<<" carry operations."<<endl;
            else
                cout<<nro<<" carry operation."<<endl;
        }
        aca=0;
        cin>>a1>>b1;
    }
    return 0;
}
