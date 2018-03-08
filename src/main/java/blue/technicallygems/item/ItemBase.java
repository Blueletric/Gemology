package blue.technicallygems.item;

import blue.technicallygems.MetalsCreativeTab;
import blue.technicallygems.TechnicallyGems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemBase extends Item {

    public final String name;
    private final List<SubItemBase> subItems;
    private List<String> subNames = new ArrayList<>();

    public ItemBase(String name, List<SubItemBase> subItems) {
        this.setRegistryName(TechnicallyGems.MOD_ID+":"+name);
        this.setUnlocalizedName(TechnicallyGems.MOD_ID+"."+name);
        this.setCreativeTab(MetalsCreativeTab.creativeTab);
        this.name = name;
        this.setHasSubtypes(true);
        this.subItems = subItems;
        for(SubItemBase subItem : subItems){
            this.subNames.add(subItem.getName());
        }
        for(SubItemBase subItem : this.subItems) System.out.print(subItem.getName());
        TechnicallyGems.items.add(this);
    }

    public List<String> getSubNames() {
        return this.subNames;
    }

    public String getSubName(int i){
        return this.subNames.get(i);
    }

    public String getName() {
        return name;
    }

    public List<SubItemBase> getSubItems() {
        return subItems;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

        for(int i = 0; i < subItems.size(); i++){
            if(subItems.get(i).getCreativeTab() == tab) items.add(new ItemStack(this, 1, i));
        }

    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if(getSubNames()!=null) {
            if(stack.getItemDamage() < getSubNames().size()) {
                String subItem = getSubNames().get(stack.getItemDamage());
                return this.getUnlocalizedName() + "." + subItem;
            }

        }
        return this.getUnlocalizedName();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltips, ITooltipFlag flagIn){
        if(subItems.size()>stack.getItemDamage() && subItems.get(stack.getItemDamage()).getTooltip()!=null){
            for(String tooltip : subItems.get(stack.getItemDamage()).getTooltip()){
                tooltips.add(tooltip);
            }
        }
    }

    @Override
    public int getItemStackLimit(ItemStack stack){
        if(subItems.size()>stack.getItemDamage()){
            return subItems.get(stack.getItemDamage()).getStackSize();
        }
        return 64;
    }

    public void registerOreDict(){
        for(SubItemBase subItem : this.subItems){
            for(int i = 0; i<subItem.getOreDict().size(); i++){
                OreDictionary.registerOre(subItem.getOreDict().get(i), new ItemStack(this, 1, i));
            }
        }
    }



}
