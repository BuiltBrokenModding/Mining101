package com.builtbroken.mining.content.items.tools;

import com.builtbroken.mc.core.content.blocks.BlockHeatedStone;
import com.builtbroken.mc.core.handler.InteractionHandler;
import com.builtbroken.mc.core.network.packet.PacketEntity;
import com.builtbroken.mc.prefab.items.ItemAbstractTool;
import com.builtbroken.mining.Mining;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

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
    public IIcon iconDefault;
    public IIcon icon0;
    public IIcon icon1;
    public IIcon icon2;
    public IIcon icon3;

    public ItemMultiTool()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        return itemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.iconDefault = register.registerIcon(Mining.PREFIX + "multiTool_default");
        this.icon0 = register.registerIcon(Mining.PREFIX + "multiTool_upgrade0");
        this.icon1 = register.registerIcon(Mining.PREFIX + "multiTool_upgrade1");
        this.icon2 = register.registerIcon(Mining.PREFIX + "multiTool_upgrade2");
        this.icon3 = register.registerIcon(Mining.PREFIX + "multiTool_upgrade3");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        Block block = InteractionHandler.getMouseOverBlockClient();

        if (block != null && block.isToolEffective("pickaxe", 0) || block != null && block.getMaterial().equals(Material.rock))
        {
            return icon0;
        }
        else if (block != null && block.isToolEffective("shovel", 0))
        {
            return icon1;
        }
        else if (block != null && block.isToolEffective("axe", 0))
        {
            return icon2;
        }
        else
        {
            return iconDefault;
        }
    }
}
