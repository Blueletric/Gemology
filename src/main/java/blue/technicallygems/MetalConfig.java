package blue.technicallygems;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static blue.technicallygems.TechnicallyGems.*;

@Config(modid = TechnicallyGems.MOD_ID)
public class MetalConfig {

    @Config.Comment("Metals' Configuration")
    public static final Metals metals = new Metals();

    public static class Metals {

        @Config.Comment("Zinc Configuration")
        public final Zincingot zincingot = new Zincingot();
        @Config.Comment("Zinc Configuration")
        public final Titaniumingot titaniumingot = new Titaniumingot();
        @Config.Comment("Zinc Configuration")
        public final Aluminumingot aluminumingot = new Aluminumingot();

        @Config.Comment("Zinc Configuration")
        public final Siliconingot siliconingot = new Siliconingot();




        public static class Zincingot {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"ingotZinc"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }
        public static class Aluminumingot {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"ingotAluminum"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }
        public static class Siliconingot {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"ingotSilicon"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }
        public static class Titaniumingot {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"ingotTitanium"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }


    }
    @Config.Comment("Dusts' Configuration")
    public static final Dusts dusts = new Dusts();

    public static class Dusts {

        @Config.Comment("Zinc Dust Configuration")
        public final Dusts.Zincdust zincdust = new Dusts.Zincdust();
        @Config.Comment("Titanium Dust Configuration")
        public final Dusts.Titaniumdust titaniumdust = new Dusts.Titaniumdust();
        @Config.Comment("Aluminum Dust Configuration")
        public final Dusts.Aluminumdust aluminumdust = new Dusts.Aluminumdust();
        @Config.Comment("Silicon Dust Configuration")
        public final Dusts.Silicondust silicondust = new Dusts.Silicondust();
        @Config.Comment("Iron Dust Configuration")
        public final Dusts.Irondust irondust = new Dusts.Irondust();

        public static class Zincdust {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"dustZinc"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }

        public static class Aluminumdust {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"dustAluminum"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};

        }

        public static class Silicondust {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"dustSilicon"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }

        public static class Titaniumdust {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"dustTitanium"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }

        public static class Irondust {

            @Config.Comment("Ore Dictionary Values")
            public String[] oreDict = new String[]{"dustIron"};

            @Config.Comment("Tooltip")
            public String[] tooltip = new String[]{};
        }
    }
        
    @Mod.EventBusSubscriber(modid = TechnicallyGems.MOD_ID)
    private static class EventHandler {

        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(TechnicallyGems.MOD_ID)) {
                ConfigManager.sync(TechnicallyGems.MOD_ID, Config.Type.INSTANCE);
                configLoad();
                TechnicallyGems.LOGGER.info("hi");
            }
        }
    }

    public static void configLoad() {
        zincingot.setOreDict(MetalConfig.metals.zincingot.oreDict).setTooltip(MetalConfig.metals.zincingot.tooltip);
        titaniumingot.setOreDict(MetalConfig.metals.titaniumingot.oreDict).setTooltip(MetalConfig.metals.titaniumingot.tooltip);
        aluminumingot.setOreDict(MetalConfig.metals.aluminumingot.oreDict).setTooltip(MetalConfig.metals.aluminumingot.tooltip);
        siliconingot.setOreDict(MetalConfig.metals.siliconingot.oreDict).setTooltip(MetalConfig.metals.siliconingot.tooltip);

        zincdust.setOreDict(MetalConfig.dusts.zincdust.oreDict).setTooltip(MetalConfig.dusts.zincdust.tooltip);
        titaniumdust.setOreDict(MetalConfig.dusts.titaniumdust.oreDict).setTooltip(MetalConfig.dusts.titaniumdust.tooltip);
        aluminumdust.setOreDict(MetalConfig.dusts.aluminumdust.oreDict).setTooltip(MetalConfig.dusts.aluminumdust.tooltip);
        silicondust.setOreDict(MetalConfig.dusts.silicondust.oreDict).setTooltip(MetalConfig.dusts.silicondust.tooltip);
        irondust.setOreDict(MetalConfig.dusts.irondust.oreDict).setTooltip(MetalConfig.dusts.irondust.tooltip);
}

}
