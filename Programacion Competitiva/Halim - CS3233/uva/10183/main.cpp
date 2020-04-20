#include <iostream>
#include <stdio.h>
#include <string.h>
#define MAXDIGITS  102
#define PLUS		1		/* positive sign bit */
#define MINUS		-1		/* negative sign bit */
typedef struct
{
    char digits[MAXDIGITS];         /* represent the number */
    int signbit;			/* 1 if positive, -1 if negative */
    int lastdigit;			/* index of high-order digit */
} bignum;


void print_bignum(bignum *n)
{
    int i;

    if (n->signbit == MINUS) printf("- ");
    for (i=n->lastdigit; i>=0; i--)
        printf("%c",'0'+ n->digits[i]);

    printf("\n");
}

void int_to_bignum(int s, bignum *n)
{
    int i;				/* counter */
    int t;				/* int to work with */

    if (s >= 0) n->signbit = PLUS;
    else n->signbit = MINUS;

    for (i=0; i<MAXDIGITS; i++) n->digits[i] = (char) 0;

    n->lastdigit = -1;

    t = s;
    while (t > 0)
    {
        n->lastdigit ++;
        n->digits[ n->lastdigit ] = (t % 10);
        t = t / 10;
    }

    if (s == 0) n->lastdigit = 0;
}
void string_to_bignum(std::string s, bignum *n)
{
    int i;				/* counter */

    n->signbit = PLUS;

    for (i=0; i<MAXDIGITS; i++) n->digits[i] = (char) 0;

    n->lastdigit = -1;

    int li=s.length();
    while (li>0)
    {
        li--;
        n->lastdigit ++;
        n->digits[ n->lastdigit ] =s[li]-'0';
        //std::cout<<s[li]<<" -- "<<std::endl;
    }
}

void initialize_bignum(bignum *n)
{
    int_to_bignum(0,n);
}


int max(int a, int b)
{
    if (a > b) return(a);
    else return(b);
}


int compare_bignum(bignum *a, bignum *b)
{
    int i;				/* counter */

    if ((a->signbit == MINUS) && (b->signbit == PLUS)) return(PLUS);
    if ((a->signbit == PLUS) && (b->signbit == MINUS)) return(MINUS);

    if (b->lastdigit > a->lastdigit) return (PLUS * a->signbit);
    if (a->lastdigit > b->lastdigit) return (MINUS * a->signbit);

    for (i = a->lastdigit; i>=0; i--)
    {
        if (a->digits[i] > b->digits[i]) return(MINUS * a->signbit);
        if (b->digits[i] > a->digits[i]) return(PLUS * a->signbit);
    }

    return(0);
}

void zero_justify(bignum *n)
{
    while ((n->lastdigit > 0) && (n->digits[ n->lastdigit ] == 0))
        n->lastdigit --;

    if ((n->lastdigit == 0) && (n->digits[0] == 0))
        n->signbit = PLUS;	/* hack to avoid -0 */
}

void add_bignum(bignum *a, bignum *b, bignum *c)
{
    int carry;			/* carry digit */
    int i;				/* counter */

    initialize_bignum(c);


    c->lastdigit = max(a->lastdigit,b->lastdigit)+1;
    carry = 0;

    for (i=0; i<=(c->lastdigit); i++)
    {
        c->digits[i] = (char) (carry+a->digits[i]+b->digits[i]) % 10;
        carry = (carry + a->digits[i] + b->digits[i]) / 10;
    }

    zero_justify(c);
}
using namespace std;

int main()
{
    bignum res[500+1];
    int_to_bignum(1,&res[0]);
    int_to_bignum(2,&res[1]);
    for (int n = 2; n<500; ++n)
    {
        add_bignum(&res[n-2],&res[n-1],&res[n]);
    }
    bignum x2,y2;
    string x,y;
    while(cin>>x>>y)
    {
        if(x.compare("0")==0&&y.compare("0")==0)
        {
            break;
        }
        string_to_bignum(x,&x2);
        string_to_bignum(y,&y2);
        int conta=0;
        for(int i=0; i<500; i++)
        {
            if(compare_bignum(&res[i],&x2)==0)
            {
                while(compare_bignum(&y2,&res[i])==-1||compare_bignum(&y2,&res[i])==0)
                {
                    i++;
                    conta++;
                }
                break;
            }
            else
            {
                if(compare_bignum(&res[i],&x2)==-1)
                {
                    while(compare_bignum(&y2,&res[i])==-1||compare_bignum(&y2,&res[i])==0)
                    {
                        i++;
                        conta++;
                    }
                    break;
                }
                else
                {
                    //  while(compare_bignum(&res[i],&y2)==1)
                    // {
                    //   i++;
                    //   conta++;
                    //}
                    //break;
                }
            }
        }
        cout<<conta<<endl;
    }
}


/*
0
0
a = 0    b = 0
compare_bignum a ? b = 0
12
13
a = 12    b = 13
compare_bignum a ? b = 1
13
12
a = 13    b = 12
compare_bignum a ? b = -1
*/



