package com.builtbroken.mining.content.items.tools;

import com.builtbroken.mc.prefab.items.ItemAbstractTool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

/** Pick-ax, Ax, Shovel, and wrench all in one tool. Will automatically change texture to
 * match the block it is pointing at. This way it informed the player that it can mine
 * the material. If it can't mine the material it will default to a metal rod.
 *
 * As well requires upgrades in order to actually support all material types. The item
 * can also be configured to mine materials with one tool vs another.
 * Created by robert on 2/14/2015.
 */
public class ItemMultiTool extends ItemAbstractTool
{
    public ItemMultiTool()
    {
        super();
        this.setUnlocalizedName("multiTool");
    }

    private boolean upgradable()
    {
        return false;
    }


    public boolean validBlocks()
    {
        return false;
    }


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        itemIcon = register.registerIcon("multiTool");
    }
}
