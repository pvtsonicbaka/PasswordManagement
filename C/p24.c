#include <stdio.h>
int main(int argc, char const *argv[])
{
    FILE *pf = fopen("test.txt","w");

    fprintf(pf,"HelloWordl");

    fclose(pf);


    return 0;
}
