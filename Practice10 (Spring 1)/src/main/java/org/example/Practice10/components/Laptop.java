package org.example.Practice10.components;

import org.springframework.stereotype.Component;

@Component
public final class Laptop implements Computer {
    @Override
    public String getModel() {
        return "Apple MacBook";
    }
}
