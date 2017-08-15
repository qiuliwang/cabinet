#!/usr/bin/python
#Fibonacci sequence

def fib1(n):
    a, b = 1, 1
    print a, b
    for i in range(n - 1):
        t = a
        a = b
        b = t + a
        print b
        
def fib2(n):
    if(n == 1) or (n == 2):
        return 1        
    return fib2(n-1)+fib2(n-2)

print fib2(6)