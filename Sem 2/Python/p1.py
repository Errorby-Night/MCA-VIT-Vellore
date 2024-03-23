def main():
    f = 1
    prices = []
    print()
    for i in range(5):
        cost = int(input())
        if cost > 0:
            prices.append(cost)
        else:
            f = 0
    if f  == 1:
        print(min(prices))
    else:
        print("Invalid Input")

if __name__ == "__main__":
    main()