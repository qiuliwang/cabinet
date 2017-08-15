#!/usr/bin/python

# var = "Hello World!"
#
# for let in var:
#     print let

var = "hello"
for i in var:
    for j in var:
        print i
    print j
    
a = 10
b = 0
while(a>0):
    while(b<10):
        print b
        b = b + 1
    print a
    a = a - 1
        