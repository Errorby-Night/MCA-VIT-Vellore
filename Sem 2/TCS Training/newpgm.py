def sum_of_all_possible(num):
    num_str = str(num)
    l = len(num_str)
    total_sum = 0
    i = 1
    for i in range(1, l + 1):
        for j in range(l - i + 1):
            substring = num_str[j:j + i]
            total_sum += int(substring)
    return total_sum

if __name__ == "__main__":
    num = int(input("Enter the number: "))
    print("The sum of all possible numbers is:", sum_of_all_possible(num))
