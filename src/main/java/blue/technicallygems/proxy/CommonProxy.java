package blue.technicallygems.proxy;

import net.minecraft.util.text.translation.I18n;
import blue.technicallygems.item.ItemBase;

public class CommonProxy {
    public void registerItemRenderer(ItemBase item){}

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }
}
