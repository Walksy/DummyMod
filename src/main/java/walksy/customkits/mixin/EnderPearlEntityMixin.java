package walksy.customkits.mixin;

import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import walksy.customkits.manager.EnderPearlCollisionManager;

@Mixin(EnderPearlEntity.class)
public class EnderPearlEntityMixin {

    @Inject(method = "onCollision", at = @At("HEAD"))
    private void onCollision(HitResult hitResult, CallbackInfo ci)
    {
        EnderPearlCollisionManager.onCollision(this, hitResult, ci);
    }
}
