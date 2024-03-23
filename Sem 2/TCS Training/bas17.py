dic_vals = {10: 'A', 11: 'B', 12: 'C', 13:'D', 14:'E', 15: 'F', 16:'G'}
rev_dic_vals = {'A': 10, 'B':11, 'C': 12, 'D':13, 'E': 14, 'F': 15, 'G': 16}

def calc(n):
    s = ''
    while(n > 0):
        x = n % 17
        if(x > 9):
            x = dic_vals[x]
        s += str(x)
        n //=17

    return s[::-1]


def revcalc(s):
    n = 0
    x = list(s)
    i = len(x) - 1
    j = i
    while(i >= 0):
        pow = 17 ** (j - i)
        c = x[i]
        if c in rev_dic_vals:
            n =  n + rev_dic_vals[c] * pow
        else:
            n = n + int(c) * pow
        i -= 1
    return n
def main():
    num = input("Enter a number: ")
    print('Result: ',revcalc(num))
    
if __name__ == '__main__':
    main()