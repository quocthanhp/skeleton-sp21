package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static final int KEYS_AMOUNT = keyboard.length();

    public static void main(String[] args) {
        GuitarString[] gt = new GuitarString[KEYS_AMOUNT];
        for (int i = 0; i < KEYS_AMOUNT; i++) {
            double frequency = 440 * Math.pow(2, (i - 24) / 12.0);
            gt[i] = new GuitarString(frequency);
        }


        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyIndex = keyboard.indexOf(key);

                if (keyIndex > 0) {
                    gt[keyIndex].pluck();
                }

            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (GuitarString g : gt) {
                sample += g.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString g : gt) {
                g.tic();
            }
        }
    }
}
