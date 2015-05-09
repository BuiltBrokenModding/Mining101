package com.builtbroken.mining;

import com.builtbroken.mc.core.Engine;
import com.builtbroken.mc.core.content.entity.EntityExCreeper;
import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import com.builtbroken.mining.content.items.EntityThrowableTorch;
import com.builtbroken.mining.content.items.ItemThrowableTorch;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.item.Item;

/**
 * Created by robert on 11/18/2014.
 */
@Mod(modid = Mining.DOMAIN, name = Mining.NAME, version = Mining.VERSION, dependencies = "required-after:VoltzEngine")
public final class Mining extends AbstractMod
{
    /** Name of the channel and mod ID. */
    public static final String NAME = "Mining 101";
    public static final String DOMAIN = "mining101";
    public static final String PREFIX = DOMAIN + ":";

    /** The version of WatchYourStep. */
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    public static final String ASSETS_PATH = "/assets/mining101/";
    public static final String TEXTURE_PATH = "textures/";
    public static final String GUI_PATH = TEXTURE_PATH + "gui/";
    public static final String MODEL_PREFIX = "models/";
    public static final String MODEL_DIRECTORY = ASSETS_PATH + MODEL_PREFIX;

    public static final String MODEL_TEXTURE_PATH = TEXTURE_PATH + MODEL_PREFIX;
    public static final String BLOCK_PATH = TEXTURE_PATH + "blocks/";
    public static final String ITEM_PATH = TEXTURE_PATH + "items/";

    @Mod.Instance(DOMAIN)
    public static Mining INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.mining.ClientProxy", serverSide = "com.builtbroken.mining.CommonProxy")
    public static CommonProxy proxy;

    public static ModCreativeTab CREATIVE_TAB;

    public static Item itemThrowableTorch;

    public Mining()
    {
        super(DOMAIN, "Mining101");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        CREATIVE_TAB = new ModCreativeTab("Mining101");
        getManager().setTab(CREATIVE_TAB);

        itemThrowableTorch = getManager().newItem("throwableTorch", ItemThrowableTorch.class);

        EntityRegistry.registerGlobalEntityID(EntityThrowableTorch.class, "eThrowableTorch", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityThrowableTorch.class, "eThrowableTorch", 57, this, 100, 1, true);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public CommonProxy getProxy()
    {
        return proxy;
    }
}
