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

void display(Node *head){
    if(head == NULL)
        printf("The list is empty!!");
    else{
        printf("\nList: ");
        while(head -> next != NULL){
            printf("%d ", head -> data);
            head = head -> next;
        }
    }
}

int main(){
    int val = -1;
    Node *head = NULL;
    Node *newnode = NULL;
    printf("Enter the values (Press 0 to exit):");
    while(val != 0){
        scanf("%d", &val);
        if(head == NULL){
            head = newnode = create_node(val);
        }
        else{
            Node *ptr = head;
            newnode = create_node(val);
            while(ptr -> next != NULL){
                ptr = ptr -> next;
            }
            ptr -> next = newnode;
        }
    }
    display(head);
    return 0;
}