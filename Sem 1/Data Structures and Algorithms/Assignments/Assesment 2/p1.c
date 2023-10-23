#include <stdio.h>
#include <stdlib.h>

struct Term{
    int coeff;
    int exp;
    struct Term *next;
};

void insert_Term(struct Term **head, int c, int e){
    struct Term *newterm = (struct Term *)malloc(sizeof(struct Term));
    newterm -> coeff = c;
    newterm -> exp = e;
    newterm -> next = NULL;

    if(*head == NULL)
        *head = newterm;
    else{
        struct Term *temp = *head;
        while(temp->next != NULL)
            temp = temp-> next;
        temp -> next = newterm;
    }
}

struct Term* add_poly(struct Term *pol1, struct Term *pol2){
    struct Term *result = NULL;
    
    while(pol1 != NULL && pol2 != NULL){
        if(pol1 -> exp > pol2 -> exp){
            insert_Term(&result, pol1 -> coeff, pol1 -> exp);
            pol1 = pol1 -> next;
        }
        else if(pol1 -> exp < pol2 -> exp){
            insert_Term(&result, pol2 -> coeff, pol2 -> exp);
            pol2 = pol2 -> next;
        }
        else {
            int sumcoeff = pol1 -> coeff + pol2 -> coeff;
            if(sumcoeff != 0)
                insert_Term(&result, sumcoeff, pol1 -> exp);
            pol1 = pol1 -> next;
            pol2 = pol2 -> next;
        }
    }

    while(pol1 != NULL){
        insert_Term(&result, pol1 -> coeff, pol1 -> exp);
        pol1 = pol1 -> next;
    }

    while(pol2 != NULL){
        insert_Term(&result, pol2 -> coeff, pol2 -> exp);
        pol2 = pol2 -> next;
    }

    return result;
}

void diplay(struct Term *head){
    if(head == NULL)
        printf("Empty polynomial");
    else{
        while(head != NULL){
            printf("%dX^%d", head -> coeff, head -> exp);
            if(head -> next != NULL)
                printf("+ ");
            head = head -> next;
        }
    }
}

int main(){

    struct Term *head1 = NULL;
    struct Term *head2 = NULL;
    int e1;
    int e2;
    printf("Enter the highest power of the first Polynomial: ");
    scanf("%d", &e1);
    printf("Enter the highest power of the second Polynomial: ");
    scanf("%d", &e2);
    printf("Enter the terms of the first polynomial:\n");
    while(e1 >= 0){
        int c;
        printf("Coefficient for X^%d: ", e1);
        scanf("%d", &c);
        insert_Term(&head1, c, e1--);
    }
    printf("Enter the terms of the first polynomial:\n");
    while(e2 >= 0){
        int c;
        printf("Coefficient for X^%d: ", e2);
        scanf("%d", &c);
        insert_Term(&head2, c, e2--);
    }
    printf("\nFirst Polynomial:\n");
    diplay(head1);
    printf("\nSecond Polynomial:\n");
    diplay(head2);
    printf("\nResultant Polynomial is:\n");
    struct Term *result = add_poly(head1, head2);
    diplay(result);
    return 0;
}