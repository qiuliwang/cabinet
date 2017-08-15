#!/usr/bin/python

import time
import calendar

print time.time()

localtime = time.localtime(time.time())
print "local time is: ", localtime

localtime = time.asctime(time.localtime(time.time()))
print "local time is: ", localtime

cal = calendar.month(2016, 1)
print cal