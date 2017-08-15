#!/usr/bin/python
# -*- coding: UTF-8 -*-

#输入三个整数x,y,z，请把这三个数由小到大输出。

x = int(raw_input('input x:\n'))
y = int(raw_input('input y:\n'))
z = int(raw_input('input z:\n'))

print x, y, z

if(x > y):
    t = x
    x = y
    y = t
if(y > z):
    t = y
    y = z
    z = t
if(x > y):
    t = x
    x = y
    y = t
print x, y, z