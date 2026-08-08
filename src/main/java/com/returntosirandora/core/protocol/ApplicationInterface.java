package com.returntosirandora.core.protocol;

import com.returntosirandora.core.runtime.RTSAssets;
import com.returntosirandora.core.runtime.RTSPath;
import com.returntosirandora.core.runtime.RTSRouter;

public interface ApplicationInterface {
    public RTSPath getPaths();

    public RTSRouter getRouter();

    public RTSAssets getAssets();
}
