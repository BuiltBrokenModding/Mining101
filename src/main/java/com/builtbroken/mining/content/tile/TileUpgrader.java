package com.builtbroken.mining.content.tile;

import com.builtbroken.mc.prefab.tile.Tile;

import net.minecraft.block.material.Material;

public class TileUpgrader extends Tile
{
    public TileUpgrader(String name, Material material)
    {
        super(name, material);
    }

    @Override
    public Tile newTile()
    {
        return null;
    }
}
