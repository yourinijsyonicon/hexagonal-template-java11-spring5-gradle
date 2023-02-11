package be.yonicon.template.view.customer;

import be.yonicon.template.view.customer.content.request.CustomerContentRequest;
import be.yonicon.template.view.customer.content.response.CustomerContentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CustomerRestApi", produces = "application/json", consumes = "application/json")
public interface CustomerRestApi {
    @ApiOperation(value = "Gets a list of all customers", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customers listed")
    })
    @GetMapping("/customer")
    List<CustomerContentResponse> getCustomers();

    @ApiOperation(value = "Gets the customer by id", response = CustomerContentResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer found"),
            @ApiResponse(code = 404, message = "Customer not found")
    })
    @GetMapping("/customer/{customerId}")
    CustomerContentResponse getCustomer(final String customerId);

    @ApiOperation(value = "Creates a new customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Customer created"),
            @ApiResponse(code = 409, message = "Conflicting input")
    })
    @PostMapping("/customer")
    void createCustomer(@Valid final CustomerContentRequest customerContent);

    @ApiOperation(value = "Updates an existing customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer updated"),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 409, message = "Conflicting input")
    })
    @PutMapping("/customer/{customerId}")
    void updateCustomer(final String customerId, @Valid final CustomerContentRequest customerContent);

    @ApiOperation(value = "Deletes an existing customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer deleted"),
            @ApiResponse(code = 404, message = "Customer not found")
    })
    @DeleteMapping("/customer/{customerId}")
    void deleteCustomer(final String customerId);
}
