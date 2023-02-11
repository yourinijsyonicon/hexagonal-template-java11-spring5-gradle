package be.yonicon.template.config.properties;

import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public class SecurityProperties {
    private final boolean enabled;

    public SecurityProperties(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
