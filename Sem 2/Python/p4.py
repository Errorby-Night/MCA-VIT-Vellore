def characterize_earthquake(n):
    if n < 0:
        print('Invalid input')
    elif n < 5.0:
        print('Little or no damage')
    elif n < 5.5:
        print('Some damage')
    else:
        print('Serious damage')

richter_scale_input = input().strip()
if richter_scale_input.replace('.', '', 1).isdigit():
    richter_scale_number = float(richter_scale_input)
    if richter_scale_number >= 0:
        characterize_earthquake(richter_scale_number)
    else:
        print('Invalid input')
else:
    print('Invalid input')
