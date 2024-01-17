package org.apache.jmeter.util;

import java.util.Properties;

import edu.illinois.ConfigTracker;

public class CtestRunnerProperties extends Properties {

    @Override
    public String getProperty(String key) {
        // Custom
        ConfigTracker.markParamAsUsed(this.hashCode(), this::setProperty, key);

        // Get the property value using the super class method
        return super.getProperty(key);
    }

    @Override
    public synchronized Object setProperty(String key, String value) {
        // Custom
        ConfigTracker.markParamAsSet(key);

        // Get the property value using the super class method
        return super.setProperty(key, value);
    }
}
