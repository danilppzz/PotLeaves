package dev.tonimatas.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import org.apache.commons.lang3.NotImplementedException;

@SuppressWarnings("unused")
public class PotRegistries {
    @ExpectPlatform
    public static <T> PotRegistry<T> create(Registry<T> registry, String id) {
        throw new NotImplementedException();
    }
}
