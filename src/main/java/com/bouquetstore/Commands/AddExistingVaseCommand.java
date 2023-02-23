package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class AddExistingVaseCommand implements Command{
    private final Bouquet bouquet;
    public AddExistingVaseCommand(Bouquet bouquet){
        this.bouquet = bouquet;
    }

    @Override
    public void execute() throws IOException {
        bouquet.AddExistingVase();
    }
}
