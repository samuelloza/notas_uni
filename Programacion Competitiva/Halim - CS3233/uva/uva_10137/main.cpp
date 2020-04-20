#include<stdio.h>
int main()
{
    double tem[1001];
    double sum,neg_dif,pos_dif;
    long int n,i;
    scanf("%ld",&n);
    while(n>0)
    {
        sum=0.0,neg_dif=0.0,pos_dif=0.0;
        for(i=1; i<=n; i++)
        {
            scanf("%lf",&tem[i]);
            tem[i]*=100;
            sum=sum+tem[i];
        }
        double avrg=sum/(double)n;
        for(i=1; i<=n; i++)
        {
            if(tem[i]>avrg)
                neg_dif+=(int)(tem[i]-avrg);
            else
                pos_dif+=(int)(avrg-tem[i]);
        }
        if(pos_dif>neg_dif)
            printf("$%.2lf\n",pos_dif/100);
        else
            printf("$%.2lf\n",neg_dif/100);
        scanf("%ld",&n);

    }
    return 0;
}

