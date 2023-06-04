package ecs.components;

import util.ImageUtil;
import util.math.Transform;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class Sprite extends Component<Sprite> {

    private static final HashMap<String, Sprite> sprites = new HashMap<>();

    private final String nameId;
    private BufferedImage image;

    public static Sprite getSprite(File spriteFile) {
        String spriteName = spriteFile.getAbsolutePath();
        if (!Sprite.containsSprite(spriteName))
            Sprite.sprites.put(spriteName, new Sprite(spriteFile));
        return Sprite.sprites.get(spriteName);
    }

    public static Sprite getSprite(String spriteName, BufferedImage image) {
        if (!Sprite.containsSprite(spriteName)) {
            return new Sprite(spriteName, image);
        }
        return Sprite.sprites.get(spriteName);
    }

    public static void removeSprite(String spriteId) {
        Sprite.sprites.remove(spriteId);
    }

    public static boolean containsSprite(String spriteName) {
        return Sprite.sprites.containsKey(spriteName);
    }

    private Sprite(File spriteFile) {
        super("Sprite");
        this.nameId = spriteFile.getAbsolutePath();
        this.image = ImageUtil.loadImage(spriteFile);
    }

    private Sprite(String spriteName, BufferedImage image) {
        super("Sprite");
        this.nameId = spriteName;
        this.image = image;
    }

    public int getWidth() {
        return this.image.getWidth();
    }

    public int getHeight() {
        return this.image.getHeight();
    }

    public String getNameId() {
        return nameId;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g2) {
        Transform transform = gameObj.transform;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToIdentity();
        affineTransform.translate(transform.position.x, transform.position.y);
        affineTransform.rotate(
            Math.toRadians(transform.rotation),
    image.getWidth() * transform.scale.x / 2,
    image.getHeight() * transform.scale.y / 2
        );
        affineTransform.scale(transform.scale.x, transform.scale.y);
        g2.drawImage(image, affineTransform, null);
    }
}
