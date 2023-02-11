package be.yonicon.template.usecase.customer.delete;

import be.yonicon.template.vocabulary.CustomerId;

public final class DeleteCustomerCommand {
    private final CustomerId id;

    public DeleteCustomerCommand(CustomerId id) {
        this.id = id;
    }

    public CustomerId getId() {
        return id;
    }

    public static DeleteCustomerCommand newCommand(final CustomerId id) {
        return new DeleteCustomerCommand(id);
    }
}
