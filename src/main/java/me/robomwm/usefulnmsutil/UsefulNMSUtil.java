package me.robomwm.usefulnmsutil;

import net.minecraft.server.v1_11_R1.EntityLiving;
import net.minecraft.server.v1_11_R1.EntityTNTPrimed;
import net.minecraft.server.v1_11_R1.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.CraftServer;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created on 3/20/2017.
 *
 * @author RoboMWM
 */
public class UsefulNMSUtil extends JavaPlugin
{
    /**
     * @implNote Uses NMS - thus is version dependent!
     * @param location
     * @param source
     * @return
     */
    public static TNTPrimed spawnSourcedTNTPrimed(Location location, LivingEntity source)
    {
        CraftServer craftServer = ((CraftServer) Bukkit.getServer());
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        World nmsWorld = craftWorld.getHandle();
        EntityLiving nmsSource = ((CraftLivingEntity)source).getHandle();
        EntityTNTPrimed newTNT = new EntityTNTPrimed(nmsWorld, location.getX(), location.getY(), location.getZ(), nmsSource);
        UsefulNMSTNTPrimed extendedTNT = new UsefulNMSTNTPrimed(craftServer, newTNT);
        extendedTNT.setSource(source);
        nmsWorld.addEntity(extendedTNT.getHandle(), CreatureSpawnEvent.SpawnReason.CUSTOM);
        return extendedTNT;
    }
}
