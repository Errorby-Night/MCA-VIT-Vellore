#include <stdio.h>
#include <stdlib.h>

typedef struct stack{
    int data;
    struct stack *next;
}stacker;


stacker* createnode(int data){
    stacker *temp = (stacker *)malloc(sizeof(stacker));
    temp -> data = data;
    temp -> next = NULL;
    return temp;
}

stacker* push(stacker* top, int data){
    if(!top)
        return;
    stacker *newer = createnode(data);
    newer -> next = top;
    top = newer;
    return top;
}

stacker* pop(stacker *top){
    
}