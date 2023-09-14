#include <stdio.h>
#include <stdlib.h>

typedef struct stack{
    int data;
    struct stack *prev;
}stack;

stack * push(stack* top, int n){
    if(top == NULL){
        stack *newtop = (stack *)malloc(sizeof(stack));
        newtop -> data = n;
        newtop -> prev = NULL;
        return newtop;
    }
    else{
        stack *temp = (stack *)malloc(sizeof(stack));
        if(!temp)
            printf("Memory not allocated");
        temp -> data = n;
        temp -> prev = top;
        top = temp;
    }
    return top;
}

void display(stack* top){
    stack *check = top;
    while(check -> prev != NULL){
        printf("%d ", check -> data);
        check = check -> prev;
    }
}
int pop(stack* top){
    if(top == NULL)
        return -999;
    int data = top -> data;
    top = top -> prev;
    return data;
}

int main(){

    stack *top = (stack *)malloc(sizeof(stack));
    stack *s2 = (stack *) malloc(sizeof(stack));
    printf("Enter the queue elements (Press -1 to stop): ");
    int n = 0;
    while(n == -1){
        scanf("%d", &n);
        top = push(top, n);
    }
    printf("\nQueue Contents: ");
    while(top != NULL){
        s2 = push(s2, pop(top));
    }
    while(s2 != NULL){
        printf("%d ",pop(s2));
    }

    return 0;
}