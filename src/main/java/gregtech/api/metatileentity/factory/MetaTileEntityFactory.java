package gregtech.api.metatileentity.factory;

import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.IMetaTileEntity;
import gregtech.api.metatileentity.IMetaTileEntityFactory;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.blocks.machines.BlockMachine;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MetaTileEntityFactory<T extends MetaTileEntity> implements IMetaTileEntityFactory {

    private BlockMachine.ToolClass toolClass;
    private int harvestLevel;
    private String[] description;
    protected Class<T> metaTileEntityClass;
    protected ResourceLocation modelLocation;

    public MetaTileEntityFactory(BlockMachine.ToolClass toolClass, int harvestLevel, String[] description, Class<T> metaTileEntityClass, ResourceLocation modelLocation) {
        this.toolClass = toolClass;
        this.harvestLevel = harvestLevel;
        this.description = description;
        this.metaTileEntityClass = metaTileEntityClass;
        this.modelLocation = modelLocation;
    }

    @Override
    public BlockMachine.ToolClass getHarvestTool() {
        return toolClass;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public String getMetaName() {
        return GregTechAPI.METATILEENTITY_REGISTRY.getNameForObject(this);
    }

    @Override
    public String getUnlocalizedName() {
        return "machine." + getMetaName();
    }

    @Override
    public Class<? extends Block> getBlockClass() {
        return BlockMachine.class;
    }

    @Override
    public ResourceLocation getStateLocation() {
        return modelLocation;
    }

    @Override
    public String[] getDescription(ItemStack tileEntityStack) {
        return description;
    }

    @Override
    public IMetaTileEntity constructMetaTileEntity() {
        try {
            return metaTileEntityClass.getConstructor(MetaTileEntityFactory.class).newInstance(this);
        } catch (Throwable exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public ItemStack getStackForm(int amount) {
        return new ItemStack(MetaBlocks.MACHINE, amount, GregTechAPI.METATILEENTITY_REGISTRY.getIDForObject(this));
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
    }

}
