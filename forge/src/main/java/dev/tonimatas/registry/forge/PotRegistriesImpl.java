package dev.tonimatas.registry.forge;

import dev.tonimatas.registry.PotRegistry;
import net.minecraft.core.Registry;

@SuppressWarnings("unused")
public class PotRegistriesImpl {
    public static <T> PotRegistry<T> create(Registry<T> registry, String id) {
        return new ForgePotRegistry<>(registry, id);
    }
}
