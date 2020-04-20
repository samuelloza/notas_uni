#include<stdio.h>
int main()
{
    long a,b,ans,kase,i;
    while(scanf("%ld",&kase)==1)
    {
        for(i=1; i<=kase; i++)
        {
            scanf("%ld%ld",&a,&b);
            a=(a/3)*(b/3);
            printf("%ld\n",a);
        }
    }
    return 0;
}
