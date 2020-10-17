package teletubbies.world.gen.feature.structure;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import teletubbies.config.WorldGenConfig;

public class DomeStructure extends Structure<NoFeatureConfig> {

	public DomeStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}
	
	// https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.15.x/src/main/java/com/telepathicgrunt/structuretutorial/world/features/structures/RunDownHouseStructure.java
	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> generator, Random rand, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
		int maxDistance = WorldGenConfig.DOME_MAX_CHUNKS.get();
		int minDistance = WorldGenConfig.DOME_MIN_CHUNKS.get();
		
		int xTemp = x + maxDistance * spacingOffsetsX;
		int ztemp = z + maxDistance * spacingOffsetsZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;

		((SharedSeedRandom) rand).setLargeFeatureSeedWithSalt(generator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + rand.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + rand.nextInt(maxDistance - minDistance);

		return new ChunkPos(validChunkX, validChunkZ);
	}
	
	@Override
	public IStartFactory getStartFactory() {
		return Start::new;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public String getStructureName() {
		return this.getRegistryName().toString();
	}
	
	protected int getSeedModifier() {
		return 8351309;
	}
    
	@Override
	public boolean canBeGenerated(BiomeManager manager, ChunkGenerator<?> generator, Random rand, int chunkX, int chunkZ, Biome biome) {
		ChunkPos chunkpos = this.getStartPositionForPosition(generator, rand, chunkX, chunkZ, 0, 0);
		int centerY = generator.getHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
        final BlockPos centerPos = new BlockPos(chunkX * 16, centerY - 3, chunkZ * 16);

		if (chunkX == chunkpos.x && chunkZ == chunkpos.z) {			
			Biome biome_TinkyWinky = manager.getBiome(centerPos.add(-16, 0, -16));
			Biome biome_Dipsy = manager.getBiome(centerPos.add(15, 0, -16));
			Biome biome_LaaLaa = manager.getBiome(centerPos.add(15, 0, 15));
			Biome biome_Po = manager.getBiome(centerPos.add(-16, 0, 15));
						
			if (generator.hasStructure(biome_TinkyWinky, this) &&
					generator.hasStructure(biome_Dipsy, this) &&
					generator.hasStructure(biome_LaaLaa, this) &&
					generator.hasStructure(biome_Po, this)) {
				
		        int height_TinkyWinky = generator.getHeight(centerPos.getX() - 16, centerPos.getZ() - 16, Heightmap.Type.WORLD_SURFACE_WG);
		        int height_Dipsy = generator.getHeight(centerPos.getX() + 12, centerPos.getZ() - 16, Heightmap.Type.WORLD_SURFACE_WG);
		        int height_LaaLaa = generator.getHeight(centerPos.getX() + 12, centerPos.getZ() + 14, Heightmap.Type.WORLD_SURFACE_WG);
		        int height_Po = generator.getHeight(centerPos.getX() - 16, centerPos.getZ() + 14, Heightmap.Type.WORLD_SURFACE_WG);
		        
		        if (Math.abs(centerY - height_TinkyWinky) <= 3 &&
		    		Math.abs(centerY - height_Dipsy) <= 3 &&
					Math.abs(centerY - height_LaaLaa) <= 3 &&
					Math.abs(centerY - height_Po) <= 3) {
		        	return true;
		        }
			}
		}
		return false;
	}
   
	public static class Start extends StructureStart {
		
		public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox mbb, int reference, long seed) {
			super(structure, chunkX, chunkZ, mbb, reference, seed);
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager manager, int chunkX, int chunkZ, Biome biome) {
            int centerY = generator.getHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
            final BlockPos centerPos = new BlockPos(chunkX * 16, centerY - 3, chunkZ * 16);
			
	        this.components.add(new DomePieces.Piece(manager, DomePieces.DOME_TINKYWINKY, centerPos.add(-16, 0, -16)));
	        this.components.add(new DomePieces.Piece(manager, DomePieces.DOME_DIPSY, centerPos.add(0, 0, -16)));
	        this.components.add(new DomePieces.Piece(manager, DomePieces.DOME_LAALAA, centerPos));
	        this.components.add(new DomePieces.Piece(manager, DomePieces.DOME_PO, centerPos.add(-16, 0, 0)));
	        
			this.recalculateStructureSize();
		}
	}
}
