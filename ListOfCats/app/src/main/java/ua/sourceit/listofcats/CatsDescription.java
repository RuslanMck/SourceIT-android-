package ua.sourceit.listofcats;

public class CatsDescription {
    private String name;
    private String descr;
    private int imgResId;

    private CatsDescription(String name, String descr, int imgResId) {
        this.name = name;
        this.descr = descr;
        this.imgResId = imgResId;
    }

    public final CatsDescription[] catsDescr = {
            new CatsDescription("The Abyssinian", "The Abyssinian is a slender, fine-boned, medium-sized cat. " +
                    "The head is moderately wedge shaped, with a slight break at the muzzle, and nose " +
                    "and chin ideally forming a straight vertical line when viewed in profile. " +
                    "They have alert, relatively large pointed ears. The notably expressive eyes are " +
                    "almond shaped and are gold, green, hazel or copper depending on coat color. " +
                    "The legs should be long in proportion to a graceful body, with small oval paws; " +
                    "the tail is likewise long and tapering.", R.drawable.discr_cat_abyssinian),
            new CatsDescription("Exotic Shorthair", "Exotic Shorthairs have a gentle " +
                    "and calm personality reminiscent of the Persian, but are generally livelier" +
                    " than their longhaired ancestors.[3] Curious and playful, they are friendly " +
                    "to other cats and dogs, but they don't like being left alone and need the " +
                    "presence of their owner. They tend to show more affection and loyalty than " +
                    "most breeds and make excellent lap cats. Their calm, steady nature makes " +
                    "them ideal apartment cats for city dwellers.[4] Nonetheless, Exotics retain " +
                    "some of the energetic spark of the American Shorthair, and they are often " +
                    "capable mouse hunters.", R.drawable.discr_cat_exotic_shorthair)
    };

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String toStrong() {
        return this.name;
    }


}
