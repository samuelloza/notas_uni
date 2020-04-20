#include <iostream>
using namespace std;
int main()
{
    int tamcad;
    string cadena;
    while( (cin >> cadena) && cadena.compare(".") != 0)
    {
        tamcad = cadena.size();
        int sol;
        for(sol = 1; sol <= tamcad; sol++)
            if((tamcad % sol) == 0)
            {
                string tmp = cadena.substr(0,sol);
                bool sw = true;
                for(int i = sol ; i<=(tamcad-sol) && sw; i+=sol)
                    sw = (tmp.compare(cadena.substr(i,sol))==0);
                if(sw)
                {
                    cout << tamcad/sol<<endl;
                    break;
                }
            }
    }

    return 0;
}
