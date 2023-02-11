package be.yonicon.template.config.properties;

import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public class CustomerProperties {
    private final String backend;

    public CustomerProperties(String backend) {
        this.backend = backend;
    }

    public String getBackend() {
        return backend;
    }
}
