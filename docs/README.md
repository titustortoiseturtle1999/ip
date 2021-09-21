# AMON GUS
Hi! Thanks for checking us out! Amon Gus is a simple to use __Command Line Interface (CLI)__ application 
that helps you as a crewmate keep track of your tasks!

We recommend users to have basic knowledge of CLI before using Amon Gus.
## Contents
* __Quick Start__
* __Features__
* __Commands__
    1. Help
    2. Add
    3. List
    4. Delete
    5. Find 
    6. Mark
    7. Logo
    8. Bye
* __Command Summary__

## Quick Start
1. To begin, install Java 11 on your computer. 
2. Download the latest release of Duke.jar [here](https://github.com/titustortoiseturtle1999/ip).
3. Place the .jar file to where you would like to it be located. 
4. Using your preferred Command Line Interface, navigate to the directory as specified in step 3.
5. Execute the command `java -jar Duke.jar` to start Amon Gus.
6. Say Hi to Amon Gus!
```
Hello! I'm Amon Gus
--------------------------------------------------------------
................................................................................
..................................... ... ......................................
.........................&@@@@@@@@@@@@@@@@@@@@@@@@@%............................
....................#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.........................
.................@@@@@@@@@@@&%%%%%%%%%%%%%%%%%%%@@@@@@@@@&......................
...............@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@.....................
.............@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@....................
.........%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%&&@@@@@...................
......&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%&@@@@@@..................
....&&&&&&&,*          ,,,,,,,,,,,,,,(&&&&&&&%%%%%%%%%%&&@@@@@/.................
...&&&&&&,              ,,,,,,,,,,,,,,(((&&&&&%%%%%%%%%&&&@@@@@.................
../&&&&&,,*     ,,,,,,,,,,,,,,,,,,,,,,(((&&&&&&%%%%%%%%&&&@@@@@@@@@@@...........
..&&&&&&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(((((&&&&&%%%%%%%%&&&@@@@@@@@@@@@@@@@@.....
..&&&&&%(,,,,,,,,,,,,,,,,,,,,,,,,/((((((((&&&&&%%%%%%%%&&&&@@@@@@##%&@@@@@@@....
..(&&&&&(((((((((/,,,,,,/((((((((((((((((&&&&&%%%%%%%%%&&&&@@@@@%%%%%%%%@@@@@...
...@&&&&&(((((((((((((((((((((((((((((((&&&&&&%%%%%%%%%&&&&@@@@@%%%%%%%%%@@@@...
.....&&&&&&&&&(((((((((((((((((((((((&&&&&&&&%%%%%%%%%%&&&&@@@@@&&&&&&&&&@@@@@..
.......&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&&@@@@..
......,@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&%@@@@..
......#@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&&@@@@#.
......&@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&&@@@@@.
......@@@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&@@@@@&&&&&&&&&&@@@@@.
......@@@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&@@@@@&&&&&&&&&&@@@@@.
......@@@@@&&%%%%%%%%%%%%%%     AMON GUS     %%%%%%%%&&&&&&@@@@@&&&&&&&&&&@@@@@.
......&@@@@%&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&@@@@@&&&&&&&&&&@@@@@.
....../@@@@&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&@@@@@&&&&&&&&&%@@@@@.
.......@@@@@&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&@@@@@&&&&&&&&&@@@@@@.
.......@@@@@&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&&&&&@@@@@&&&&&&&&&@@@@@..
.......@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@@@@@&&&&&&&&&@@@@@..
.......*@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@@@@@&&&&&&&&@@@@@...
```

## Features 
### Types of Tasks
1. __Todo__ - Todos are tasks with just a description.

2. __Deadline__ - Deadlines are tasks with a description and a do by date / time.

3. __Event__ - Events are tasks with a description and an at date / time.


### Saving 
Amon Gus saves your tasks to a created file in `data/amon_gus.txt` so that even when you log off, your tasks 
are still kept tracked of.

##  Commands
### Help
Prints out a list of all commands.
Keyword: `help`

### Add 
Add a task to your list  
* Add a Todo. `todo <description>`
* Add a Deadline. `deadline <description> #<do by>`
* Add an Event. `event <description #<at>`

For example, to add the event: attend CS2113T lecture on Friday from 2-4pm, enter: `event attend CS2113T lecture #Friday 2-4pm`

### List 
List your tasks. Keyword:`list`

Example output:  
```
1. [T] Run  
2. [E] 2113T lecture (at: Friday 2-4pm)  
```

### Delete
Delete a task from your list. Keyword: ```del```  
Usage: ```del <task no.>```  
```<task no.>``` is the number of the task as indicated by the ```list``` command.

### Find 
Find a task containing a search term. Keyword: ```find```  
Usage: ```find <search term>```  

For example, to find tasks containing the word "lecture", enter: ```find lecture```  
Output: 
```
Here are the matching tasks in your list:
1. [E] 2113T lecture (at: Friday 2-4pm)  
2. [D] watch ST2334 lecture (by: Tuesday 3pm)  
```
! Note: search terms are **C**ase **S**ensitive.

### Mark
Mark a task as done. Keyword: `done`  
Usage: `done <task no.>`

Mark a task as not done. Keyword `undo`   
Usage: `undo <task no.>`

`<task no.>` is the number of the task as indicated by the ```list``` command.  
! Note: Tasks are marked as not done by default.

### Logo
Display the Amon Gus logo. Keyword: `logo`

### Bye
Exit the Amon Gus program. Keyword: `bye`  
! Note: Your tasks are automatically saved.

## Command Summary  
    
| **Command** | **Usage**| 
| ------- | -----| 
| Add a todo | `todo <description>`| 
| Add a deadline | `deadline <description> #<do by>`| 
| Add an event | `event <description #<at>`| 
| List all tasks | `list`| 
| Delete a task | `del <task no.>`| 
| Find a task | `find <search term>`| 
| Mark a task as done | `done <task no.>`| 
| Mark a task as not done | `undo <task no.>`| 
| Display the Amon Gus logo | `logo`| 
| Exit Amon Gus | `bye`| 


