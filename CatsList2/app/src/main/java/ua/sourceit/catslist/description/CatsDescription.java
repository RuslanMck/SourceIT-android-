package ua.sourceit.catslist.description;

import ua.sourceit.catslist.R;

public class CatsDescription {
    private String name;
    private String descr;
    private int imgResId;

    private CatsDescription(String name, String descr, int imgResId) {
        this.name = name;
        this.descr = descr;
        this.imgResId = imgResId;
    }

    public static final CatsDescription[] catsDescr = {
            new CatsDescription("The Abyssinian", "The Abyssinian is a slender, fine-boned, medium-sized cat. " +
                    "The head is moderately wedge shaped, with a slight break at the muzzle, and nose " +
                    "and chin ideally forming a straight vertical line when viewed in profile. " +
                    "They have alert, relatively large pointed ears. The notably expressive eyes are " +
                    "almond shaped and are gold, green, hazel or copper depending on coat color. " +
                    "The legs should be long in proportion to a graceful body, with small oval paws; " +
                    "the tail is likewise long and tapering.", R.drawable.discr_cat_abyssinian),

            new CatsDescription("Exotic Shorthair", "Exotic Shorthairs have a gentle " +
                    "and calm personality reminiscent of the Persian, but are generally livelier" +
                    " than their longhaired ancestors. Curious and playful, they are friendly " +
                    "to other cats and dogs, but they don't like being left alone and need the " +
                    "presence of their owner. They tend to show more affection and loyalty than " +
                    "most breeds and make excellent lap cats. Their calm, steady nature makes " +
                    "them ideal apartment cats for city dwellers. Nonetheless, Exotics retain " +
                    "some of the energetic spark of the American Shorthair, and they are often " +
                    "capable mouse hunters.", R.drawable.discr_cat_exotic_shorthair),

            new CatsDescription("The Korat", "The Korat's unusual colour is actually a silver-tipped blue " +
                    "that appears to shimmer. The Thais refer to this colour as rain-cloud grey, " +
                    "and the shimmer as sea foam. This cat has a single coat that is short, with " +
                    "roots of a lighter silver blue. The hair shaft colour increases to deeper " +
                    "blue and the tips are silver, especially on the muzzle and toes. This is the " +
                    "only colour accepted for a Korat. The eyes are large and peridot green in an " +
                    "adult cat, but kittens have muddy, amber or golden-green eye coloured eyes " +
                    "hich gradually change as they become adults, at two to four years." +
                    "Although it is rare, Korats occasionally have striking or faint white " +
                    "markings or spots or even very faint grey stripes. Sometimes these spots " +
                    "increase in size with age. These are seen as flaws, and the cats are " +
                    "disqualified from competing in cat shows. However, such markings have no " +
                    "effect on personality or health.", R.drawable.discr_cat_korat),

            new CatsDescription("Ocicat", "Ocicats have almond shaped eyes, large, " +
                    "strong bodies, muscular legs with dark markings, and powerful, oval shaped " +
                    "paws. Their heads have a wedge shape, that is, longer than wide. Their ears " +
                    "are tilted at a 45 degree angle. One of the most striking things about these " +
                    "cats is the dark contrasting spots. The body shape of the Ocicat is partway " +
                    "between the svelte Oriental and the sturdy American Shorthair. The breed's " +
                    "large, well-muscled body gives an impression of power and strength, and is " +
                    "greater in weight than expected by appearance. Twelve variants in color are " +
                    "approved by most registries, including The Cat Fanciers' Association, Inc. " +
                    "standard for the Ocicat breed: tawny, chocolate and cinnamon, their dilutes, " +
                    "blue, lavender and fawn, black silver (or ebony silver), chocolate silver, " +
                    "cinnamon silver, blue silver, lavender silver and fawn silver.", R.drawable.discr_cat_ocicat),

            new CatsDescription("LaPerm", "The LaPerm is a rex breed which originated " +
                    "in the United States and is now present in many other countries worldwide. " +
                    "The breed is genetically unique and not related to any other rex cat " +
                    "varieties, having a dominant gene causing their curly coats. They have an " +
                    "elegant and athletic build and are affectionate, active and outgoing in " +
                    "character. They are reputed to be hypoallergenic cats, provoking a " +
                    "significantly lower level of allergic response in humans than normal cats. " +
                    "Their most significant feature is their coat, which is made up of soft waves, " +
                    "curls and ringlets, resembling a shaggy perm.", R.drawable.discr_cat_leperm),

            new CatsDescription("Russian White", "Russian White Cats are a medium " +
                    "sized breed of domestic cats. Russian white cats are delicate and elegant " +
                    "cat and have been a woman’s classy cat since decades. Russian White cats " +
                    "were bred in the 1970’s from Russian Blue Cats. These cats live a long life " +
                    "of 15 years. These cats are available in white, black and chocolate color. " +
                    "Russian White cats are adorned with beautiful characteristics and they use " +
                    "them for their benefit very wisely. If you have not brought her home yet or " +
                    "not much time has passed, then you will know very soon what I am saying. Try " +
                    "saying no to your cat once and then watch her use her charms to captivate you " +
                    "and give in to her demands. They are simply irresistible. You and your " +
                    "adorable cat will not face any issues when she moves in with you as they " +
                    "do not face any issues in adapting to a new home.", R.drawable.discr_cat_russian_white),

            new CatsDescription("Exotic Shorthair", "Exotic Shorthairs have a gentle " +
                    "and calm personality reminiscent of the Persian, but are generally livelier" +
                    " than their longhaired ancestors. Curious and playful, they are friendly " +
                    "to other cats and dogs, but they don't like being left alone and need the " +
                    "presence of their owner. They tend to show more affection and loyalty than " +
                    "most breeds and make excellent lap cats. Their calm, steady nature makes " +
                    "them ideal apartment cats for city dwellers. Nonetheless, Exotics retain " +
                    "some of the energetic spark of the American Shorthair, and they are often " +
                    "capable mouse hunters.", R.drawable.discr_cat_exotic_shorthair),

            new CatsDescription("Japanese Bobtail","The Japanese Bobtail is surrounded " +
                    "by many legends and traditions. A tricolored cat with a beckoning paw and a" +
                    "bobbed tail is a symbol of good fortune in Japan, and the Bobtail has been " +
                    "depicted in art and described in writing in that country for at least 1,000 " +
                    "years.His stump of a tail, which resembles a pom-pom, is the result of a " +
                    "natural genetic mutation. Other characteristics of the breed are a triangular " +
                    "head, high cheekbones, a long nose, oval eyes that may be blue or odd colored, " +
                    "and hind legs that are slightly longer than the front legs. The Japanese " +
                    "Bobtail is a small cat, weighing 5 to 10 pounds. He has a soft, silky coat " +
                    "that can be short or long and comes in a variety of colors and patterns, " +
                    "but the tricolor is most popular.", R.drawable.discr_cat_japanese_bobtail),

            new CatsDescription("Serrade Petit","Serrade Petit is a cute, little cat " +
                    "that is known for its attention seeking nature. It is slightly active and " +
                    "love to indulge in a lot of jumping and running around. At the same time, " +
                    "it does not mind lazying around when it feels like. Moreover, it is very " +
                    "important that to ensure their proper health, they are allowed to exercise " +
                    "a little. Since they love a lot of attention, when the owners participate " +
                    "in a variety of activities with them, the cats love all the adoring and " +
                    "undivided attention. These cats are also known for frequent vocalization " +
                    "wherein they indulge in a lot of meowing and sometimes unwanted and " +
                    "unnecessary crying. Training them right from the very beginning can control " +
                    "this behavior to a considerable extent.", R.drawable.discr_cat_serrade_petit),

            new CatsDescription("York Chocolate", "A hardy and athletic farm cat in " +
                    "structure and appearance, the York Chocolate is both handsome and " +
                    "distinctive, boasting nimble legs, a heavy carriage, wide-spaced, " +
                    "round-tipped ears, bright eyes in green, hazel or amber, a plumed tail and " +
                    "semi-longhaired coat. The coat should either be solid chocolate brown, " +
                    "bicolour chocolate and white or bicolour chocolate and lilac, darkening as " +
                    "the cat matures from a kitten. The coat requires moderate grooming and is " +
                    "soft and plush to the touch. The York Chocolate is a keen and capable " +
                    "climber, having developed on a farm, and possesses strong hunter instincts. " +
                    "Owning a low, rumbling purr that has been described to sound like an engine " +
                    "ticking over, the York will communicate softly with you when it wants your " +
                    "attention.",R.drawable.discr_cat_york_chocolate),
            new CatsDescription("Russian White", "Russian White Cats are a medium " +
                    "sized breed of domestic cats. Russian white cats are delicate and elegant " +
                    "cat and have been a woman’s classy cat since decades. Russian White cats " +
                    "were bred in the 1970’s from Russian Blue Cats. These cats live a long life " +
                    "of 15 years. These cats are available in white, black and chocolate color. " +
                    "Russian White cats are adorned with beautiful characteristics and they use " +
                    "them for their benefit very wisely. If you have not brought her home yet or " +
                    "not much time has passed, then you will know very soon what I am saying. Try " +
                    "saying no to your cat once and then watch her use her charms to captivate you " +
                    "and give in to her demands. They are simply irresistible. You and your " +
                    "adorable cat will not face any issues when she moves in with you as they " +
                    "do not face any issues in adapting to a new home.", R.drawable.discr_cat_russian_white),
            new CatsDescription("The Abyssinian", "The Abyssinian is a slender, fine-boned, medium-sized cat. " +
                    "The head is moderately wedge shaped, with a slight break at the muzzle, and nose " +
                    "and chin ideally forming a straight vertical line when viewed in profile. " +
                    "They have alert, relatively large pointed ears. The notably expressive eyes are " +
                    "almond shaped and are gold, green, hazel or copper depending on coat color. " +
                    "The legs should be long in proportion to a graceful body, with small oval paws; " +
                    "the tail is likewise long and tapering.", R.drawable.discr_cat_abyssinian),

            new CatsDescription("Turkish Angora","Turkish Angora cats have long, silky " +
                    "coats and elegant, sinuous bodies. Though it is known for a shimmery white " +
                    "coat, Turkish angora cats can display a variety of colors. They come in tabby " +
                    "and tabby-white, along with black with an undercoat of chocolate brown, and " +
                    "lastly smoke varieties, and are in every color other than those that indicate " +
                    "crossbreeding, such as pointed, chocolate and lavender.Eyes may be blue, " +
                    "green, amber, yellow, or heterochromatic (e.g., one blue and one amber or " +
                    "green). Ears are pointed, large and wide-set. The eyes are almond shaped " +
                    "and the profile forms two straight planes. The plumed tail is often carried " +
                    "upright, perpendicular to the back.", R.drawable.discr_cat_turkish_angora)
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
