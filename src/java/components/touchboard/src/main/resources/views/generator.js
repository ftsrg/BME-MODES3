#!/usr/bin/env node

for (let rowIndex = 0; rowIndex < 4; rowIndex++) {
    for (let columnIndex = 0; columnIndex < 8; columnIndex++) {
        const index = (rowIndex * 8 + columnIndex + 1)
        if (index !== 32) {
            const label = index.toString().padStart(2, "0")
            const button = 
            `<Button fx:id="segment_${index}" onAction="#handleSegmentPress" maxHeight="1.7976931348623157E308" maxWidth="1.7976931348623157E308" text="S${label}" mnemonicParsing="false" GridPane.rowIndex="${rowIndex}" GridPane.columnIndex="${columnIndex}">
                <graphic>
                    <ImageView fitHeight="32.0" fitWidth="32.0" opacity="0.19" pickOnBounds="true" preserveRatio="true"/>
                </graphic>
            </Button>`;
            console.log(button);   
        }
    }
}