#include <stdio.h>
#include <stdlib.h>

int push(int top){
    return ++top;
}
int pop(int top){
    return --top;
}

void peek(int arr[], int top){
    printf("\nThe top of the stack is: %d\n", arr[top]);
}

void display(int arr[], int top, int n){
    int  i = 0;
    if(top == n-1)
        printf("\nThe stack is full!\n");
    else if(top == -1)
        printf("\nThe stack is empty!!\n");
    else{
        printf("Stack: ");
        for(i = top; i >= 0; i--){
            printf("%d ", arr[i]);
        }
        printf("\n");
    }
}

int main(){
    int n, top = -1, ch = 0, val;
    printf("Enter the max size of the stack: ");
    scanf("%d", &n);
    int *stack = (int *)malloc(sizeof(int) * n);
    
    while(ch != 5){
        printf("======MENU======\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit\n==============\nEnter your choice: ");
        scanf("%d", &ch);
        if(ch == 1){
            if(top == n-1){
                display(stack, top, n);
                continue;
            }
            printf("\nEnter the value you want to push: ");
            scanf("%d", &val);
            top = push(top);
            stack[top] = val;
        }
        if(ch == 2){
            if(top == -1){
                display(stack, top, n);
                continue;
            }
            printf("\nThe popped value is: %d\n", stack[top]);
            top = pop(top);
        }
        if(ch == 3)
            peek(stack, top);
        if(ch == 4)
            display(stack, top, n);
    }
    return 0;
}