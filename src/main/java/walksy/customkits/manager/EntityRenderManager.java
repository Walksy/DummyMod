package walksy.customkits.manager;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

public class EntityRenderManager {

    public static void handlerRender(EntityRenderDispatcher dispatcher, Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci)
    {
        ci.cancel();
        //TODO save the coords of the play when it collides with the world, and save those coords and teleport the player instantly there
        double d = MathHelper.lerp((double)tickDelta, entity.lastRenderX, entity.getX());
        double e = MathHelper.lerp((double)tickDelta, entity.lastRenderY, entity.getY());
        double f = MathHelper.lerp((double)tickDelta, entity.lastRenderZ, entity.getZ());
        float g = MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw());
        if (EnderPearlCollisionManager.collisionMade.get(entity) == null)
        {
            dispatcher.render(entity, d - cameraX, e - cameraY, f - cameraZ, g, tickDelta, matrices, vertexConsumers, dispatcher.getLight(entity, tickDelta));
        } else {
            dispatcher.render(
                entity,
                EnderPearlCollisionManager.collisionMade.get(entity).getX() - cameraX,
                EnderPearlCollisionManager.collisionMade.get(entity).getY() - cameraY,
                EnderPearlCollisionManager.collisionMade.get(entity).getZ() - cameraZ,
                g,
                tickDelta,
                matrices,
                vertexConsumers,
                dispatcher.getLight(entity, tickDelta)
            );
        }
    }
}
