n = int(input())
f = 1
marks = []
for i in range(n):
    mark = int(input())
    if mark >= 0 and mark <= 100:
        marks.append(mark)
    else:
        print("Invalid Input")
        f = 0
        break
if f == 1:
    print(f'{sum(marks) / len(marks):.2f}')