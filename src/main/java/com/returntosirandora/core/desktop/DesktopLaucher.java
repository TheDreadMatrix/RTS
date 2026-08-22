package com.returntosirandora.core.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.returntosirandora.Johnson;
import com.returntosirandora.core.RTSApplication;

public class DesktopLaucher {
        public static void launch() {
                Johnson settings = new Johnson("config/settings.json").loadData();

                Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

                config.setTitle("Return to Sirandora");

                config.setWindowIcon("assets/icon16.png", "assets/icon32.png", "assets/icon64.png");

                config.setWindowedMode(settings.get("window.width", Integer.class, 800),
                                settings.get("window.height", Integer.class, 600));

                config.setWindowSizeLimits(799, 599, 10000, 10000);

                config.setIdleFPS(10);
                config.setForegroundFPS(settings.get("window.fps", Integer.class, 60));

                config.useVsync(settings.get("window.vsync", Boolean.class, false));

                new Lwjgl3Application(new RTSApplication(settings), config);
        }
}
