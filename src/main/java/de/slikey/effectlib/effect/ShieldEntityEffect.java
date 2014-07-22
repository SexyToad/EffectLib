package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class ShieldEntityEffect extends EntityEffect {
    /**
     * ParticleType of spawned particle
     */
    public ParticleEffect particle = ParticleEffect.FLAME;

    /**
     * Radius of the shield
     */
    public int radius = 3;

    /**
     * Particles to display
     */
    public int particles = 50;

    /**
     * Set to false for a half-sphere and true for a complete sphere
     */
    public boolean sphere = false;

    public ShieldEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        type = EffectType.REPEATING;
        iterations = 500;
        period = 1;
    }

    @Override
    public void onRun() {
        Location location = entity.getLocation();
        for (int i = 0; i < particles; i++) {
            Vector vector = RandomUtils.getRandomVector().multiply(radius);
            if (!sphere)
                vector.setY(Math.abs(vector.getY()));
            location.add(vector);
            particle.display(location, visibleRange);
            location.subtract(vector);
        }
    }

}
