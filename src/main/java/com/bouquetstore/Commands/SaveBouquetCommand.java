package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class SaveBouquetCommand implements Command{
    private final Bouquet bouquet;

    public SaveBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() throws IOException {
        bouquet.SaveBouquet();
    }
}
