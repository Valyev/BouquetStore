package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class LoadBouquetCommand implements Command{
    private final Bouquet bouquet;

    public LoadBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() throws IOException {
        bouquet.LoadBouquet();
    }
}
