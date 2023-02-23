package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;

public class DeleteVaseCommand implements Command{
        private final Bouquet bouquet;

    public DeleteVaseCommand(Bouquet bouquet) {
            this.bouquet = bouquet;
        }

    @Override
    public void execute() {bouquet.deleteVase();}
}

