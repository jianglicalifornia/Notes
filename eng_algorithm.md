Algorithms
====================

##Sorting
```
//ascending sort.
int bubble_sort(int data[],int size)
{
    int i,j,temp;
    for(i = 0;i < size;i++)
        for(j = size - 1;j > i;j--)
            if(data[j] < data[j-1]){
                temp = data[j];
                data[j] = data[j-1];
                data[j-1] = temp;
            }
    return 0;
}
```