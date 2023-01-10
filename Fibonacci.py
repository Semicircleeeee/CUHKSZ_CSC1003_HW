line_number=int(input())
for i in range (line_number):
    aban=input()
    a=aban.split(',')
    n=int(a[0])
    d=int(a[1])
    if d>n:
        print("invalid")
        continue
    if n==0 or d==0:
        print()
        continue
    else :
        list=[]
        for i in range(n):
            if i==0 or i==1:
                list.append(1)
            else :
                list.append(list[i-1]+list[i-2])
        list1=list.reverse()
        for i in range(d):
            if i==0:
               print(list[i],end="")
            else:
                print(",",list[i],end="")
        print()
    continue

            

          
        
