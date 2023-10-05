#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
    int data;
    struct Node *next;
    struct Node *prev;
}Node;

Node* create_node(int data){
    Node *newnode = (Node *)malloc(sizeof(Node));
    newnode -> data = data;
    newnode -> next = NULL;
    newnode -> prev = NULL;
    return newnode;
}

Node* insertion_at_begining(Node *head, int data){
    Node *newnode = create_node(data);
    if(head == NULL){
        head = newnode;
    }
    else{
        newnode -> next = head;
        head -> prev = newnode;
        head = newnode;
    }
    return head;
}
