# Increment Addition vs Regular Addition Benchmark
I got curious after trolling a bit on reddit with the following code

```
for(int i=0; i<Math.abs(b); i++)
  if(b>0) a++; else a--;
return a;
```

But then after a few messages, I started to wonder what the performance of this thing was actually like.
I hypothesized that the JIT would unroll the loop and then just perform a simple addition.

Here are my results:

```
   Simple addition for 10000 iterations took 587529 nanosecs
Increment addition for 10000 iterations took 12289805 nanosecs

   Simple addition for 100000 iterations took 3905823 nanosecs
Increment addition for 100000 iterations took 12100828 nanosecs

   Simple addition for 1000000 iterations took 7267318 nanosecs
Increment addition for 1000000 iterations took 26599000 nanosecs

   Simple addition for 10000000 iterations took 6780731 nanosecs
Increment addition for 10000000 iterations took 83546515 nanosecs

   Simple addition for 100000000 iterations took 6511016 nanosecs
Increment addition for 100000000 iterations took 681487644 nanosecs
```
The JIT does not optimize the iterations out.

## Run it yourself

```
make
make run
cat result
```
