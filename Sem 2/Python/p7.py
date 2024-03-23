def check_boundaries(row, column):
    return 0 < row < 4 and 0 < column < 4

def check_winning_positions(coin_positions):
    if coin_positions[0][0] == coin_positions[1][0] == coin_positions[2][0]:
        return True
    elif coin_positions[0][1] == coin_positions[1][1] == coin_positions[2][1]:
        return True
    elif (coin_positions[0][0] == coin_positions[1][0] + 1 == coin_positions[2][0] + 2) or \
        (coin_positions[0][0] == coin_positions[1][0] - 1 == coin_positions[2][0] - 2):
        return True
    else:
        return False

# Read input
coin_positions = []
for _ in range(3):
    row = int(input().strip())
    column = int(input().strip())
    if not check_boundaries(row, column):
        print('Invalid input')
        exit()
    coin_positions.append((row, column))

# Check if the player has won
if check_winning_positions(coin_positions):
    print('Won')
else:
    print('Lost')
