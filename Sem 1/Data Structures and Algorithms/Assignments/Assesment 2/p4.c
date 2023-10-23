#include <stdio.h>

int main() {
    int N;
    printf("Enter the number of working days (N): ");
    scanf("%d", &N);

    int workload[N];

    printf("Enter the workload for each day:\n");
    for (int i = 0; i < N; i++) {
        scanf("%d", &workload[i]);
    }

    int maxRating = 0;
    int currentRating = 0;

    for (int i = 0; i < N; i++) {
        if (workload[i] > 6) {
            currentRating++;
            if (currentRating > maxRating) {
                maxRating = currentRating;
            }
        } else {
            currentRating = 0;
        }
    }

    printf("Employee Rating: %d\n", maxRating);

    return 0;
}
