package me.robomwm.usefulnmsutil;

import net.minecraft.server.v1_11_R1.EntityTNTPrimed;
import org.bukkit.craftbukkit.v1_11_R1.CraftServer;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftTNTPrimed;
import org.bukkit.entity.LivingEntity;

/**
 * Created on 3/20/2017.
 *
 * @author RoboMWM
 */
public class UsefulNMSTNTPrimed extends CraftTNTPrimed
{
    public UsefulNMSTNTPrimed(CraftServer server, EntityTNTPrimed entity)
    {
        super(server, entity);
    }

    private LivingEntity source;

    @Override
    public LivingEntity getSource()
    {
        return source;
    }

    void setSource(LivingEntity source)
    {
        this.source = source;
    }
}
