#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *prev;
    struct Node *next;
};

void findMiddle(struct Node *head){
    struct Node *turtle = head;
    struct Node *rabbit = head;

    while(rabbit != NULL && rabbit -> next != NULL){
        turtle= turtle->next ;
        rabbit = rabbit->next->next;        
    }
    printf("The middle of the list is : %d.", turtle -> data);
}

struct Node* createnode(int data){
    struct Node *newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode -> data = data;
    newnode -> prev = NULL;
    newnode -> next = NULL;
    return newnode;
}

void insert(struct Node **head, int data){
    struct Node *newnode = createnode(data);
    if(*head == NULL){
        *head = newnode;
    }
    else{
        struct Node *current = *head;
        while(current -> next != NULL){
            current = current -> next;
        }
        current -> next = newnode;
        newnode -> prev = current;
    }
}

void display(struct Node *head){
    while(head!=NULL) {
        printf("%d ", head->data );
        head  = head->next;
    }
}
int main(){
    int data;
    printf("Enter the array elements (Press 0 to exit): ");
    scanf("%d", &data);
    struct Node *head = createnode(data);
    while(data != 0){
        scanf("%d",&data );
        if(data != 0)
            insert(&head, data);
        
    }
    printf("List: ");
    display(head);
    printf("\n");
    findMiddle(head);
    return 0;
}