package com.builtbroken.mining.content.tile.machine;

/** Just like the BC filler but with less fill types and more options. Is designed
 * to fill in an area with a material type.
 * Created by robert on 3/5/2015.
 */
public class TileFiller
{
    public enum Types
    {
        /** Normaly version that just fills in materials */
        BASIC,
        /** Comes built in with a wireless item, fluid, and power connection */
        ENDER,
        /** Upgrade of the ender that can teleport away when finished */
        TELEPORTATION

    }
}
