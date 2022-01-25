package com.tcn.cosmosindustry.transport.client.ter.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.tcn.cosmoslibrary.common.enums.EnumChannelSideState;
import com.tcn.cosmoslibrary.common.interfaces.blockentity.IBlockEntityChannel.Energy;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;

public class ModelEnergyChannelSurge extends Model {
	
	/**
	 * --- Center Cube ONLY ---
	 */
	private ModelPart BASE;
	private ModelPart EXTEND_HORIZONTAL;
	private ModelPart EXTEND_HORIZONTAL_NS;
	private ModelPart EXTEND_VERTICAL;
	
	
	/**
	 * --- Center Cube Connections ---
	 */
	private ModelPart SINGLE;
	private ModelPart INTERFACE_BASE;
	private ModelPart INTERFACE_NORMAL;
	private ModelPart INTERFACE_OUTPUT;
	private ModelPart INTERFACE_INPUT;
	private ModelPart DISABLED;
	
	/**
	 * ---Outer Shell ONLY ---
	 */
	private ModelPart SHELL;
	private ModelPart SHELL_HORIZONTAL;
	private ModelPart SHELL_HORIZONTAL_NS;
	private ModelPart SHELL_VERTICAL;
	
	/**
	 * ---Outer Shell Connections ---
	 */
	private ModelPart SHELL_SINGLE;
	private ModelPart SHELL_INTERFACE;


	public ModelEnergyChannelSurge() {
		super((loc) -> { return RenderType.entityCutoutNoCull(loc); });
		
		//this.texWidth = 128;
		//this.texHeight = 48;

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.BASE = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("extend_horizontal", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.EXTEND_HORIZONTAL = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("extend_horizontal_ns", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.EXTEND_HORIZONTAL_NS = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("extend_vertical", CubeListBuilder.create().texOffs(0, 36).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.EXTEND_VERTICAL = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("single", CubeListBuilder.create().texOffs(24, 0).addBox(3.0F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.SINGLE = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("interface_base", CubeListBuilder.create().texOffs(24, 12).addBox(3.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.INTERFACE_BASE = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("interface_input", CubeListBuilder.create().texOffs(46, 16).addBox(5.0F, -4.0F, -4.0F, 3.0F, 8.0F, 8.0F).mirror(), PartPose.ZERO);
			this.INTERFACE_INPUT = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("interface_output", CubeListBuilder.create().texOffs(46, 32).addBox(5.0F, -4.0F, -4.0F, 3.0F, 8.0F, 8.0F).mirror(), PartPose.ZERO);
			this.INTERFACE_OUTPUT = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("interface_normal", CubeListBuilder.create().texOffs(46, 0).addBox(5.0F, -4.0F, -4.0F, 3.0F, 8.0F, 8.0F).mirror(), PartPose.ZERO);
			this.INTERFACE_NORMAL = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("disabled", CubeListBuilder.create().texOffs(24, 24).addBox(3.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F).mirror(), PartPose.ZERO);
			this.DISABLED = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		
		/** -------------------------------------------- SURGE BEGIN ------------------------------------------- */

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(68, 0).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F).mirror(), PartPose.ZERO);
			this.SHELL = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("shell_horizontal", CubeListBuilder.create().texOffs(68, 14).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F).mirror(), PartPose.ZERO);
			this.SHELL_HORIZONTAL = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("shell_horizontal_ns", CubeListBuilder.create().texOffs(68, 28).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F).mirror(), PartPose.ZERO);
			this.SHELL_HORIZONTAL_NS = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
		

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("shell_vertical", CubeListBuilder.create().texOffs(96, 0).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F).mirror(), PartPose.ZERO);
			this.SHELL_VERTICAL = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("shell_single", CubeListBuilder.create().texOffs(96, 14).addBox(3.5F, -3.5F, -3.5F, 5.0F, 7.0F, 7.0F).mirror(), PartPose.ZERO);
			this.SHELL_SINGLE = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}

		{
			MeshDefinition meshDef = new MeshDefinition();
			PartDefinition partDef = meshDef.getRoot();
			partDef.addOrReplaceChild("shell_interface", CubeListBuilder.create().texOffs(96, 28).addBox(3.5F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F).mirror(), PartPose.ZERO);
			this.SHELL_INTERFACE = LayerDefinition.create(meshDef, 128, 48).bakeRoot();
		}
	}
	
	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		this.renderBase(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}

	public void renderBasedOnTile(Energy tile, PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		if (tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.AIR) && tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.AIR)
				&& tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.AIR) && tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.AIR)
				&& tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.AIR) && tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.AIR)) {
			this.renderBase(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} 
		
		else if (tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.INTERFACE_NO_CONN) || tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.INTERFACE_NO_CONN)
				|| tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.INTERFACE_NO_CONN) || tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.INTERFACE_NO_CONN)
				|| tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.INTERFACE_NO_CONN) || tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.INTERFACE_NO_CONN)) {
			this.renderBase(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} 
		
		else if (tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.INTERFACE_INPUT) || tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.INTERFACE_INPUT)
				|| tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.INTERFACE_INPUT) || tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.INTERFACE_INPUT)
				|| tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.INTERFACE_INPUT) || tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.INTERFACE_INPUT)) {
			this.renderBase(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} 
		
		else if (tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.INTERFACE_OUTPUT) || tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.INTERFACE_OUTPUT)
				|| tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.INTERFACE_OUTPUT) || tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.INTERFACE_OUTPUT)
				|| tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.INTERFACE_OUTPUT) || tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.INTERFACE_OUTPUT)) {
			this.renderBase(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} 
		
		else if (tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.CABLE) && tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.CABLE)
				&& !tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.CABLE) && !tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.CABLE)
				&& !tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.CABLE) && !tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.CABLE)) {
			this.renderVertical(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} 
		
		else if (tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.CABLE) && tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.CABLE)
				&& !tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.CABLE) && !tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.CABLE)
				&& !tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.CABLE) && !tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.CABLE)) {
			this.renderHorizontal(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} 
		
		else if (tile.getStateForConnection(Direction.NORTH).equals(EnumChannelSideState.CABLE) && tile.getStateForConnection(Direction.SOUTH).equals(EnumChannelSideState.CABLE)
				&& !tile.getStateForConnection(Direction.EAST).equals(EnumChannelSideState.CABLE) && !tile.getStateForConnection(Direction.WEST).equals(EnumChannelSideState.CABLE)
				&& !tile.getStateForConnection(Direction.UP).equals(EnumChannelSideState.CABLE) && !tile.getStateForConnection(Direction.DOWN).equals(EnumChannelSideState.CABLE)) {
			this.renderHorizontalNS(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		} else {
			this.renderBase(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		}
		
		this.renderSide(tile.getStateForConnection(Direction.SOUTH), -1.5707964F, 0F, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.renderSide(tile.getStateForConnection(Direction.NORTH), 1.5707964F, 0F, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		
		this.renderSide(tile.getStateForConnection(Direction.EAST), 0F, 0F, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.renderSide(tile.getStateForConnection(Direction.WEST), 3.1415927F, 0F, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		
		this.renderSide(tile.getStateForConnection(Direction.UP), 0.0F, 1.5707964F, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.renderSide(tile.getStateForConnection(Direction.DOWN), 0.0F, -1.5707964F, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}

	private void renderSide(EnumChannelSideState state, float Y, float Z, PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		this.renderSideState(state, Y, Z, matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}
	
	private void renderBase(PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		this.BASE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.SHELL.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}
	
	private void renderHorizontal(PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		this.EXTEND_HORIZONTAL.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.SHELL_HORIZONTAL.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}
	
	private void renderHorizontalNS(PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		this.EXTEND_HORIZONTAL_NS.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.SHELL_HORIZONTAL_NS.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}
	
	private void renderVertical(PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		this.EXTEND_VERTICAL.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		this.SHELL_VERTICAL.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
	}
	
	private void renderSideState(EnumChannelSideState state, float Y, float Z, PoseStack matrixStack, VertexConsumer builder, int combinedLightIn, int combinedOverlayIn, float r, float g, float b, float a) {
		if (state.equals(EnumChannelSideState.CABLE)) {
			this.SINGLE.yRot = Y;
			this.SINGLE.zRot = Z;
			this.SINGLE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
			
			this.SHELL_SINGLE.yRot = Y;
			this.SHELL_SINGLE.zRot = Z;
			this.SHELL_SINGLE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		}
		
		if (state.equals(EnumChannelSideState.CABLE_OTHER)) {
			this.SINGLE.yRot = Y;
			this.SINGLE.zRot = Z;
			this.SINGLE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		}
		
		if (state.equals(EnumChannelSideState.INTERFACE_NO_CONN)) {
			this.INTERFACE_BASE.yRot = Y;
			this.INTERFACE_BASE.zRot = Z;
			this.INTERFACE_BASE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
			
			this.SHELL_INTERFACE.yRot = Y;
			this.SHELL_INTERFACE.zRot = Z;
			this.SHELL_INTERFACE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
			
			this.INTERFACE_NORMAL.yRot = Y;
			this.INTERFACE_NORMAL.zRot = Z;
			this.INTERFACE_NORMAL.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		}
		
		if (state.equals(EnumChannelSideState.INTERFACE_INPUT)) {
			this.INTERFACE_BASE.yRot = Y;
			this.INTERFACE_BASE.zRot = Z;
			this.INTERFACE_BASE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);

			this.SHELL_INTERFACE.yRot = Y;
			this.SHELL_INTERFACE.zRot = Z;
			this.SHELL_INTERFACE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
			
			this.INTERFACE_INPUT.yRot = Y;
			this.INTERFACE_INPUT.zRot = Z;
			this.INTERFACE_INPUT.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		}
		
		if (state.equals(EnumChannelSideState.INTERFACE_OUTPUT)) {
			this.INTERFACE_BASE.yRot = Y;
			this.INTERFACE_BASE.zRot = Z;
			this.INTERFACE_BASE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);

			this.SHELL_INTERFACE.yRot = Y;
			this.SHELL_INTERFACE.zRot = Z;
			this.SHELL_INTERFACE.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
			
			this.INTERFACE_OUTPUT.yRot = Y;
			this.INTERFACE_OUTPUT.zRot = Z;
			this.INTERFACE_OUTPUT.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
		}
		
		if (state.equals(EnumChannelSideState.DISABLED)) {
			this.DISABLED.yRot = Y;
			this.DISABLED.zRot = Z;
			this.DISABLED.render(matrixStack, builder, combinedLightIn, combinedOverlayIn, r, g, b, a);
			
		}
	}
}