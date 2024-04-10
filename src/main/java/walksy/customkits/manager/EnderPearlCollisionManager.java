package walksy.customkits.manager;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;


public class EnderPearlCollisionManager {

    public static Map<Entity, Vec3d> collisionMade = new HashMap<>();

    public static void onCollision(Object cast, HitResult hitResult, CallbackInfo ci)
    {
        EnderPearlEntity e = EnderPearlEntity.class.cast(cast);
        collisionMade.put(e.getOwner(), hitResult.getPos());
    }
}
