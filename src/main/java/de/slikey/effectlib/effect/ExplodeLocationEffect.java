package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.Sound;

public class ExplodeLocationEffect extends LocationEffect {

    /**
     * Amount of spawned smoke-sparks
     */
    public int amount = 25;

    /**
     * Movement speed of smoke-sparks. Should be increases with force.
     */
    public float speed = .5f;

    public ExplodeLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        type = EffectType.INSTANT;
    }

    @Override
    public void onRun() {
        location.getWorld().playSound(location, Sound.EXPLODE, 4.0F, (1.0F + (RandomUtils.random.nextFloat() - RandomUtils.random.nextFloat()) * 0.2F) * 0.7F);
        ParticleEffect.EXPLODE.display(location, visibleRange, 0, 0, 0, speed, amount);
        ParticleEffect.HUGE_EXPLOSION.display(location, visibleRange, 0, 0, 0, 0, amount);
    }

}
