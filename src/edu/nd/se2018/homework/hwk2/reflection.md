When designing my solution, I wanted to keep the actual racer (horse) implementation/code as simple as possible, having it be a modular 
piece utilized by race rather than doing a majority of the work in that class.  I chose to implement a strategy interface (Strategy) 
with a context class (Horse) in order to limit both duplicated code and “workload” done within the actual racer class.  I then had 
a worker, or overseer, class (Race) which would manage the actual running of the simulation, and which would house the control loop 
for the race.  In housing this control loop separate of the racer classes, I felt it logically mimicked what was actually happening 
in a real race: each racer operates on its own (individual instances of a class) but are all participating in the same race context 
(control class Race) and are subject to that race and that race only (i.e. not all horses need finish before the race is concluded).  
In order to quickly handle distance tracking and speed manipulation, I utilized two HashMaps, linked by their key sets (both maps were 
linked to the same horse name as their key), in order to update overall position based on elapsed time, and access the strategy and 
subsequently the “advance” method (runLap).  Since the workload (control loop, strategy parsing/setting, etc.) was all contained to 
the Race class, the implementation of the strategies and subsequently the context class was minimal, allowing for easy understanding 
and manipulation to properly run the race within the control class.
