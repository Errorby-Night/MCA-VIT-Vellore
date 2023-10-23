#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;
    return newNode;
}

void insertAtBeginning(struct Node** head, int data) {
    struct Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        (*head)->next = *head;
        (*head)->prev = *head;
    } else {
        newNode->next = *head;
        newNode->prev = (*head)->prev;
        (*head)->prev->next = newNode;
        (*head)->prev = newNode;
        *head = newNode;
    }
}

void insertAtEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        (*head)->next = *head;
        (*head)->prev = *head;
    } else {
        newNode->next = *head;
        newNode->prev = (*head)->prev;
        (*head)->prev->next = newNode;
        (*head)->prev = newNode;
    }
}

void deleteNode(struct Node** head, int key) {
    if (*head == NULL)
        return;
    struct Node* current = *head;
    struct Node* toDelete = NULL;
    do {
        if (current->data == key) {
            toDelete = current;
            break;
        }
        current = current->next;
    } while (current != *head);

    if (toDelete == NULL)
        return;

    if (toDelete->next == toDelete && toDelete->prev == toDelete) {
        *head = NULL;
        free(toDelete);
    } else {
        toDelete->prev->next = toDelete->next;
        toDelete->next->prev = toDelete->prev;
        if (toDelete == *head)
            *head = toDelete->next;
        free(toDelete);
    }
}
void display(struct Node* head) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* current = head;
    
    do {
        printf("%d -> ", current->data);
        current = current->next;
    } while (current != head);

    printf(" (Back to head)\n");
}

int main() {
    struct Node* head = NULL;
    int choice, data, key;

    do {
        printf("\nDoubly Circular Linked List Operations\n");
        printf("1. Insert at the beginning\n");
        printf("2. Insert at the end\n");
        printf("3. Delete a node\n");
        printf("4. Display the list\n");
        printf("5. Exit\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter data to insert: ");
                scanf("%d", &data);
                insertAtBeginning(&head, data);
                break;

            case 2:
                printf("Enter data to insert: ");
                scanf("%d", &data);
                insertAtEnd(&head, data);
                break;

            case 3:
                printf("Enter key to delete: ");
                scanf("%d", &key);
                deleteNode(&head, key);
                break;

            case 4:
                display(head);
                break;

            case 5:
                printf("Exiting the program.\n");
                break;

            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 5);

    return 0;
}
