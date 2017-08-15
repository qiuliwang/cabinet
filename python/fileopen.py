#!/usr/bin/python

import time

fo = open("foo.txt", "wb")

fo.write(str(time.time()))

fo.close()

fo = open("foo.txt", "r")
print(fo.read())
fo.close();