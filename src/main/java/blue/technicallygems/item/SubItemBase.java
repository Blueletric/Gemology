package blue.technicallygems.item;

import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

public class SubItemBase {

    protected final String name;
    protected List<String> oreDict = new ArrayList<>();
    protected int stackSize;
    protected List<String> tooltip = new ArrayList<>();
    protected CreativeTabs creativeTab;
    protected int metadata;

    public SubItemBase(String name){
        this.name = name;
        this.stackSize = 64;
    }

    public String getName() {
        return name;
    }

    public SubItemBase setOreDict(String... oreDict) {
        for(int i = 0; i<oreDict.length; i++){
            this.oreDict.add(oreDict[i]);
        }
        return this;
    }

    public List<String> getOreDict(){
        return this.oreDict;
    }

    public SubItemBase setStackSize(int stackSize){
        this.stackSize = stackSize;
        return this;
    }

    public int getStackSize(){
        return this.stackSize;
    }

    public SubItemBase setItem(List<SubItemBase> items){
        this.metadata=items.size();
        items.add(this);
        return this;
    }

    public int getMetadata(){
        return this.metadata;
    }

    public SubItemBase setTooltip(String... tooltip){
        if (tooltip != null) {
            System.out.println("tooltip length is: " + tooltip.length);
            for(int i = 0; i<tooltip.length; i++){
                System.out.println("tooltip is: " + i);
                this.tooltip.add(tooltip[i]);
            }
        }
        return this;
    }

    public List<String> getTooltip(){
        return this.tooltip;
    }

    public SubItemBase setCreativeTab(CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }

    public CreativeTabs getCreativeTab() {
        return creativeTab;
    }
}
