from datetime import datetime

def isUnique(n):
    x = str(n)
    l = len(x)
    unique_chars = set(x)
    return len(unique_chars) == l

def run_in_range(start, end):
    result = []
    while(start <= end):
        if isUnique(start):
            result.append(start)
        start += 1
    return result

def main():
    start = int(input("Enter the starting range: "))
    end = int(input("Enter the end: "))
    start_time = datetime.now()
    result = run_in_range(start, end)
    end_time = datetime.now()
    print(len(result))
    print("Time taken: ", end_time - start_time)


if __name__ == "__main__":
    main()