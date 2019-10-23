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
   Simple addition for 10000 iterations took 2797957 nanosecs
Increment addition for 10000 iterations took 18517633 nanosecs

   Simple addition for 100000 iterations took 11802824 nanosecs
Increment addition for 100000 iterations took 26309538 nanosecs

   Simple addition for 1000000 iterations took 38033671 nanosecs
Increment addition for 1000000 iterations took 53661604 nanosecs

   Simple addition for 10000000 iterations took 314720960 nanosecs
Increment addition for 10000000 iterations took 337203954 nanosecs

   Simple addition for 100000000 iterations took 2805480623 nanosecs
Increment addition for 100000000 iterations took 2858437194 nanosecs
```


Turns out, after enough iterations, the iterative version is actually on par with the regular version.

I tried to disassemble the JIT code, but I do not have the appropriate disassembler installed and Arch linux doesn't seem to have an easy way to get it install, so I'll just have to leave it as it is for now
