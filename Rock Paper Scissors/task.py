import random
rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''
user_choice = int(input("What do you choose? Type 0 for Rock, 1 for Paper or 2 for Scissors: \n"))
if user_choice == 0:
    print(rock)
elif user_choice == 1:
    print(paper)
elif user_choice == 2:
    print(scissors)
else:
    print("Invalid Choice")
    quit()

game_list = [rock,paper,scissors]
computer_choice = random.choice(game_list)


print(f"Computer chose:\n{computer_choice}")

if (user_choice == 0 and computer_choice == rock) or (user_choice == 1 and computer_choice == paper) or (user_choice == 2 and computer_choice == scissors):
    print("It's a draw!")
elif (user_choice == 0 and computer_choice == paper) or (user_choice == 1 and computer_choice == scissors) or (user_choice == 2 and computer_choice == rock):
    print("You lose!")
else:
    print("You win!")