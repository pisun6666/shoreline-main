package net.shoreline.client.impl.event.render.entity;

import net.minecraft.entity.LivingEntity;
import net.shoreline.client.api.event.Cancelable;
import net.shoreline.client.api.event.Event;

/**
 * @author linus
 * @since 1.0
 */
@Cancelable
public class RenderArmorEvent extends Event {
    private final LivingEntity entity;

    public RenderArmorEvent(LivingEntity entity) {
        this.entity = entity;
    }

    public LivingEntity getEntity() {
        return entity;
    }
}
