#!/usr/bin/python
#-*- coding: UTF-8 -*-

import math
for i in range(10000000):
    x = int(math.sqrt(i + 100))
    if(x * x == i + 100):
        y = int(math.sqrt(i + 268))
        if(y * y == i + 268):
            print i