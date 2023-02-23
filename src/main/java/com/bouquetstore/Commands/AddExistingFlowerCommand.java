package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class AddExistingFlowerCommand implements Command{
    private final Bouquet bouquet;

    public AddExistingFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() throws IOException {
        bouquet.AddExistingFlower();
    }
}
