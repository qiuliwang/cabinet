#!/usr/bin/pythonw
# -*- coding: UTF-8 -*-

#import os,urllib2.request,re
import os
import urllib
import re
# import platform
# print platform.python_version()

def Schedule(a,b,c):
    '''''
    a:已经下载的数据块
    b:数据块的大小
    c:远程文件的大小
   '''
    
    print "downing"

url = "http://graduate.cqu.edu.cn/mis/getstuphoto?stuSerial=3256"
# number = 10
#
#tem='%d' %tt

for i in range(00, 99):
    #print i
    tem = '%d' %i
    temp = url + tem
    filename = "/Users/WangQL/Desktop/pic/"+tem+".jpg"
    print temp
    try:    
        urllib.urlretrieve(temp, filename, Schedule)
    except:
        error
    


# urllib.urlretrieve(url, "1.jpg", Schedule)