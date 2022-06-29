package me.pixfumy.project16.structure.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.pixfumy.project16.mixin.access.StructureAccess;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RepeatDownwardsProcessor extends StructureProcessor {
    //repeats a piece downwards until it hits solid terrain - works the same as vanilla fortress pillar generation.
    public static final Codec<RepeatDownwardsProcessor> CODEC = RecordCodecBuilder.create((instance-> instance.group(Identifier.CODEC.fieldOf("structure").forGetter((repeatDownwardsProcessor -> repeatDownwardsProcessor.structureId))).apply(instance,RepeatDownwardsProcessor::new)));
    public static final StructureProcessorType<RepeatDownwardsProcessor> TYPE = Registry.register(Registry.STRUCTURE_PROCESSOR,"project16:repeat_downwards",()->CODEC);
    public final Identifier structureId;

    public RepeatDownwardsProcessor(Identifier structureId){
        this.structureId = structureId;
    }

    @Nullable
    @Override
    public Structure.StructureBlockInfo process(WorldView world, BlockPos pos, BlockPos blockPos, Structure.StructureBlockInfo structureBlockInfo, Structure.StructureBlockInfo structureBlockInfo2, StructurePlacementData structurePlacementData) {
        BlockPos.Mutable mutable = structureBlockInfo2.pos.mutableCopy();
        StructureWorldAccess structureWorldAccess = (StructureWorldAccess)world;
        Structure structure = structureWorldAccess.toServerWorld().getStructureManager().getStructure(structureId);
        int i = 0;
        Structure.StructureBlockInfo[][][] array = getStructureBlockInfo3dArray(structure);
        while(structureWorldAccess.isAir(mutable)||structureWorldAccess.getBlockState(mutable).getMaterial().isLiquid() &&mutable.getY()>1){
            Structure.StructureBlockInfo structureBlockInfo3 = array[array.length - (i % array.length)-1][structureBlockInfo.pos.getZ()][structureBlockInfo.pos.getX()];
            if(structureBlockInfo3!=null) {
                BlockState blockState = structureBlockInfo3.state;
                NbtCompound tag = structureBlockInfo3.tag;
                structureWorldAccess.setBlockState(mutable, blockState, 2);
                if (tag != null) {
                    structureWorldAccess.getBlockEntity(mutable).fromTag(blockState, tag);
                }
            }
            i++;
            mutable.move(0,-1,0);
        }
        return null;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return TYPE;
    }

    private static Structure.StructureBlockInfo[][][] getStructureBlockInfo3dArray(Structure structure){
        Vec3i size = structure.getSize();
        Structure.StructureBlockInfo[][][] array = new Structure.StructureBlockInfo[size.getY()][size.getZ()][size.getX()];
        List<Structure.StructureBlockInfo> list = ((StructureAccess) structure).getBlockInfoLists().get(0).getAll();
        for(Structure.StructureBlockInfo structureBlockInfo : list){
            array[structureBlockInfo.pos.getY()][structureBlockInfo.pos.getZ()][structureBlockInfo.pos.getX()] = structureBlockInfo;
        }
        return array;
    }
}
