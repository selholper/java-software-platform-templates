package org.example.Practice10.components;

import org.springframework.stereotype.Component;

@Component
public final class DesktopPC implements Computer {

    @Override
    public String getModel() {
        return "HP base station";
    }
}
