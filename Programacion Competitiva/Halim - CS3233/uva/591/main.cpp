#include <stdio.h>

int main()
{

    long n, total, count, avg, a [105], set = 0, i;

	while(scanf("%d", &n)){

		total = count = 0;

		if(n == 0)
            return 0;

		for(i = 0; i < n; i++) {
            scanf("%ld", & a [i]);
            total += a [i];
        }

		avg = total / n;

		for(i = 0; i < n; i++){
            if( a[i] > avg)
                count += (a [i] - avg);
        }

        printf("Set #%d\n", ++set);
		printf("The minimum number of moves is %d.\n\n", count);
    }
    return 0;
}
