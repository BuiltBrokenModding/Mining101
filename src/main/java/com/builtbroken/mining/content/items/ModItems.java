package com.builtbroken.mining.content.items;

import com.builtbroken.mining.content.items.tools.ItemMultiTool;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems
{
    public static Item itemMultiTool = new ItemMultiTool();

    public static void register()
    {
        GameRegistry.registerItem(itemMultiTool, "multiTool");
    }
}
