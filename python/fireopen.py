#!/usr/bin/python

obj = open("/Users/WangQL/Desktop/test.txt", "a")
print obj.name
print obj.mode
#print obj.read(10)
obj.write("inner pease")
obj.close()
