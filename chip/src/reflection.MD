The main mindset behind my design was to have most of the “work” done in a concise area without much repeated work/logic (isn’t that the
point of every clean coded project?) elsewhere, and while towards the end of the design building this seemed to break down a bit, I feel
it held true throughout most of my design process.  I tried to implement the factory design method in order to produce the layout of the
game (i.e. the tiles and different keys) as well as use it to handle certain events (ex. Opening a lock), and for the most part this
worked, but for some reason the keys did not properly move off the board when collected (the keys are “picked up”, but the key tiles
remain on the board regardless) while the locks did, which I would have to guess had something to do with the way the two different
interfaces would interact with the grid, hence the difference.  Moreover, Iimplemented the State pattern (Chip's image was the state) as
well as utilized the Strategy pattern for the actual game levels.  The issue with the later was that I was unable to accurately, or really
at all, properly implement the Strategy pattern, as I could not make the game flip levels or redraw a new level without completely exiting
or having a manually hard coded switch.  I certainly would have liked to have changed that last aspect if I were able to redo the project,
and I wish I could have figured out a way to encapsulate the levels such that "exiting" or completing level 1 would automatically bring
up level 2.  additionally, I would have loved to have incorporated more elements, such as water blocks or bugs, into the game, as I feel
like my game is fairly primitive (unfortunately I was swamped with interviews during this period of time, hence the 11th hour submission.  This is not to make an excuse but rather just give context, as I genuinely enjoyed the project, but I just wish I had more time to complete it!).
