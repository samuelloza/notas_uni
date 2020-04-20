#include <stdio.h>
#include <stdlib.h>

#define TAM 9

int main(void)
{
    unsigned char vector[TAM+1];
    int i, a=1, k, primo, cont=0;
    for(i=0; i<=TAM; i++)
        vector[i]=1;
    puts("GENERACION DE NUMEROS PRIMOS MEDIANTE LA CRIBA DE ERATOSTENESn");
    for(i=0; i<=TAM; i++)
    {
        if(vector[i])
        {
            primo=2*i+3;
            if(a<15)
            {
                printf("%d ", primo);
                for(k=i+primo; k<=TAM; k+=primo)
                    vector[k]=0;
                cont++;
                a++;
            }
            else
            {
                printf("n");
                printf("%d ", primo);
                for(k=i+primo; k<=TAM; k+=primo)
                    vector[k]=0;
                cont++;
                a=1;
            }
        }
    }
    printf("nn%d nxA3meros primosnnn", cont);
    return 0;
}
