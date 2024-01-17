#include <stdio.h>
#include <stdlib.h>

int H(int x){
    return x%19;
}
int count_free_cell(int a[], int n){
    int c = 0;
    for(int i = 0; i < n; i++)
        if(a[i] == 0)
            c++;
    return c;
}
int main(){

    int a[] = {56, 78, 90, 12, 46, 33, 29, 40, 68, 4, 83};
    int len = sizeof(a) / sizeof(int);
    int *b = (int *)malloc(sizeof(int) * 18);
    for(int i=0 ; i<18 ; ++i){b[i] = 0;}
    for(int i = 0; i < len; i++){
        int h = H(a[i]);
        while(b[h] != 0){
            h++;
        }
        b[h] = a[i];
    }

    printf("The number of free cells are: %d", count_free_cell(b, 18));

    return 0;   
}