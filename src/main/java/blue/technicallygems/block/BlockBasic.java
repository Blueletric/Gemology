package blue.technicallygems.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block {


    public BlockBasic(Material material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
