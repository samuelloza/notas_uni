#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include<sstream>
using namespace std;
bool ispal(string num)
{
    bool sw=true;
    int fi=num.length();
    for(int i=0; i<(num.length()-1)/2+1; i++)
    {
        fi--;
        if(num.at(i)!=num.at(fi))
        {
            sw=false;
            break;
        }
    }
    return sw;
}

string reverse(string a)
{
    string cad="";
    for(int i=0; i<a.size(); i++)
        cad=a.at(i)+cad;

    return cad;
}

int main()
{
    int num=0;
    cin>>num;
    string caso;
    while(num--)
    {
        long long int f=0,f2=0,resp=0,conver;
        cin>>caso;
        conver=atof(caso.data());
        //
        stringstream cvz; //conver a string un int
        cvz<<conver;
        caso=cvz.str();
        //
        while(true)
        {
            f=atof(caso.data());
            string r=reverse(caso);
            f2=atof(r.data());
            stringstream cvz; //conver a string un int
            cvz<<f+f2;
            f=f2+f;
            if(ispal(caso))
            {
                cout<<resp<<" "<<caso<<endl;
                break;
            }
            resp++;
            caso=cvz.str();
        }
    }
    return 0;
}
