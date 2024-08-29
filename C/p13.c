#include <stdio.h>
int main(int argc, char const *argv[])
{
    int a[] = {1,2,3,4,5,6};
    printf("size of array in bytes is %d:\n",sizeof(a));
    for(int i = 0 ; i< sizeof(a)/sizeof(a[0]);i++){
        printf("%d  ",a[i]);
    }
    printf("\n");

    int ab [][3]  = {{1,2,3},{4,5,6}};
    int row = sizeof(ab)/sizeof(ab[0]) ;
    int cols =sizeof(ab[0])/sizeof(ab[0][0])  ;
    for (int i = 0; i < row ; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            printf("%d ",ab[i][j]);
        }
        printf("\n");
        /* code */
    }
    
    return 0;
}
