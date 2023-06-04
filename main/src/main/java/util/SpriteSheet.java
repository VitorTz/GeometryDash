package util;

import ecs.components.Sprite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class SpriteSheet {

    private final ArrayList<Sprite> sprites;
    private Color color = null;

    public SpriteSheet(File spriteSheetFile, Dimension spriteSize, int spacing) {
        this.sprites = new ArrayList<>();
        Sprite sheet = Sprite.getSprite(spriteSheetFile);
        String sheetName = sheet.getNameId().split("\\.")[0];
        int rows = sheet.getHeight() / spriteSize.height;
        int columns = sheet.getWidth() / spriteSize.width;

        int count = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                int left = (j * spacing) + (j * spriteSize.width);
                int top = (i * spacing) + (i * spriteSize.height);
                BufferedImage img = sheet.getImage().getSubimage(left, top, spriteSize.width, spriteSize.height);
                this.sprites.add(Sprite.getSprite(sheetName + "_" + count, img));
                count++;
            }
        }

        Sprite.removeSprite(sheet.getNameId());
    }

    public SpriteSheet(File spriteSheetFile, Dimension spriteSize, int spacing, Color color) {
        this(spriteSheetFile, spriteSize, spacing);
        this.paintSpriteSheet(color);
    }

    public void paintSpriteSheet(Color color) {
        if (this.color == null)
            this.sprites.forEach(s -> ImageUtil.paint(s.getImage(), color, 200));
        else if (this.color != color)
            this.sprites.forEach(s -> ImageUtil.paint(s.getImage(), this.color, color));
        this.color = color;
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public Sprite get(int index) {
        return this.sprites.get(index);
    }
}
