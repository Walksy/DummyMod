package walksy.customkits.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import walksy.customkits.manager.EnderPearlCollisionManager;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin {

    @Inject(method = "render", at = @At("HEAD"))
    public <E extends Entity> void renderOverride(E entity, double x, double y, double z, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci)
    {
        if (EnderPearlCollisionManager.collisionMade.get(entity) != null)
        {
            if (x == EnderPearlCollisionManager.collisionMade.get(entity).getX() && y == EnderPearlCollisionManager.collisionMade.get(entity).getY() && z == EnderPearlCollisionManager.collisionMade.get(entity).getZ())
            {
                EnderPearlCollisionManager.collisionMade.remove(entity);
            }
        }
    }
}
