// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: fullnames deadcode nonlb lnc safe 
// Source File Name:   ClientProxyRender.java

package OsmiCraft.client;

import OsmiCraft.Common.CommonProxyRender;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyRender extends OsmiCraft.Common.CommonProxyRender {

            public ClientProxyRender() {
            }

            public void registerRenderThings() {
/*  15*/        net.minecraftforge.client.MinecraftForgeClient.preloadTexture("/BlockTest.png");
/*  16*/        net.minecraftforge.client.MinecraftForgeClient.preloadTexture("/ItemTest.png");
/*  17*/        net.minecraftforge.client.MinecraftForgeClient.preloadTexture("/BlastFurnaceOn");
            }
}
