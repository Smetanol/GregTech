package gregtech.loaders.postload;

import net.minecraft.init.Blocks;

public class BlockResistanceLoader implements Runnable {

    @Override
    public void run() {
        Blocks.STONE.setResistance(10.0F);
        Blocks.COBBLESTONE.setResistance(10.0F);
        Blocks.STONEBRICK.setResistance(10.0F);
        Blocks.BRICK_BLOCK.setResistance(20.0F);
        Blocks.HARDENED_CLAY.setResistance(15.0F);
        Blocks.STAINED_HARDENED_CLAY.setResistance(15.0F);

//        if (GregTechMod.gregtechproxy.mHardRock) {
//            Blocks.STONE.setHardness(16.0F);
//            Blocks.BRICK_BLOCK.setHardness(32.0F);
//            Blocks.HARDENED_CLAY.setHardness(32.0F);
//            Blocks.STAINED_HARDENED_CLAY.setHardness(32.0F);
//            Blocks.COBBLESTONE.setHardness(12.0F);
//            Blocks.STONEBRICK.setHardness(24.0F);
//        }

        Blocks.BED.setHarvestLevel("axe", 0);
        Blocks.HAY_BLOCK.setHarvestLevel("axe", 0);
        Blocks.TNT.setHarvestLevel("pickaxe", 0);
        Blocks.SPONGE.setHarvestLevel("axe", 0);
        Blocks.MONSTER_EGG.setHarvestLevel("pickaxe", 0);

    }
}
