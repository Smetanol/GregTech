package gregtech.common.blocks.rework;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class GT_Item_GeneratedOres extends ItemBlock {


    public GT_Item_GeneratedOres(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return ((GT_Block_GeneratedOres) block).mUnlocalizedName + "." + stack.getItemDamage();
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

}