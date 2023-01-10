a=input()
list=a.split(" ")
m=int(list[0])
n=int(list[1])
l=int(list[2])
matrix1=[]
matrix2=[]
matrix3=[]
for i in range(m):
    pivot=input()
    matrix1.append(pivot.split(" "))
for i in range(n):
    pivot=input()
    matrix2.append(pivot.split(" "))
for i in range(m):
    matrix3.append([])
for i in range(m):
    for j in range(l):
        pivot=0
        for k in range(n):
            pivot+=int(matrix1[i][k])*int(matrix2[k][j])
        matrix3[i].append(pivot)
        pivot=0
print(m,l,sep=" ")
for i in range(m):
    for j in range(l):
        if j==l-1:
            print(matrix3[i][j])
        else:
            print(matrix3[i][j],end=" ")

            
            

        