# NullMovement

In vanilla Minecraft, pressing two movement keys on the same axis at the same time (i.e. left and right, forward and backward) will cause movement blocking that makes you stand completely still. This is due to the vanilla code having a case to set your movement to 0 if both keys are held simultaneously.

Null Movement alters this code to instead prioritise the direction you most recently pressed, if you accidentally hit two keys at the same time you will not stop in place. Your movement will feel much smoother.

This mod is basically a port of the original mod, made by jwkerr, but was made for Fabric 1.20.6.
https://github.com/jwkerr/NullMovement
