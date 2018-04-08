#include <stdio.h>

int main()
{
    int k=1;
    for(k; k < 100; k ++)
    {
        int temp1 = k * k;
        int temp2 = k;
        while(temp2 > 1)
        {
            int inner1 = temp1 % 10;
            int inner2 = temp2 % 10;

            if(inner1 == inner2)
            {
                temp1 /= 10;
                temp2 /= 10;
            }
            else 
                break;
        }
        if(temp2 == 0)
        {
            printf("%d \n", k);
        }
    }
    printf("enter any key to exit\n");
    getchar();
    return 0;
}
