package be.yonicon.template.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static java.util.Optional.ofNullable;

@ConfigurationProperties("be.yonicon.template.infra")
@ConstructorBinding
public class InfraProperties {

    @NestedConfigurationProperty
    private final SecurityProperties security;

    @NestedConfigurationProperty
    private final CustomerProperties customer;

    public InfraProperties(SecurityProperties security,
                           CustomerProperties customer) {
        this.security = security;
        this.customer = customer;
    }

    public boolean isSecurityEnabled() {
        return ofNullable(security)
                .map(SecurityProperties::isEnabled)
                .orElse(false);
    }

    public boolean isCustomerInMemorySet() {
        return ofNullable(customer)
                .map(CustomerProperties::getBackend)
                .map("inmem"::equals)
                .orElse(false);
    }
}
