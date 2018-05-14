'''
May 8 2018
'''
import numpy

# init
N = 10
xu = 3.0
xl = -1.0

# two list for x and p
x_list = []
p_list = []

# first step
x1 = (xu + xl) / 2
x_list.append(x1)
y1 = numpy.random.normal(0,1)

if x1 < y1:
    p1 = 0
else:
    p1 = 1

p_list.append(p1)

xi = x1
pi = p1
while len(x_list) < N:
    # count0 and count1: counts for 1 and 0 in p
    count0 = 0
    count1 = 0
    len_of_i = 0
    
    temp = 0
    while temp < len(p_list)

    for i in p_list:
        if i == 0:
            count0 = count0 + 1
        else:
            count1 = count1 + 1
        if count0 == count1:
            # if equal, break and set xii
            print("equ")
            xii = x_list[len_of_i]
            break
        len_of_i = len_of_i + 1
    print("count:", count0, count1)
    # if count0 != count1, set xii
    if len_of_i == len(p_list):
        if pi == 0:
            xii = xu
        else:
            xii = xl

    # set xi  
    xi = (xi + xii)/2
    yi = numpy.random.normal(0,1) 
    print(xi, xii, yi)
    if xi < yi:
        pi = 0
    else:
        pi = 1

    x_list.append(xi)
    p_list.append(pi)
    
print(x_list)
print(p_list)