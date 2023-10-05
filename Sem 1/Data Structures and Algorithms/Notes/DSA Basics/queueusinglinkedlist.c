#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
    int data;
    struct Node *next;
}Node;


typedef struct Queue{
    Node *front;
    Node *rear;
}Queue;


Node* create_node(int data){
    Node *newnode = (Node *)malloc(sizeof(Node));
    if (newnode != NULL) {
        newnode->data = data; // Corrected assignment
        newnode->next = NULL;
    }
    return newnode;
}

void enqueue(Queue *queue, int data){
    Node *newnode = create_node(data);
    if (newnode == NULL) {
        printf("Memory allocation failed for new node.\n");
        return;
    }

    if(queue->front == NULL && queue->rear == NULL){
        queue->front = queue->rear = newnode;
    }
    else{
        queue->rear->next = newnode;
        queue->rear = newnode;
    }
}


void dequeue(Queue *queue){
    Node *temp = queue -> front;
    if(queue -> front == NULL)
        printf("The Queue is empty!!\n");
    else{
        printf("The dequeued element is: %d\n", queue -> front ->data);
        if(queue -> front ==  queue -> rear)
            queue -> front = queue -> rear = NULL;
        else{
            queue -> front = queue -> front -> next;
        }
    }
    free(temp);
}

void display(Queue *queue){
    Node *front = queue->front;

    if (!front) {
        printf("\nThe Queue is Empty !!\n");
    } else {
        printf("Queue: ");
        while (front != NULL) {
            printf("%d ", front->data);
            front = front->next;
        }
        printf("\n");
    }
}


int main(){
    Queue *queue = (Queue *)malloc(sizeof(Queue));
    int ch = 0, val;
    while(ch != 4){
        printf("======MENU======\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n==============\nEnter your choice: ");
        scanf("%d", &ch);
        switch(ch){
            case 1:
                printf("Enter the value you want to enqueue: ");
                scanf("%d", &val);
                enqueue(queue, val);
                break;
            case 2:
                dequeue(queue);
                break;;
            case 3:
                display(queue);
                break;
            case 4:
                break;
            default:
                printf("Enter a valid choice!!");
        }
    }
    free(queue);
    return 0;
}