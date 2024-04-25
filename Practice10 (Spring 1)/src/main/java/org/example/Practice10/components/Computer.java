package org.example.Practice10.components;

public sealed interface Computer permits Laptop, DesktopPC {
    String getModel();
}
