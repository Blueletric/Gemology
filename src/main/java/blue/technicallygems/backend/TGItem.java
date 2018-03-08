package blue.technicallygems.backend;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface TGItem {
    @SideOnly(Side.CLIENT)
    void registerTextures();

    @SideOnly(Side.CLIENT)
    IBakedModel createModel(int metadata);

    @SideOnly(Side.CLIENT)
    TextureAtlasSprite getBaseTexture();

    @SideOnly(Side.CLIENT)
    void addQuad(PassthruModelItem.ModelLayer model, ItemStack stack);

    @SideOnly(Side.CLIENT)
    void postTextureRegister();

    @SideOnly(Side.CLIENT)
    boolean renderAsTool();

    @SideOnly(Side.CLIENT)
    void clearCaches();

    @SideOnly(Side.CLIENT)
    boolean allowOverride();

    @SideOnly(Side.CLIENT)
    int getMaxMetadata();

    @SideOnly(Side.CLIENT)
    default String getModelSubName(int metadata){
        return String.valueOf(metadata);
    }
}

