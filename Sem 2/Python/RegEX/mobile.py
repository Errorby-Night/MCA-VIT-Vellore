import re

def checkMobile(num):
    reg = '[6789][0-9]{9}'
    if (re.match(reg, num)):
        print(re.sub(reg, num, "ji"))

checkMobile('7318647111')

def checkEmail(email): 
    reg = '[a-z]+[0-9]*@[a-z]+.(com|in)'
    if(re.match(reg, email)):
        print(True)

checkEmail('srijandutta200@gmail.com')
checkEmail('122@gmail.com')