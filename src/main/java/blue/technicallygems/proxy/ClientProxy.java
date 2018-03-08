package blue.technicallygems.proxy;

import net.minecraft.client.resources.I18n;
import blue.technicallygems.TechnicallyGems;
import blue.technicallygems.item.ItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    public void registerItemRenderer(ItemBase item) {
        if(item.getSubNames()!=null) {
            for (int i = 0; i < item.getSubNames().size(); i++) {
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(TechnicallyGems.MOD_ID + ":" + item.getSubNames().get(i), "inventory"));
            }
        }
        else {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(TechnicallyGems.MOD_ID + ":" + item.name, "inventory"));
        }

    }
    @Override
    public String localize(String unlocalized, Object... args) {
        return I18n.format(unlocalized, args);
    }


}
