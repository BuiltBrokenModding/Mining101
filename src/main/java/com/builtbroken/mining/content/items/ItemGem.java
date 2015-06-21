package com.builtbroken.mining.content.items;

/**
 * Created by robert on 3/5/2015.
 */
public class ItemGem
{
    public enum Gems
    {
        DIAMOND,
        EMERALD,
        RUBY
    }

    public enum Types
    {
        /** Gem is still in stone */
        ENCASED,
        /** Gem is removed from stone  */
        UNCUT,
        /** Gem is cut into a basic shape ready for use */
        CUT
    }
}
