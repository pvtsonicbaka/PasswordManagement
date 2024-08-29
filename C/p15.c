#include <stdio.h>
#include <string.h>
int main(int argc, char const *argv[])
{   
    char a[100]="idk" ;
    char b[100]="really?" ;
    printf("a:%s b:%s\n",a,b);

    char temp[100];
    strcpy(temp,a);
    strcpy(a,b);
    strcpy(b,temp);
    printf("a:%s b:%s\n",a,b);
    
    return 0;
}
