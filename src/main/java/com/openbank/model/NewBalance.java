
package com.openbank.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "amount"
})
public class NewBalance {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Object amount;

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("amount")
    public Object getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Object amount) {
        this.amount = amount;
    }

}
