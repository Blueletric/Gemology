package blue.technicallygems;


import blue.technicallygems.item.ItemBase;
import blue.technicallygems.item.SubItemBase;
import blue.technicallygems.proxy.CommonProxy;
import blue.technicallygems.proxy.ClientProxy;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


@Mod(modid= TechnicallyGems.MOD_ID, name = TechnicallyGems.NAME, version = TechnicallyGems.VERSION)
@Mod.EventBusSubscriber
public class TechnicallyGems {

    public static final String MOD_ID = "technicallygems";
    public static final String NAME = "Technically Gems";
    public static final String VERSION = "1.0";

    @SidedProxy(serverSide = "blue.technicallygems.proxy.ServerProxy", clientSide = "blue.technicallygems.proxy.ClientProxy")
    public static CommonProxy proxy;
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static List<ItemBase> items = new ArrayList<>();
    public static List<SubItemBase> ingot = new ArrayList<>();

    public static SubItemBase zincingot = new SubItemBase("zincingot").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(ingot);
    public static SubItemBase aluminumingot = new SubItemBase("aluminumingot").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(ingot);
    public static SubItemBase siliconingot = new SubItemBase("siliconingot").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(ingot);
    public static SubItemBase titaniumingot = new SubItemBase("titaniumingot").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(ingot);
    public static Item ingots = new ItemBase("ingots",ingot);

    public static List<SubItemBase> dust = new ArrayList<>();

    public static SubItemBase zincdust = new SubItemBase("zincdust").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(dust);
    public static SubItemBase titaniumdust = new SubItemBase("titaniumdust").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(dust);
    public static SubItemBase silicondust = new SubItemBase("silicondust").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(dust);
    public static SubItemBase aluminumdust = new SubItemBase("aluminumdust").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(dust);
    public static SubItemBase irondust = new SubItemBase("irondust").setCreativeTab(MetalsCreativeTab.creativeTab).setItem(dust);

    public static Item dusts = new ItemBase("dusts",dust);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        //ModBlocks.init();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        for (ItemBase item : items) {
            event.getRegistry().register(item);
            item.registerOreDict();
        }

    }

    @SubscribeEvent
    public void registerItems(ModelRegistryEvent event){
        for (int i = 0; i < items.size(); i++) {
            proxy.registerItemRenderer(items.get(i));
        }

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

        MetalConfig.configLoad();

        for(ItemBase item : items){
            item.registerOreDict();
        }

    }

}
