#include <stdio.h>
void Hello(char[],int);
int main(int argc, char const *argv[])
{
    int age = 21;
    char name[] = "sajjad";
    Hello(name);
        
    return 0;
}
 void Hello(char name[],int age){


    
    printf("HIii my name is %s\n",name);
    printf("I am %d years old",age);
 }