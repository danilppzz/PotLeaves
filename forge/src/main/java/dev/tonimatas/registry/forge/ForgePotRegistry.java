package dev.tonimatas.registry.forge;

import dev.tonimatas.registry.PotRegistry;
import dev.tonimatas.registry.RegistryEntries;
import dev.tonimatas.registry.RegistryEntry;
import net.minecraft.core.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.function.Supplier;

public class ForgePotRegistry<T> implements PotRegistry<T> {
    private final DeferredRegister<T> register;
    private final RegistryEntries<T> entries = new RegistryEntries<>();

    public ForgePotRegistry(Registry<T> registry, String id) {
        this.register = DeferredRegister.create(registry.key(), id);
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return this.entries.add(new ForgeRegistryEntry<>(register.register(id, supplier)));
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return this.entries.getEntries();
    }

    @Override
    public void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        register.register(bus);
    }
}