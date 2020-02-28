def display (dict): #making the function
    more = True
    while more == True: #makes sure it runs continuously
        player = (input("What player do you want to learn about? If you are done, type 'done'.").lower()) #makes input into lowercase
        if player == 'done': #stops when they enter "done"
            more = False
        if ' ' in player:# splits up names if they enter both first and last name, allowing me to search by only first name
          player = player.split(' ')
        if type(player) == str: #checks if they entered only the first name (didn't need to split)
            for m in dict: #for each element in the dictionary
                if player in m: #checks if the user input is in the dictionary)
                    print(player.capitalize(), 'is a', (dict[m][1]), 'year old', (dict[m][0]), #if it is, prints the info
                          'player for the Houston Outlaws.', 'He is particularly famous for his', (dict[m][2]))
        if type(player) == list: #checks if they entered both first and last names (did split)
            for m in dict: #rest is same as above
                if player[0] in m:
                    print(str(player[0]).capitalize(), 'is a', (dict[m][1]), 'year old', (dict[m][0]),
                    'player for the Houston Outlaws.', 'He is particularly famous for his', (dict[m][2]))
                    #this info may look weird, but I assure you it makes sense if you're a fan of the team.
                    #It's an esports team for the video game: Overwatch


def main():
    names = [('jiri', 'masalin'), ('jacob', 'lyon'), ('matt', 'iorio'), ('austin', 'wilmot'), ('shane', 'flaherty')]
    role  = ['DPS', 'DPS', 'Tank', 'Tank', 'Support']
    age   = [25, 23, 30, 21, 25]
    hero  = ['Widowmaker', 'Junkrat', 'D.Va', 'Winston', 'Ana']
    #Tuples with the info


    outlaws = {} #empty dictionary
    count = 0
    for i in names:
          outlaws[i] = role[count], age[count], hero[count]
          count += 1

    #Creates dictionary with the info

    display(outlaws)

if __name__ == '__main__':
    main()