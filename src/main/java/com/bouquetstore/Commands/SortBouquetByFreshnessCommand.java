package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

public class SortBouquetByFreshnessCommand implements Command {
    private final Bouquet bouquet;

    public SortBouquetByFreshnessCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        bouquet.sortByFreshness();
    }
}
