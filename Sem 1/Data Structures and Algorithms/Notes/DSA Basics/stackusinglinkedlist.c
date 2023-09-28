#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
    int data;
    struct Node *next;
}Node;

Node* create_node(int data){
    Node *newnode = (Node *)malloc(sizeof(Node));
    newnode -> data = data;
    newnode -> next = NULL;
    return newnode;
}

Node* push(Node *head, int data){
    Node *newnode = create_node(data);
    if(head == NULL)
        head = newnode;
    else{
        newnode -> next = head;
        head = newnode;
    }
    return head;
}

Node *pop(Node *head){
    if(head == NULL){
        printf("The stack is empty!\n");
        return NULL;
    }
    else {
        printf("The popped element is: %d\n", head -> data);
    }
    head = head -> next;
    return head;
}

void peek(Node * head){
    printf("The top of the stack is: %d\n", head -> data);
}

void display(Node *head) {
    if (head == NULL) {
        printf("\nStack Empty!!!\n");
    } else {
        Node *current = head; // Create a temporary pointer to traverse the list
        printf("\nStack: ");
        while (current != NULL) {
            printf("%d ", current->data);
            current = current->next; // Move the temporary pointer
        }
        printf("\n");
    }
}


int main(){
    int ch = 0, val;
    Node *head = NULL;
    while(ch != 5){
        printf("======MENU======\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit\n==============\nEnter your choice: ");
        scanf("%d", &ch);
        switch(ch){
            case 1:
                printf("Enter the value you want to push: ");
                scanf("%d", &val);
                head = push(head, val);
                break;
            case 2:
                head = pop(head);
                break;
            case 3:
                peek(head);
                break;
            case 4:
                display(head);
                break;
            default:
                printf("Enter a valid choice!\n");
        }
    }

    return 0;
}