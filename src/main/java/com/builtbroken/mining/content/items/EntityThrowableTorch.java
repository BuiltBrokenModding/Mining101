package com.builtbroken.mining.content.items;

import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.lib.world.WorldUtility;
import com.builtbroken.mc.prefab.inventory.InventoryUtility;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EntityThrowableTorch extends EntityThrowable
{
    public EntityThrowableTorch(World world)
    {
        super(world);
    }

    public EntityThrowableTorch(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }

    public EntityThrowableTorch(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition hit)
    {
        if (!worldObj.isRemote && !isDead)
        {
            if (hit.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                Pos pos = new Pos(hit).add(ForgeDirection.getOrientation(hit.sideHit));
                if (hit.sideHit != 0 && pos.isAirBlock(worldObj))
                {
                    switch(hit.sideHit)
                    {
                        case 1: pos.setBlock(worldObj, Blocks.torch, 5); break;
                        case 2: pos.setBlock(worldObj, Blocks.torch, 4); break;
                        case 3: pos.setBlock(worldObj, Blocks.torch, 3); break;
                        case 4: pos.setBlock(worldObj, Blocks.torch, 2); break;
                        case 5: pos.setBlock(worldObj, Blocks.torch, 1); break;
                    }
                }
                else
                    InventoryUtility.dropItemStack(worldObj, pos, new ItemStack(Blocks.torch));
            }
            else if (hit.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY)
            {
                hit.entityHit.dropItem(Item.getItemFromBlock(Blocks.torch), 1);
                hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
            }

            for (int j = 0; j < 8; ++j)
            {
                this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
            this.setDead();
        }
    }
}