def convert_to_IST(day, hours, minutes):
    if not (0 <= hours < 24) or not (0 <= minutes < 60):
        print('Invalid input')
        return
    

    hours += 5
    minutes += 30


    if minutes >= 60:
        minutes -= 60
        hours += 1
    if hours >= 24:
        hours -= 24

        days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
        day_index = (days.index(day) + 1) % 7
        day = days[day_index]
    

    print(day)
    print(hours)
    print(minutes)

day = input().strip()
hours_input = input().strip()
minutes_input = input().strip()
if hours_input.isdigit() and minutes_input.isdigit():
    hours = int(hours_input)
    minutes = int(minutes_input)
    convert_to_IST(day, hours, minutes)
else:
    print('Invalid input')
