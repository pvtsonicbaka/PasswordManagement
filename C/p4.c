#include <stdio.h>
#include <math.h>
int main(int argc, char const *argv[])
{   
    const double PI =  3.14;
    double radius ; 
    scanf("%lf",&radius);  
    double area = radius*radius*PI;  
    scanf("%d",&radius);
    printf("area is %lf",area);
    return 0;
}
