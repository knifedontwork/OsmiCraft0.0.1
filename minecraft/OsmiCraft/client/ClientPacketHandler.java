// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: fullnames deadcode nonlb lnc safe 
// Source File Name:   ClientPacketHandler.java

package OsmiCraft.client;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;


public class ClientPacketHandler
    implements cpw.mods.fml.common.network.IPacketHandler {

            public ClientPacketHandler() {
            }

            

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
