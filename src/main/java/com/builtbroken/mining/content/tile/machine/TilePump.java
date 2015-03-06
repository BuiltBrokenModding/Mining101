package com.builtbroken.mining.content.tile.machine;

/** Simple basic pump for clearing out fluids or pumping in O2 into a min
 * Created by robert on 3/5/2015.
 */
public class TilePump
{
    public static enum Types
    {
        /** Normaly version that just fills in materials */
        BASIC,
        /** Comes built in with a wireless item, fluid, and power connection */
        ENDER,
        /** Upgrade of the ender that can teleport away when finished */
        TELEPORTATION;

    }
}
