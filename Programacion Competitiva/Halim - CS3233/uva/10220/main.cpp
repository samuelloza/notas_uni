/*
by starsaminf
Bignumber.cpp
con errores al multiplicar
imprime con "0" por delantes :(
*/
#include <iostream>
#include <stdlib.h>
#include <math.h>
#include <stdio.h>
#include <string>
#include <bitset>
#include <sstream>
#define MAXDIGITS  3000

typedef struct {
    int digits[MAXDIGITS];
    int nrodigits;
} bignum;
//imprime
void print_bignum(bignum *n) {
    int i=0;
    for (; i<n->nrodigits; i++)
        printf("%d",n->digits[i]);
    printf("\n");
}
//cast
void string_to_bignum(std::string s, bignum *n) {
    int i=0;
    for(; i<s.length(); i++) {
        n->digits[i]=(s[i]-'0');
    }
    n->nrodigits=i;

}

//suma
void add_bignum(bignum *a, bignum *b, bignum *c) {
    int carry=0,a1,b1;
    int i=a->nrodigits,j=b->nrodigits,ma;
    ma=c->nrodigits = std::max(a->nrodigits,b->nrodigits)+1;

    for(; i>=0||j>=0; ma--) {
        if(i>=0) {
            a1=a->digits[i];
            i--;
        } else {
            a1=1;
        }
        if(j>=0) {
            b1=b->digits[j],j--;
        } else {
            b1=1;
        }
        c->digits[ma]=(a1+b1)+carry;
        carry=c->digits[ma]/10;
        c->digits[ma]%=10;
    }
    c->digits[0]=carry;
}
//multiplicacion invertida
void multiply_bignum(bignum *a, bignum *b, bignum *c) {
    bignum one;
    int i,j,h=0,a1,b1,h2=0,carry=0;
    for (i=a->nrodigits-1; i>=0; i--,carry=0) {
        int h3=h2;
        a1=a->digits[i];
        for (j=b->nrodigits-1; j>=0; j--) {
            b1=b->digits[j];
            one.digits[h2]=((a1*b1)+carry)+one.digits[h2];
          //  add_bignum()
            carry=(one.digits[h2]/10);
            one.digits[h2]%=10;
            h2++;
        }
        if(carry>=1) {
            one.digits[h2]=carry;
            carry=0;
            h++;
        }

        h++;
        h2=h;
    }
    one.nrodigits=c->nrodigits=(h+=b->nrodigits);
//borrar
//   int j2=0;
//   for(j2=one.nrodigits;j2>=0;j2--){
//       if(one.digits[j2]!=0)break;
//   }
   //fin si borra ;
    int ii=0;
    for(i=i=one.nrodigits; i>=0; i--,ii++) {
        c->digits[ii]=one.digits[i-1];
        one.digits[i-1]=0;
    }
    one.nrodigits=0;
}
using namespace std;
int main() {

    bignum res[2000];
    bignum x2;
    string_to_bignum("1",&x2);

    int cc=0,ma=1000;
    while(cc<=1000) {
        string_to_bignum("1",&res[cc]);
        cc++;
    };
    for (int n= 2; n<ma; n++) {
        string s;
        stringstream out;
        out << n;
        s=out.str();
        string_to_bignum(s,&x2);
        multiply_bignum(&x2,&res[n-1],&res[n]);
    }
    for(int i=0; i<1000; i++) {
        cout<<i<<" ";
        print_bignum(&res[i]);
    }

    return 0;
}
