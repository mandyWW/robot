# Robot
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.
The robot is free to roam around the surface of the table, but cannot fall to destruction. Any movement that would result in the robot falling from the table are prevented, however further valid movement commands are still allowed.

## Application design
See https://github.com/mandyWW/robot/wiki/Robot-Application-Design

## How to build the application
- [ ] TODO - _Add build instructions_

## How to play
Enter commands (via stdin) in the following form:

* PLACE X,Y,F
* MOVE
* LEFT
* RIGHT
* REPORT

PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.<br>  
The origin (0,0) is considered to be the SOUTH WEST most corner.<br>  
The first valid command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command.<br>   
The application will discard all commands in the sequence until a valid PLACE command has been executed.<br>  
MOVE will move the toy robot one unit forward in the compassDirection it is currently facing.<br>
LEFT and RIGHT will rotate the robot 90 degrees in the specified compassDirection without changing the position of the robot.<br>
REPORT will output the X,Y and F of the robot.<br>  

### Example input and output
* PLACE 0,0,NORTH
* MOVE
* REPORT
* Output: 0,1,NORTH
* PLACE 0,0,NORTH
* LEFT
* REPORT
* Output: 0,0,WEST
* PLACE 1,2,EAST
* MOVE
* MOVE
* LEFT
* MOVE
* REPORT
* Output: 3,3,NORTH
