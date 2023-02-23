package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class AddExistingRibbonCommand implements Command{
    private final Bouquet bouquet;
    public AddExistingRibbonCommand(Bouquet bouquet){
        this.bouquet = bouquet;
    }


    @Override
    public void execute() throws IOException {
        bouquet.AddExistingRibbon();
    }
}
