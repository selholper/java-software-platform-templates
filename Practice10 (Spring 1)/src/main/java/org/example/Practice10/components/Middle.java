package org.example.Practice10.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class Middle implements Programmer {
    private Computer computer;

    @Override
    public void doCoding() {
        System.out.println("Be careful! Middle is codding!");
        System.out.println("His computer is " + computer.getModel() + "\n");
    }

    @Autowired
    public void setComputer(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }
}
