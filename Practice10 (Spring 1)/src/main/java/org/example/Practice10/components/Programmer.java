package org.example.Practice10.components;

public sealed interface Programmer permits Junior, Middle, Senior {
    void doCoding();
}
