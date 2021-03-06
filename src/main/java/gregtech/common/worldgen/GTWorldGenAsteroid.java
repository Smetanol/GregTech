package gregtech.common.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.ore.StoneType;
import gregtech.api.unification.ore.StoneTypes;
import gregtech.api.util.GTUtility;
import gregtech.api.util.WeightedList.WeightedWrapperList;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class GTWorldGenAsteroid extends GTWorldGenStone {

    public final List<String> oreVeins;

    /**
     * @param name        Name of this asteroid generator
     * @param enabled     Set true to enable this generator
     * @param minY        Minimum height where the center of the asteroid will occurs
     * @param maxY        Maximum height where the center of the asteroid will occurs; Must > minY
     * @param minSize     Minimum radius of the asteroid
     * @param maxSize     Maximum radius of the asteroid; Must > minSize
     * @param probability Inverse of the probability that the asteroid will be generated in each chunk
     * @param amount      Maximum amount that the asteroid will generate in each chunk
     * @param stoneType   Type of the asteroid block
     */
    public GTWorldGenAsteroid(String name, boolean enabled, int minY, int maxY, int minSize, int maxSize, int probability, int amount, StoneType stoneType, String[] dimWhiteList, String[] biomeWhiteList, String[] oreVeinList) {
        super(name, enabled, 2048, minY, maxY, minSize, maxSize, probability, amount, stoneType, true, dimWhiteList, biomeWhiteList);
        oreVeins = Arrays.stream(oreVeinList).filter(GTUtility::isStringValid).collect(Collectors.toList());
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, Biome biome, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!this.isGenerationAllowed(world, biome) || this.probability <= 0)
            return;
        for (int i = 0; i < this.amount; i++) {
            if (random.nextInt(this.probability) == 0) {
                GTWorldGenOreVein.getRandomOreVein(random, this.oreVeins)
                    .ifPresent(oreVein -> {
                        WeightedWrapperList<WeightedWrapperList<DustMaterial>> oreLists = new WeightedWrapperList<>();
                        oreLists.add(oreVein.orePrimaries, 6);
                        oreLists.add(oreVein.oreSecondaries, 6);
                        oreLists.add(oreVein.oreBetweens, 4);
                        oreLists.add(oreVein.oreSporadics, 3);
                        WeightedWrapperList<DustMaterial> ores = WeightedWrapperList.mergeWeightedList(oreLists);
                        int density = oreVein.density;
                        boolean generateOre = this.stoneType != StoneTypes._NULL;
                        this.generate(random, chunkX, chunkZ, world, false,
                            world::isAirBlock,
                            (pos, r, rnd) -> world.setBlockState(pos,
                                (generateOre && rnd.nextInt(Math.max(2, (int) (80.0f * r / density))) == 0) ?
                                    getOreBlock(ores.fetchRandomObject(rnd), this.stoneType, false).orElse(this.stone)
                                    : this.stone,
                                18));
                    });
            }
        }
    }

    @Override
    public String toString() {
        return "asteroid." + this.name;
    }
}
