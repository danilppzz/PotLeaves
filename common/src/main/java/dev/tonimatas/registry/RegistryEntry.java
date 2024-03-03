package dev.tonimatas.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public interface RegistryEntry<T> extends Supplier<T> {
    @Override
    T get();

    ResourceLocation getId();
}
