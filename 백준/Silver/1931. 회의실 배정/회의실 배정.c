#include <stdio.h>
#include <stdlib.h>

int     comparator(const void *a, const void *b)
{
        const int       *num_a;
        const int       *num_b;

        num_a = *(const int **) a;
        num_b = *(const int **) b;
        if (num_a[1] == num_b[1])
                return (num_a[0] - num_b[0]);
        else
                return (num_a[1] - num_b[1]);
}

int     count_max(int **arr, int num_rows)
{
        int     end_time;
        int     i;
        int     counter;

        i = 0;
        counter = 0;
        end_time = 0;
        while (i < num_rows)
        {
                if (arr[i][0] >= end_time)
                {
                        counter++;
                        end_time = arr[i][1];
                }
                i++;
        }
        return (counter);
}

int     main(void)
{
        int     n;
        int     **arr;
        int     i;
        int     answer;

        scanf("%d", &n);
        i = 0;
        arr = (int **)malloc(sizeof(int *) * n);
        while (i < n)
        {
                arr[i] = (int *)malloc(sizeof(int) * 2);
                scanf("%d", &arr[i][0]);
                scanf("%d", &arr[i][1]);
                i++;
        }
        qsort(arr, n, sizeof(arr[0]), comparator);
        answer = count_max(arr, n);
        printf("%d", answer);
}