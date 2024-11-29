Reflection

When I designed the second level and the key system I was crunched for time, so my design only works for one key and one wall.
However, I believe I have shown elsewhere in the code how I am able to plan and design a system that adheres to the design principles we have been talking about it class.
The way the level hierarchy works, and how the Main class is able to very easily tear-down and set-up a new level is a great example of this.
Further, I believe the TileInfo class is a great way of making sure the tile image and enumeration information is in one concise place that only does one thing.

If I could design the key system again, and with more time, I would have made a Key and a KeyWall class, made the Key observe Chip, and made the KeyWall observe the Key so that when the key was collected the wall would be destroyed. This would have allowed for different colored keys (could be a variable in the Key class) as well as any number of keys and walls.

Other than that, I am happy with my design. By far the most challenging aspect (that took the most time to figure out) was the level moving when chip is in the center. It essentially led me to have 3 different coordinate systems, one for the tiles, one for Chip, and one for the Bugs (any other enemies would have been in this coordinate system).
Having figured this part out (after multiple refactorings) I set out to implement the level change, which I think ended up being pretty robust and well designed, and the key system, which I have discussed above.
