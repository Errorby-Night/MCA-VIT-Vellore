#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

void sortNumbers(int a[], int n) {
    for (int i = 0; i < n - 1; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (a[j] > a[i]) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
    }
}

void sortCharacters(char a[], int n) {
    for (int i = 0; i < n - 1; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (tolower(a[j]) < tolower(a[i])) {
                char temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
    }
}

int main() {
    char input[100];
    int numbers[100];
    char characters[100];
    int numCount = 0;
    int charCount = 0;
    int k = 0;
    printf("Enter elements (separated by commas): ");
    fgets(input, sizeof(input), stdin);

    char* token = strtok(input, ",");
    while (token != NULL) {
        if (isdigit(token[0])) {
            numbers[numCount++] = atoi(token);
            input[k] = '*';
            k++;

        } else {
            characters[charCount++] = token[0];
            input[k] = '.';
            k++;
        }
        token = strtok(NULL, ",");
    }
    sortNumbers(numbers, numCount);
    sortCharacters(characters, charCount);

    int numIndex = 0;
    int charIndex = 0;
    k = 0;
    for (int i = 0; i < numCount + charCount && k < (numCount + charCount); i++) {
        if(input[i] == '*' && numIndex < numCount){
            printf("%d", numbers[numIndex++]);
        }
        if(input[i] == '.' && charIndex < charCount){
            printf("%c", characters[charIndex++]);
        }
        if(i != (numCount + charCount - 1))
            printf(", ");

    }

    printf("\n");

    return 0;
}
