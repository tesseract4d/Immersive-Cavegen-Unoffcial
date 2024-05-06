package net.tclproject.immersivecavegen.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.tclproject.immersivecavegen.misc.GamemodeTab;

public class BlockGlowlily extends BlockLilyPad {
  public BlockGlowlily() {
    float f = 0.5F;
    float f1 = 0.015625F;
    setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    setCreativeTab(GamemodeTab.tabCaves).setHardness(0.0F).setLightLevel(0.3F).setStepSound(Block.soundTypeGrass).setBlockName("glowLily");
  }

  @SideOnly(Side.CLIENT)
  public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
    return 16777215;
  }

  @SideOnly(Side.CLIENT)
  public int getBlockColor() {
    return 16777215;
  }

  @SideOnly(Side.CLIENT)
  public int getRenderColor(int p_149741_1_) {
    return 16777215;
  }

  public int getRenderType() {
    return 23;
  }

  public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
    if (p_149743_7_ == null || !(p_149743_7_ instanceof net.minecraft.entity.item.EntityBoat))
      super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
  }

  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
    return AxisAlignedBB.getBoundingBox(x + this.getBlockBoundsMinX(), y + this.getBlockBoundsMinY(), z + this.getBlockBoundsMinZ(), x + this.getBlockBoundsMaxX(), y + this.getBlockBoundsMaxY(), z + this.getBlockBoundsMaxZ());
  }

  public boolean func_149854_a(Block p_149854_1_) {
    return (p_149854_1_ == Blocks.water);
  }

  public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
    if (p_149718_1_.getBlock(p_149718_2_, p_149718_3_ + 1, p_149718_4_) == this || p_149718_1_.getBlock(p_149718_2_, p_149718_3_ + 2, p_149718_4_) == this || p_149718_1_.getBlock(p_149718_2_, p_149718_3_, p_149718_4_) == this)
      return true;
    if (p_149718_3_ >= 0 && p_149718_3_ < 256 && p_149718_1_.getBlock(p_149718_2_, p_149718_3_, p_149718_4_).getMaterial() == Material.water && p_149718_1_.getBlockMetadata(p_149718_2_, p_149718_3_, p_149718_4_) == 0)
      if (p_149718_1_.getBlock(p_149718_2_, p_149718_3_ + 1, p_149718_4_).getMaterial() == Material.water && p_149718_1_.getBlockMetadata(p_149718_2_, p_149718_3_ + 1, p_149718_4_) == 0) {
        p_149718_1_.setBlock(p_149718_2_, p_149718_3_ + 2, p_149718_4_, this);
      } else {
        p_149718_1_.setBlock(p_149718_2_, p_149718_3_ + 1, p_149718_4_, this);
      }
    return false;
  }
}
