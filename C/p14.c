#include <stdio.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    char c[][10] = {"Sajjad","Khan","pathan"};
    strcpy(c[0],"My");
    for(int i =0 ;i<sizeof(c)/sizeof(c[0]);i++){
        printf("%s ",c[i]);
    }
    return 0;
}
