dic_vals = {10: 'A', 11: 'B', 12: 'C', 13:'D', 14:'E', 15: 'F', 16:'G'}

def calc(n):
    s = ''
    while(n > 0):
        x = n % 17
        if(x > 9):
            x = dic_vals[x]
        s += str(x)
        n //=17
        
    return s[::-1]

def main():
    num = int(input("Enter a number: "))
    print('Result: ',calc(num))
    
if __name__ == '__main__':
    main()