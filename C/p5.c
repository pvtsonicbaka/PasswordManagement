#include <stdio.h>
#include <math.h>


int main(int argc, char const *argv[]){
    double a;
    double b;
    double c;
    printf("Enter the a side ");
    scanf("%lf",&a);
    printf("Enter the  b side ");
    scanf("%lf",&b);
    c = sqrt((a*a)+(b*b));
    printf("The hypotenuse is %lf",c);
    return 0;
    
}