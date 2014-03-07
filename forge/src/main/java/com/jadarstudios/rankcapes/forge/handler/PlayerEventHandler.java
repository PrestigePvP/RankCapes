/**
 * RankCapes Forge Mod
 *
 * Copyright (c) 2013 Jacob Rhoda.
 * Released under the MIT license
 * http://github.com/jadar/RankCapes/blob/master/LICENSE
 */

package com.jadarstudios.rankcapes.forge.handler;

import com.jadarstudios.rankcapes.forge.cape.PlayerCapeProperties;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.CustomPacketRegistrationEvent;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

/**
 * This class listens for network events. Connection opening, connection
 * received, successfully logged in, etc.
 *
 * @author Jadarz
 */
public enum PlayerEventHandler
{
    INSTANCE;

    @SubscribeEvent
    public void onEntityConstruct(EntityConstructing event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            event.entity.registerExtendedProperties(PlayerCapeProperties.IDENTIFIER, new PlayerCapeProperties());
        }
    }

    @SubscribeEvent
    public void onClientChannelRegister(CustomPacketRegistrationEvent<NetHandlerPlayClient> event)
    {
        for (String channel : event.registrations)
        {
            System.out.println("Channel Registered: " + channel);
        }
    }
}
