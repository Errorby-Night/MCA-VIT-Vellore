def convert_to_greece_time(day, hours, minutes):
    total_minutes = hours * 60 + minutes
    greece_total_minutes = total_minutes - (2 * 60 + 30)
    if greece_total_minutes < 0:
        greece_total_minutes += 24 * 60
        day = previous_day(day)
    greece_hours = greece_total_minutes // 60
    greece_minutes = greece_total_minutes % 60
    
    return day, greece_hours, greece_minutes

def previous_day(day):
    days_of_week = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    day_index = days_of_week.index(day)
    previous_day_index = (day_index - 1) % 7
    return days_of_week[previous_day_index]


day = input().strip()
hours_input = input().strip()
minutes_input = input().strip()

if hours_input.isdigit() and minutes_input.isdigit():
    hours = int(hours_input)
    minutes = int(minutes_input)
    if 0 <= hours < 24 and 0 <= minutes < 60 and day in ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']:
        greece_day, greece_hours, greece_minutes = convert_to_greece_time(day, hours, minutes)
        print(greece_day)
        print('{:02d}'.format(greece_hours))
        print('{:02d}'.format(greece_minutes))
    else:
        print('Invalid input')
else:
    print('Invalid input')
