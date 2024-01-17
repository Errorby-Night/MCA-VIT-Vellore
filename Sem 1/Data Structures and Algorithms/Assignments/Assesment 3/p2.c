#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *left;
    struct Node *right;
};

int max(int a, int b) {
    return (a > b) ? a : b;
}

void inorder(struct Node *root){
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

struct Node* createNode(int data){
    struct Node* node = malloc(sizeof(struct Node));
    node -> left = NULL;
    node -> right = NULL;
    node -> data = data;
    return(node);
}

struct Node* insertNode(struct Node *root, int data){
    
    struct Node *newNode = createNode(data);

    if(root == NULL)
       root = newNode;
    else if(data < root -> data)
        root -> left = insertNode(root -> left, data);
    else if(data > root -> data)
        root -> right = insertNode(root -> right, data);
    
    return root;
}

int height(struct Node* root) {
    if (root == NULL) {
        return 0;
    } else {
        int leftHeight = height(root->left);
        int rightHeight = height(root->right);

        return 1 + max(leftHeight, rightHeight);
    }
}

int main(){

    struct Node *root = NULL;
    int ch = 0;
    while(ch != 4){
        printf("----MENU----\n1. Insert\n2. Display\n3. Display Height\n4. Exit\n------------\nEnter your choice: ");
        scanf("%d", &ch);

        if(ch == 1){
            int n;
            printf("\nEnter the value to be inserted: ");
            scanf("%d",&n);
            root = insertNode(root, n);
        }
        else if(ch == 2){
            inorder(root);
            printf("\n");
        }
        else if(ch == 3){
            int h = height(root);
            printf("The height of the tree is: %d\n", h);
        }
    }


    return 0;
}