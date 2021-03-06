package gregtech.common.blocks;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.util.DebugRenderer;
import gregtech.common.blocks.tileentity.TileEntityCableEmitter;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.PooledMutableBlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlockCable extends Block implements ITileEntityProvider {

    public final long maxVoltage;
    public final long maxAmperage;
    public final long cableLoss;

    public BlockCable(long maxVoltage, long maxAmperage, int cableLoss) {
        super(Material.IRON);
        this.maxVoltage = maxVoltage;
        this.maxAmperage = maxAmperage;
        this.cableLoss = cableLoss;
        setHardness(6.0f);
        setResistance(8.0f);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        //on neighbour change, update only ourselves
        //since network can detect it's blocks updates itself
        refreshSelfState(worldIn, pos);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        //on being added to world, update ourselves and
        //notify network to recalculate connections
        refreshSelfState(worldIn, pos);
        notifyNetworkAboutRefresh(worldIn, pos);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
        //on being removed from world, just notify
        //network to recalculate connections
        notifyNetworkAboutRefresh(worldIn, pos);
    }

    private void refreshSelfState(World world, BlockPos selfPos) {
        boolean shouldPlaceEmitter = false;
        PooledMutableBlockPos mutableBlockPos = PooledMutableBlockPos.retain(selfPos);
        for(EnumFacing facing : EnumFacing.VALUES) {
            mutableBlockPos.move(facing);
            EnumFacing opposite = facing.getOpposite();
            IBlockState blockState = world.getBlockState(mutableBlockPos);
            if(blockState.getBlock().hasTileEntity(blockState)) {
                TileEntity tileEntity = world.getTileEntity(mutableBlockPos);
                IEnergyContainer container = tileEntity == null ? null :
                    tileEntity.getCapability(IEnergyContainer.CAPABILITY_ENERGY_CONTAINER, opposite);
                if(container != null && container.outputsEnergy(opposite)) {
                    shouldPlaceEmitter = true;
                    break;
                }
            }
            mutableBlockPos.move(opposite);
        }
        mutableBlockPos.release();
        //remove emitter if we don't have inputs, or add if we have inputs and it doesn't exist
        TileEntity currentTileEntity = world.getTileEntity(selfPos);
        if(shouldPlaceEmitter) {
            if(!(currentTileEntity instanceof TileEntityCableEmitter)) {
                TileEntityCableEmitter tileEntityCableEmitter = new TileEntityCableEmitter();
                world.setTileEntity(selfPos, tileEntityCableEmitter);
                tileEntityCableEmitter.refreshConnections();
            }
        } else if(currentTileEntity instanceof TileEntityCableEmitter) {
            world.removeTileEntity(selfPos);
        }

    }

    private void notifyNetworkAboutRefresh(World world, BlockPos initialPos) {
        PooledMutableBlockPos currentPos = PooledMutableBlockPos.retain(initialPos.getX(), initialPos.getY(), initialPos.getZ());
        List<BlockPos> visited = new ArrayList<>();
        Stack<EnumFacing> moveStack = new Stack<>();
        while(true) {
            for(EnumFacing facing : EnumFacing.VALUES) {
                currentPos.move(facing);
                EnumFacing opposite = facing.getOpposite();
                if (!visited.contains(currentPos)) {
                    visited.add(currentPos.toImmutable());
                } else {
                    currentPos.move(opposite);
                    continue;
                }
                if(world.getBlockState(currentPos).getBlock() instanceof BlockCable) {
                    world.setBlockState(currentPos.up(), Blocks.LOG.getDefaultState());
                    //if we are cable, move forward, and update emitter, if we has one
                    TileEntityCableEmitter emitter = (TileEntityCableEmitter) world.getTileEntity(currentPos);
                    if(emitter != null) emitter.refreshConnections();
                    moveStack.push(opposite);
                    continue;
                }
                //move back if we aren't cable and din't continue
                currentPos.move(opposite);
            }
            //if we didn't found any cable, go back, or return
            if(!moveStack.isEmpty()) {
                currentPos.move(moveStack.pop());
            } else break;
        }
        //DebugRenderer.blockPosSet = ImmutableSet.copyOf(visited);
        currentPos.release();
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null; //do not create tileentity by default
    }

}
