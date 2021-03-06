package thelm.jaopca.modules;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.Loader;
import thelm.jaopca.api.EnumEntryType;
import thelm.jaopca.api.EnumOreType;
import thelm.jaopca.api.IOreEntry;
import thelm.jaopca.api.ItemEntry;
import thelm.jaopca.api.JAOPCAApi;
import thelm.jaopca.api.ModuleBase;
import thelm.jaopca.api.utils.Utils;

public class ModulePlate extends ModuleBase {

	public static final ItemEntry PLATE_ENTRY = new ItemEntry(EnumEntryType.ITEM, "plate", new ModelResourceLocation("jaopca:plate#inventory")).
			setOreTypes(EnumOreType.DUSTLESS);

	@Override
	public String getName() {
		return "plate";
	}

	@Override
	public List<ItemEntry> getItemRequests() {
		return Lists.<ItemEntry>newArrayList(PLATE_ENTRY);
	}

	@Override
	public void init() {
		for(IOreEntry entry : JAOPCAApi.ENTRY_NAME_TO_ORES_MAP.get("plate")) {
			if(Loader.isModLoaded("ic2")) {
				switch(entry.getOreType()) {
				case GEM:
				case GEM_ORELESS: {
					if(Utils.doesOreNameExist("dust"+entry.getOreName())) {
						ModuleIndustrialCraft.addCompressorRecipe("dust"+entry.getOreName(), Utils.getOreStack("plate", entry, 1));
					}
					break;
				}
				case INGOT:
				case INGOT_ORELESS: {
					Utils.addShapelessOreRecipe(Utils.getOreStack("plate", entry, 1), new Object[] {
							"ingot"+entry.getOreName(),
							"craftingToolForgeHammer",
					});
					ModuleIndustrialCraft.addRollingRecipe("ingot"+entry.getOreName(), Utils.getOreStack("plate", entry, 1));
					break;
				}
				default:
					break;
				}
				if(Utils.doesOreNameExist("block"+entry.getOreName())) {
					ModuleIndustrialCraft.addBlockCutterRecipe("block"+entry.getOreName(), entry.getEnergyModifier()>1.5?8:5, Utils.getOreStack("plate", entry, 9));
				}
				if(Utils.doesOreNameExist("dustTiny"+entry.getOreName())) {
					ModuleIndustrialCraft.addMaceratorRecipe("plate"+entry.getOreName(), Utils.getOreStack("dustTiny", entry, 8));
				}
			}

			if(Loader.isModLoaded("magneticraft")) {
				switch(entry.getOreType()) {
				case INGOT:
				case INGOT_ORELESS:
					ModuleMagneticraft.addCrushingTableRecipe(Utils.getOreStack("ingot", entry, 1), Utils.getOreStack("plate", entry, 1));
					break;
				default:
					break;
				}
			}

			if(Loader.isModLoaded("staticpower")) {
				switch(entry.getOreType()) {
				case INGOT:
				case INGOT_ORELESS:
					ModuleStaticPower.addPlateFormerRecipe(Utils.getOreStack("plate", entry, 2), Utils.getOreStack("ingot", entry, 1));
					if(Utils.doesOreNameExist("block"+entry.getOreName())) {
						ModuleStaticPower.addPlateFormerRecipe(Utils.getOreStack("plate", entry, 18), Utils.getOreStack("block", entry, 1));
					}
					break;
				default:
					break;
				}
			}

			if(Loader.isModLoaded("advancedrocketry")) {
				switch(entry.getOreType()) {
				case INGOT:
				case INGOT_ORELESS:
					if(Utils.doesOreNameExist("block"+entry.getOreName())) {
						ModuleAdvancedRocketry.addPresserRecipe("block"+entry.getOreName(), Utils.getOreStack("plate", entry, 4), 0, 0);
					}
					break;
				default:
					break;
				}
			}
		}
	}
}
