def print_diagonal_positions(row, col):
    major_diagonal = []
    minor_diagonal = []


    def is_valid_position(r, c):
        return 1 <= r <= 8 and 1 <= c <= 8


    r, c = row, col
    while is_valid_position(r, c):
        major_diagonal.append((r, c))
        r -= 1
        c += 1


    r, c = row + 1, col - 1
    while is_valid_position(r, c):
        major_diagonal.append((r, c))
        r += 1
        c -= 1


    r, c = row, col
    while is_valid_position(r, c):
        minor_diagonal.append((r, c))
        r -= 1
        c -= 1


    r, c = row + 1, col + 1
    while is_valid_position(r, c):
        minor_diagonal.append((r, c))
        r += 1
        c += 1


    major_diagonal.sort()
    minor_diagonal.sort(reverse=True)


    for r, c in major_diagonal:
        print(r)
        print(c)
    for r, c in minor_diagonal:
        print(r)
        print(c)


valid_input = False
while not valid_input:
    row = input()
    col = input()
    if row.isdigit() and col.isdigit():
        row = int(row)
        col = int(col)
        if 1 <= row <= 8 and 1 <= col <= 8:
           
            print_diagonal_positions(row, col)
            valid_input = True
        else:
            print("Invalid input")
    else:
        print("Invalid input.")
