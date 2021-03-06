package gregtech.api.metatileentity.factory;

import gregtech.api.metatileentity.IMetaTileEntity;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.common.blocks.machines.BlockMachine;
import net.minecraft.util.ResourceLocation;

public class TieredMetaTileEntityFactory<T extends TieredMetaTileEntity> extends MetaTileEntityFactory<T> {

    protected int tier;

    public TieredMetaTileEntityFactory(BlockMachine.ToolClass toolClass, int harvestLevel, String[] description, Class<T> metaTileEntityClass, ResourceLocation modelLocation, int tier) {
        super(toolClass, harvestLevel, description, metaTileEntityClass, modelLocation);
        this.tier = tier;
    }

    @Override
    public IMetaTileEntity constructMetaTileEntity() {
        try {
            return metaTileEntityClass.getConstructor(TieredMetaTileEntityFactory.class).newInstance(this);
        } catch (Throwable exception) {
            throw new RuntimeException(exception);
        }
    }

    public int getTier() {
        return tier;
    }
}
