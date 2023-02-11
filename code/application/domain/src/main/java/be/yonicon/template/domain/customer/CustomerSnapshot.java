package be.yonicon.template.domain.customer;

import be.yonicon.template.vocabulary.CustomerDTO;
import be.yonicon.template.vocabulary.CustomerId;

public final class CustomerSnapshot {
    private final CustomerId id;
    private final CustomerDTO dto;

    public CustomerSnapshot(CustomerId id, CustomerDTO dto) {
        this.id = id;
        this.dto = dto;
    }

    public CustomerId getId() {
        return id;
    }

    public CustomerDTO getDto() {
        return dto;
    }
}
