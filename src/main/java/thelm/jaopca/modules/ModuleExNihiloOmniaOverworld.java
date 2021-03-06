package thelm.jaopca.modules;

import thelm.jaopca.api.ModuleBase;

public class ModuleExNihiloOmniaOverworld extends ModuleBase {

	/*public static final ItemEntry ORE_BROKEN_ENTRY = new ItemEntry(EnumEntryType.ITEM, "oreBroken", new ModelResourceLocation("jaopca:ore_broken#inventory"));
	public static final ItemEntry ORE_GRAVEL_ENTRY = new ItemEntry(EnumEntryType.BLOCK, "oreGravel", new ModelResourceLocation("jaopca:ore_gravel#normal")).setBlockProperties(ModuleExNihiloOmnia.GRAVEL_PROPERTIES);*/

	@Override
	public String getName() {
		return "exnihiloomniaoverworld";
	}

	/*@Override
	public List<String> getDependencies() {
		return Lists.<String>newArrayList("exnihiloomnia");
	}

	@Override
	public List<ItemEntry> getItemRequests() {
		List<ItemEntry> ret = Lists.<ItemEntry>newArrayList(ORE_BROKEN_ENTRY, ORE_GRAVEL_ENTRY);
		for(ItemEntry entry : ret) {
			entry.blacklist.addAll(ModuleExNihiloOmnia.EXISTING_ORES);
		}
		return ret;
	}

	@Override
	public void init() {
		for(IOreEntry entry : JAOPCAApi.ENTRY_NAME_TO_ORES_MAP.get("oreBroken")) {
			ModuleExNihiloOmnia.addOreSieveRecipe(Blocks.GRAVEL, Utils.getOreStack("oreBroken", entry, 1), Utils.rarityReciprocalI(entry, 15D)+2);
			//Should exist
			ModuleExNihiloOmnia.addOreSieveRecipe(Blocks.SAND, Utils.getOreStack("oreCrushed", entry, 1), Utils.rarityReciprocalI(entry, 15D)+2);
			ModuleExNihiloOmnia.addOreSieveRecipe(ENOBlocks.DUST, Utils.getOreStack("orePowdered", entry, 1), Utils.rarityReciprocalI(entry, 15D)+2);

			if(ENOCompatibility.add_smeltery_melting && Loader.isModLoaded("tconstruct") && FluidRegistry.isFluidRegistered(Utils.to_under_score(entry.getOreName()))) {
				ModuleTinkersConstruct.addMeltingRecipe("oreBroken"+entry.getOreName(), FluidRegistry.getFluid(Utils.to_under_score(entry.getOreName())), 36);
			}
		}

		for(IOreEntry entry : JAOPCAApi.ENTRY_NAME_TO_ORES_MAP.get("oreGravel")) {
			Utils.addShapelessOreRecipe(Utils.getOreStack("oreGravel", entry, 1), new Object[] {
					"oreBroken"+entry.getOreName(),
					"oreBroken"+entry.getOreName(),
					"oreBroken"+entry.getOreName(),
					"oreBroken"+entry.getOreName(),
			});

			Utils.addSmelting(Utils.getOreStack("oreGravel", entry, 1), Utils.getOreStack("ingot", entry, 1), 0);

			ModuleExNihiloOmnia.addOreHammerRecipe(JAOPCAApi.BLOCKS_TABLE.get("oreGravel", entry.getOreName()), Utils.getOreStack("oreCrushed", entry, 1));

			if(ENOCompatibility.add_smeltery_melting && Loader.isModLoaded("tconstruct") && FluidRegistry.isFluidRegistered(Utils.to_under_score(entry.getOreName()))) {
				ModuleTinkersConstruct.addMeltingRecipe("oreGravel"+entry.getOreName(), FluidRegistry.getFluid(Utils.to_under_score(entry.getOreName())), 144);
			}

			if(ENOCompatibility.aa_crusher && Loader.isModLoaded("actuallyadditions")) {
				ModuleExNihiloOmnia.addActuallyAdditionsCrusherRecipe(Utils.getOreStack("oreGravel", entry, 1), Utils.getOreStack("oreCrushed", entry, 5), Utils.getOreStack("oreCrushed", entry, 2), 30);
			}

			if(ENOCompatibility.mekanism_crusher && Loader.isModLoaded("Mekanism")) {
				ModuleMekanism.addCrusherRecipe(Utils.getOreStack("oreGravel", entry, 1), Utils.getOreStack("oreCrushed", entry, 6));
			}

			if(ENOCompatibility.sag_mill && Loader.isModLoaded("EnderIO")) {
				ModuleExNihiloOmnia.addOreSAGMillRecipe("oreGravel"+entry.getOreName(), "oreCrushed"+entry.getOreName());
			}
		}
	}*/
}
