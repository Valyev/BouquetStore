package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

import java.io.IOException;

public class LoadFromDatabaseCommand implements Command {
    private final Bouquet bouquet;
    public LoadFromDatabaseCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() throws IOException {
        bouquet.ReadFromDatabase();
    }
}
