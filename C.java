package CZ.MarkoCZ.Holo;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.RandomUtils;


public class C extends Effect {

	
    public FireworkEffect.Type fireworkType = FireworkEffect.Type.BURST;
    public Color color = Color.YELLOW;
    public Color color2 = Color.YELLOW;
    public Color color3 = Color.YELLOW;
    public Color fadeColor = Color.YELLOW;
    public int intensity = 2;
    public float radius = 2;
    public int explosions = 10;
    public int soundInterval = 5;
    public float soundVolume = 100;
    public float soundPitch = 1;
    protected int step = 0;

    protected FireworkEffect firework;

    public C(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = 5;
    }

    @Override
    public void onRun() {
        if (firework == null) {
            Builder b = FireworkEffect.builder().with(fireworkType);
            b.withColor(color).withColor(color2).withColor(color3);
            b.withFade(fadeColor);
            b.trail(true);
            firework = b.build();
        }
        Location location = getLocation();
        for (int i = 0; i < explosions; i++) {
            Vector v = RandomUtils.getRandomVector().multiply(radius);
            detonate(location, v);
        }
        step++;
    }

    protected void detonate(Location location, Vector v) {
        final Firework fw = (Firework) location.getWorld().spawnEntity(location.add(v), EntityType.FIREWORK);
        location.subtract(v);
        FireworkMeta meta = fw.getFireworkMeta();
        meta.setPower(0);
        for (int i = 0; i < intensity; i++) {
            meta.addEffect(firework);
        }
        fw.setFireworkMeta(meta);
        fw.detonate();
    }
}
