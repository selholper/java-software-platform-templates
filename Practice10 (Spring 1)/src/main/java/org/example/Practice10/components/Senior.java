package org.example.Practice10.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class Senior implements Programmer {
    private final Computer computer;

    @Autowired
    public Senior(@Qualifier("desktopPC") Computer computer) {
        this.computer = computer;
    }

    @Override
    public void doCoding() {
        System.out.println("Don't disturb! Senior is codding!");
        System.out.println("His computer is " + computer.getModel() + "\n");
    }
}
