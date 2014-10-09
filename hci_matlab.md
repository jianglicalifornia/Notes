Matlab
===========

## Common code fragment


## Plot
[Display higher precision in matlab plot](http://stackoverflow.com/questions/5961034/how-can-i-display-numbers-with-higher-precision-in-a-matlab-data-cursor)

```
/Users/haojian/Documents/MATLAB_R2013b.app/toolbox/matlab/graphics/@graphics/@datacursor
```

## Filter

```
Example: Take a 10 element moving average.

x = rand(1e3,1);
n = 10;
x_moving_average = filter(ones(1,n)/n,1,x);
```