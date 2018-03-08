package blue.technicallygems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MetalsCreativeTab extends CreativeTabs {
    public static final CreativeTabs creativeTab = new MetalsCreativeTab();

    private MetalsCreativeTab() {
        super(TechnicallyGems.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(TechnicallyGems.ingots, 1, TechnicallyGems.ingots.getMetadata(1));
    }
}
