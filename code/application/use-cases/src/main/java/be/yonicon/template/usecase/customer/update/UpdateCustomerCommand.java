package be.yonicon.template.usecase.customer.update;

import be.yonicon.template.vocabulary.CustomerDTO;
import be.yonicon.template.vocabulary.CustomerId;

public final class UpdateCustomerCommand {
    private final CustomerId id;
    private final CustomerDTO dto;

    public UpdateCustomerCommand(CustomerId id, CustomerDTO dto) {
        this.id = id;
        this.dto = dto;
    }

    public CustomerId getId() {
        return id;
    }

    public CustomerDTO getDto() {
        return dto;
    }

    public static UpdateCustomerCommand newCommand(final CustomerId id, final CustomerDTO dto) {
        return new UpdateCustomerCommand(id, dto);
    }
}
