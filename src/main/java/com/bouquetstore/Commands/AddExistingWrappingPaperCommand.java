package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class AddExistingWrappingPaperCommand implements Command{
    Bouquet bouquet;
    public AddExistingWrappingPaperCommand(Bouquet bouquet){
        this.bouquet = bouquet;
    }

    @Override
    public void execute() throws IOException {
        bouquet.AddExistingWrappingPaper();
    }
}
