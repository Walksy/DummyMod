package walksy.customkits.manager;

import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



public class EnderPearlCollisionManager {


    public static void onCollision(Object cast, HitResult hitResult, CallbackInfo ci)
    {
        EnderPearlEntity e = EnderPearlEntity.class.cast(cast);

    }
}
