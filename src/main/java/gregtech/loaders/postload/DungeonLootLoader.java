package gregtech.loaders.postload;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootTableList;

public class DungeonLootLoader implements Runnable {

    public void run() {
//        if (GregTechMod.gregtechproxy.mIncreaseDungeonLoot) {
//            ChestGenHooks.addRolls(LootTableList.CHESTS_SPAWN_BONUS_CHEST, 2, 4);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_SIMPLE_DUNGEON, 1, 3);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_DESERT_PYRAMID, 2, 4);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_JUNGLE_TEMPLE, 4, 8);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER, 0, 2);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_ABANDONED_MINESHAFT, 1, 3);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_VILLAGE_BLACKSMITH, 2, 6);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_STRONGHOLD_CROSSING, 2, 4);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_STRONGHOLD_CORRIDOR, 2, 4);
//            ChestGenHooks.addRolls(LootTableList.CHESTS_STRONGHOLD_LIBRARY, 4, 8);
//        }
//
        ChestGenHooks.addItem(LootTableList.CHESTS_SPAWN_BONUS_CHEST, MetaItems.BOTTLE_PURPLE_DRINK.getStackForm(), 8, 16, 2);

        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, MetaItems.BOTTLE_HOLY_WATER.getStackForm(), 4, 8, 10);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, MetaItems.BOTTLE_PURPLE_DRINK.getStackForm(), 8, 16, 40);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.ingot, Materials.Silver, 1), 1, 6, 30);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.ingot, Materials.Lead, 1), 1, 6, 7);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.ingot, Materials.Steel, 1), 1, 6, 15);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.ingot, Materials.Bronze, 1), 1, 6, 15);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.ingot, Materials.Manganese, 1), 1, 6, 15);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.ingot, Materials.DamascusSteel, 1), 1, 6, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.Emerald, 1), 1, 6, 5);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.Ruby, 1), 1, 6, 5);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.Sapphire, 1), 1, 6, 5);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.GreenSapphire, 1), 1, 6, 5);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.Olivine, 1), 1, 6, 5);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetRed, 1), 1, 6, 10);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetYellow, 1), 1, 6, 10);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.dust, Materials.Neodymium, 1), 1, 6, 10);
        ChestGenHooks.addItem(LootTableList.CHESTS_SIMPLE_DUNGEON, OreDictUnifier.get(OrePrefix.dust, Materials.Chrome, 1), 1, 3, 10);

        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, MetaItems.BOTTLE_HOLY_WATER.getStackForm(), 4, 8, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.ingot, Materials.Silver, 1), 4, 16, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.ingot, Materials.Platinum, 1), 2, 8, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.gem, Materials.Ruby, 1), 2, 8, 1);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.gem, Materials.Sapphire, 1), 2, 8, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.gem, Materials.GreenSapphire, 1), 2, 8, 4);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.gem, Materials.Olivine, 1), 2, 8, 4);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetRed, 1), 2, 8, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_DESERT_PYRAMID, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetYellow, 1), 2, 8, 3);

        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, MetaItems.COIN_GOLD_ANCIENT.getStackForm(), 16, 64, 5);
//        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, MetaItems.ZPM.getWithCharge(1, Long.MAX_VALUE), 1, 1, 1);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.ingot, Materials.Bronze, 1), 4, 16, 12);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.gem, Materials.Ruby, 1), 2, 8, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.gem, Materials.Sapphire, 1), 2, 8, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.gem, Materials.GreenSapphire, 1), 2, 8, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.gem, Materials.Olivine, 1), 2, 8, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetRed, 1), 2, 8, 4);
        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetYellow, 1), 2, 8, 4);

        ChestGenHooks.addItem(LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER, new ItemStack(Items.FIRE_CHARGE, 1), 2, 8, 15);

        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.ingot, Materials.Silver, 1), 1, 4, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.ingot, Materials.Lead, 1), 1, 4, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.ingot, Materials.Steel, 1), 1, 4, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.ingot, Materials.Bronze, 1), 1, 4, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.Sapphire, 1), 1, 4, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.GreenSapphire, 1), 1, 4, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.Olivine, 1), 1, 4, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetRed, 1), 1, 4, 4);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.GarnetYellow, 1), 1, 4, 4);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.Ruby, 1), 1, 4, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.gem, Materials.Emerald, 1), 1, 4, 2);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.toolHeadPickaxe, Materials.DamascusSteel, 1), 1, 4, 1);
        ChestGenHooks.addItem(LootTableList.CHESTS_ABANDONED_MINESHAFT, OreDictUnifier.get(OrePrefix.toolHeadShovel, Materials.DamascusSteel, 1), 1, 4, 1);

        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, MetaItems.MCGUFFIUM_239.getStackForm(), 1, 1, 1);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.dust, Materials.Chrome, 1), 1, 4, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.dust, Materials.Neodymium, 1), 2, 8, 3);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.ingot, Materials.Manganese, 1), 2, 8, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.ingot, Materials.Steel, 1), 4, 12, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.ingot, Materials.Bronze, 1), 4, 12, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.ingot, Materials.Brass, 1), 4, 12, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_VILLAGE_BLACKSMITH, OreDictUnifier.get(OrePrefix.ingot, Materials.DamascusSteel, 1), 4, 12, 1);

        ChestGenHooks.addItem(LootTableList.CHESTS_STRONGHOLD_CROSSING, MetaItems.BOTTLE_HOLY_WATER.getStackForm(), 4, 8, 6);
        ChestGenHooks.addItem(LootTableList.CHESTS_STRONGHOLD_CROSSING, MetaItems.MCGUFFIUM_239.getStackForm(), 1, 1, 8);
        ChestGenHooks.addItem(LootTableList.CHESTS_STRONGHOLD_CORRIDOR, OreDictUnifier.get(OrePrefix.toolHeadSword, Materials.DamascusSteel, 1), 1, 4, 4);
        ChestGenHooks.addItem(LootTableList.CHESTS_STRONGHOLD_CORRIDOR, OreDictUnifier.get(OrePrefix.toolHeadAxe, Materials.DamascusSteel, 1), 1, 4, 4);
    }

}
