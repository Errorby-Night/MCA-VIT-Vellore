h = int(input())
c = float(input())
ts = int(input())
g = 0
if h > 60 and c < 0.9 and ts > 6000:
    g = 10
elif h > 60 and c < 0.9 and ts < 6000:
    g = 9
elif h < 60 and ts > 6000 and c < 0.9:
    g = 8
print(g)