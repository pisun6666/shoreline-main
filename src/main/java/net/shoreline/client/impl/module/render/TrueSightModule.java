package net.shoreline.client.impl.module.render;

import net.minecraft.entity.player.PlayerEntity;
import net.shoreline.client.api.config.Config;
import net.shoreline.client.api.config.setting.BooleanConfig;
import net.shoreline.client.api.event.listener.EventListener;
import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;
import net.shoreline.client.impl.event.render.entity.RenderEntityInvisibleEvent;

/**
 * @author xgraza
 * @since 1.0
 */
public final class TrueSightModule extends ToggleModule
{
    Config<Boolean> onlyPlayersConfig = new BooleanConfig("OnlyPlayers", "If to only reveal invisible players", true);

    public TrueSightModule()
    {
        super("TrueSight", "Allows you to see invisible entities", ModuleCategory.RENDER);
    }

    @EventListener
    public void onRenderEntityInvisible(final RenderEntityInvisibleEvent event)
    {
        if (event.getEntity().isInvisible() && (!onlyPlayersConfig.getValue() || event.getEntity() instanceof PlayerEntity))
        {
            event.cancel();
        }
    }
}
