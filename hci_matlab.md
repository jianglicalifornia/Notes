Matlab
===========


## Plot


## Filter

```
Example: Take a 10 element moving average.

x = rand(1e3,1);
n = 10;
x_moving_average = filter(ones(1,n)/n,1,x);
```