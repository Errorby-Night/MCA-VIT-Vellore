#include <stdio.h>
#include <stdlib.h>

int main(){
    int n, front = -1, rear = -1, ch = 0, val;
    printf("Enter the max size of the queue: ");
    scanf("%d", &n);
    int *queue = (int *)malloc(sizeof(int) * n);
    while(ch != 4){
        printf("======MENU======\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n==============\nEnter your choice: ");
        scanf("%d", &ch);
        switch(ch){
            case 1:
                printf("Enter the value you want to enqueue: ");
                scanf("%d", &val);
                if (rear == n - 1) {
                    printf("The queue is full!!\n");
                } else {
                    if (front == -1 && rear == -1) {
                        front++;
                        rear++;
                    } else {
                        rear++;
                    }
                    queue[rear] = val;
                }
                break;

            case 2:
                if(front == rear){
                    printf("The queue is empty!!\n");
                    front = rear = -1;
                }
                else{
                    printf("The dequeued element is: %d\n", queue[front++]);
                }
                break;
            case 3:
                if (front == -1 || front > rear) {
                    printf("\nQueue is empty\n");
                } else {
                    printf("\nQueue: ");
                    for (int i = front; i <= rear; i++) {
                        printf("%d ", queue[i]);
                    }
                    printf("\n");
                }
                break;


        }
    }
}