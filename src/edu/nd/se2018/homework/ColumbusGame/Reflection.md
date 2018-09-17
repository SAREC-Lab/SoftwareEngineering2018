Much of what I liked about the design of my solution really revolves around actually enjoying the deployment of the game itself: 
although it is a very simple event driven program, with a simpler yet GUI, it still gives me the same childhood happiness that I 
had when I wrote my first hello world.  A lot of this stems from how quickly you can see and update changes, and how much video 
games drove my love for coding.  Though that does not speak directly to the actual design of the classes, I think it more so 
speaks to my learning process: these designs are still novel to me and they feel like they are being discovered, and that’s still 
incredibly fun to me.  As far as the actual designs are concerned, I really liked the communication between observer and observed 
objects (although this wasn’t truly implemented by me): the modularity of the events (i.e. the observer simply knows to update 
and a separate event queue need not be implemented (at least directly) by me) is very nice, and the event loop contained within 
OceanExplorer was straight forward enough because of the modularity of the underlying “pieces” (i.e. Ship, PirateShip, OceanMap).  
As far as the first stretch is concerned, the implementation would be simple enough in containing it all within two while loops, 
that when the button is pressed, breaks out of the first loop, causing the outer loop to iterate and recall the initialization 
methods for the game and creating a new game.  The replacement of ocean/land tiles with ocean/land images would also be fairly 
straightforward, as instead of them simple being a rectangle class we could add an imageview class of that size, and then 
subsequently utilize the same methods used to initialize the ship images and do the same in the board initialization loop.
