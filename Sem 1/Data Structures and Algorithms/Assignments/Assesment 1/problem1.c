#include <stdio.h>
#include <stdlib.h>

int isPrime(int n) {
    int i, c = 0;
    for (i = 2; i <= n / 2; i++) {
        if (n % i == 0)
            c++;
    }
    if (c > 1 || n == 1)
        return 0;
    else
        return 1;
}

int main() {
    int n = 1, i = 0, j = 0, k;         // Declaring necessary variables
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    k = n - 1;
    int *arr = (int *)malloc(sizeof(int) * n);
    int *stack = (int *)malloc(sizeof(int) * n);
    int *queue = (int *)malloc(sizeof(int) * n);

    // Entering elements
    printf("Enter the array elements: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        if (isPrime(arr[i]) == 1) {
            queue[j] = arr[i];
            j++;
        } else {
            stack[k] = arr[i];
            k--;
        }
    }
    // Display
    printf("Queue: ");
    for (i = 0; i < j; i++) {
        printf("%d ", queue[i]);
    }
    printf("\nStack: ");
    for (i = n - 1; i > k; i--) {
        printf("%d ", stack[i]);
    }
    // Freeing the memory
    free(arr);
    free(stack);
    free(queue);

    return 0;
}
