package org.example.Practice10.components;

import org.springframework.stereotype.Component;

@Component
public final class Junior implements Programmer {

    @Override
    public void doCoding() {
        System.out.println("Alarm! Junior is coding!\n");
    }
}
