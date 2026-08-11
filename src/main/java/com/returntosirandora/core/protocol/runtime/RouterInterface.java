package com.returntosirandora.core.protocol.runtime;

import java.util.List;

public interface RouterInterface {
    public void redirectingTo(String sceneName);

    public String getName();

    public List<String> getAllScenes();
}
