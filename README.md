# MovieScheduler

# Presentation: 
https://www.canva.com/design/DAGktiargfs/Mc7AAskhU5S4mZf_WrXw4g/edit?utm_content=DAGktiargfs&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton


# Overview

This is a simple Java project I made to manage movie screenings for different cinemas. The app works from the command line and lets users add, view, update, and delete screenings. It also supports saving and loading screenings from a file, and importing data from a CSV file. Everything is stored so you don’t lose it when you close the app.

# Features

Add Screening: Add a movie with title, date, time, and cinema.

View Screenings: Show a list of all screenings.

Update Screening: Change an existing screening's data.

Delete Screening: Remove a screening from the list.

Save to File: Save the current screenings to a .txt file.

Load from File: Load previously saved data from a file.

Import from CSV: Add multiple screenings from a .csv file.


# Functions and Methods

1. addScreening()

Asks the user for movie title, date, time, and cinema.

Checks that all inputs are valid.

Adds the screening to the list.

2. viewScreenings()

Shows all added screenings with full info.

3. updateScreening()

Lets the user choose a screening and change its values.

4. deleteScreening()

Asks for the screening number and removes it.

5. saveToFile()

Saves the list of screenings to screenings.txt.

6. loadFromFile()

Loads and displays previously saved screenings from the file.

7. importFromCSV()

Reads from screenings.csv and adds each line to the list.

# File Format

Text file: screenings.txt stores screenings like this:

Movie Title,YYYY-MM-DD,HH:MM,City Cinema

CSV file: screenings.csv follows the same format. Make sure values are comma-separated.

# Input Validation

Year must be valid and not in the past.

Month must be 1–12.

Day must match real calendar days.

Time must be HH:mm format.

Keeps asking until correct data is entered.

 # Outputs and Test Cases

 Test 1: Add a Valid Screening

Input:


Avengers
2025
05
15
23:00
Royal Cinema

Expected: Screening is added to the list.

![image](https://github.com/user-attachments/assets/54f6e85e-61e0-4812-a368-8706542290d4)


 Test 2: Invalid Date

Input:


Batman
2025
02
30
14:00
Grand Cinema

Expected: "Invalid date. Please try again."

 Test 3: View Screenings

![image](https://github.com/user-attachments/assets/84be3f3e-48fc-4769-aff4-b0d438568ebe)

Input: 2
Expected: Displays all added screenings.

 Test 4: Update Screening

Input: 3 → Selects one → Enters new info
Expected: Screening is updated.

 Test 5: Delete Screening

Input: 4 → Selects one to delete
Expected: Screening removed.

 Test 6: Save to File
![image](https://github.com/user-attachments/assets/de410caa-91d0-4570-87bd-ba47118ab45b)


Input: 5
Expected: screenings.txt created or updated.

 Test 7: Load From File

Input: 6
Expected: Reads and shows data from file.

 Test 8: Import From CSV
 ![image](https://github.com/user-attachments/assets/ed8b1a47-5ba3-460d-82b1-692e5e0474ff)


Input: 7
Expected: Screenings from screenings.csv added.


# Issues Faced

Getting correct input for date and time was hard.

Had to loop inputs many times for validation.

CSV import needed careful parsing and line checks.



# Final Notes

This project helped me understand how to handle files, input validation, and design simple CLI tools in Java. I used ArrayList and string arrays to store data, and kept the code inside the main method to keep it simple for now. It's a complete CLI-based schedule manager for cinemas.

