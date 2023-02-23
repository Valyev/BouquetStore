package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

public class GetPriceCommand implements Command{
    private final Bouquet bouquet;

    public GetPriceCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
        @Override
    public void execute() {
        bouquet.showPrice();
    }
}
