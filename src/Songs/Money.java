import jdk.nashorn.internal.codegen.CompilerConstants;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Money extends Song{

    public Money(Network network, WavAudioSource audio, Simulator simulator, String soundsPath, KeyPedServer keyPedServer) {
        super(false, network, audio, simulator, soundsPath, keyPedServer);
    }

    @Override
    protected void configure() {

        this.addNote(1.543, 4, false);
        this.addNote(1.837, 2, false);
        this.addNote(2.151, 1, false);
        this.addNote(2.854, 2, false);
        this.addNote(3.169, 1, false);
        this.addNote(3.8, 2, false);
        this.addNote(4.135, 4, true);

        this.addNote(5.489, 4, false);
        this.addNote(5.814, 2, false);
        this.addNote(6.118, 1, false);
        this.addNote(6.769, 2, false);
        this.addNote(7.084, 1, false);
        this.addNote(7.766, 2, false);
        this.addNote(8.112, 4, true);

        this.addNote(9.413, 4, false);
        this.addNote(9.728, 2, false);
        this.addNote(10.033, 3, false);
        this.addNote(10.368, 4, false);
        this.addNote(10.725, 5, false);
        this.addNote(11.061, 6, true);

        this.addNote(11.763, 5, false);
        this.addNote(12.082, 4, false);
        this.addNote(12.424, 4, false);
        this.addNote(12.756, 3, false);
        this.addNote(13.069, 1, true);

        Totem totems036[] = new Totem[] {totems[0], totems[3], totems[6]};
        Totem totems147[] = new Totem[] {totems[1], totems[4], totems[7]};
        Totem totems25[] = new Totem[] {totems[2], totems[5]};
        Totem totemsLeft[] = new Totem[] {totems[0], totems[1], totems[2], totems[3]};
        Totem totemsRight[] = new Totem[] {totems[7], totems[6], totems[5], totems[4]};

        Callable<AddonEffect> moneyGreen = () -> new AddonSetConstColor(HSBColor.GREEN);
        Callable<AddonEffect> moneyGreenLight = () -> new AddonSetConstColor(new HSBColor(HSBColor.GREEN.hue, 0.8, 1.0));
        Callable<AddonEffect> confetti = () -> new AddonConfetti(5.0, 0.2, true);
        Callable<AddonEffect> spikeClear = () -> new AddonSpike(1.0, -0.2, 0.2, true);
        Callable<AddonEffect> spikeUp = () -> new AddonSpike(0.0, 2.0, 1.0, false);
        Callable<AddonEffect> black = () -> new AddonSetConstColor(HSBColor.BLACK);
        Callable<AddonEffect> blur = () -> new AddonBlur();
        Callable<AddonEffect> rainbow = () -> new AddonRainbow();
        Callable<AddonEffect> glitterUp = () -> new AddonSaturationGlitter(2.0, 0.05);
        Callable<AddonEffect> fadeIn = () -> new AddonFadeInEffect();
        Callable<AddonEffect> fadeOut = () -> new AddonFadeOut(0.0);
        Callable<AddonEffect> clear = () -> new AddonClearS2SEffect();

        Callable<AddonEffect> alterRedGreen = () -> new AddonAlternateColorsFromArray(new HSBColor[]{HSBColor.RED, HSBColor.GREEN}, 3, 10);

        // its not about the
        addTiming(14.073, 16.998, new AddonsContainerAllTotems(totems, Arrays.asList(moneyGreen, confetti)));

        // money 1
        addTiming(14.926, 15.377, new AddonsContainerAllTotems(totems036, Arrays.asList(spikeClear)));
        addTiming(15.377, 16.998, new AddonsContainerAllTotems(totems036, Arrays.asList(black)));

        // money 2
        addTiming(15.377, 15.959, new AddonsContainerAllTotems(totems147, Arrays.asList(spikeClear)));
        addTiming(15.959, 16.998, new AddonsContainerAllTotems(totems147, Arrays.asList(black)));

        // money 3
        addTiming(15.959, 16.998, new AddonsContainerAllTotems(totems25, Arrays.asList(spikeClear)));


        // we don't need your
        addTiming(16.998, 19.393, new AddonsContainerAllTotems(totems, Arrays.asList(moneyGreenLight, blur, confetti)));

        // money 1
        addTiming(17.678, 18.139, new AddonsContainerAllTotems(totems036, Arrays.asList(spikeClear)));
        addTiming(18.139, 19.393, new AddonsContainerAllTotems(totems036, Arrays.asList(black)));

        // money 2
        addTiming(18.139, 18.627, new AddonsContainerAllTotems(totems147, Arrays.asList(spikeClear)));
        addTiming(18.627, 19.393, new AddonsContainerAllTotems(totems147, Arrays.asList(black)));

        // money 3
        addTiming(18.627, 19.393, new AddonsContainerAllTotems(totems25, Arrays.asList(spikeClear)));

        // we just wanna make the
        addTiming(19.393, 25.205, new AddonsContainerAllTotems(totems, Arrays.asList(rainbow)));
        addTiming(19.393, 20.409, new AddonsContainerAllTotems(totems, Arrays.asList(fadeIn)));

        // worllllld dance
        addTiming(20.409, 22.119, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // forget about the
        // priceeeee tag
        addTiming(23.072, 25.205, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // ain't about the
        addTiming(25.205, 26.581, new AddonsContainerAllTotems(totems, Arrays.asList(alterRedGreen)));
        // uh
        addTiming(26.241, 26.581, new AddonsContainerAllTotems(totems, Arrays.asList(clear)));
        // ch-ching 1
        addTiming(26.910, 27.060, new AddonsContainerAllTotems(new Totem[]{totems[0], totems[2]}, Arrays.asList(moneyGreen, blur, fadeOut)));
        addTiming(27.060, 27.448, new AddonsContainerAllTotems(new Totem[]{totems[1], totems[3]}, Arrays.asList(moneyGreen, blur, fadeOut)));
        // ch-ching 2
        addTiming(27.448, 27.574, new AddonsContainerAllTotems(new Totem[]{totems[0], totems[2]}, Arrays.asList(moneyGreen, blur, fadeOut)));
        addTiming(27.574, 27.952, new AddonsContainerAllTotems(new Totem[]{totems[1], totems[3]}, Arrays.asList(moneyGreen, blur, fadeOut)));

        // ain't about the
        addTiming(27.952, 29.329, new AddonsContainerAllTotems(totems, Arrays.asList(alterRedGreen)));
        // uh
        addTiming(28.977, 29.329, new AddonsContainerAllTotems(totems, Arrays.asList(clear)));
        // bl-bing 1
        addTiming(29.683, 29.872, new AddonsContainerAllTotems(new Totem[]{totems[4], totems[6]}, Arrays.asList(moneyGreen, blur, fadeOut)));
        addTiming(29.872, 30.216, new AddonsContainerAllTotems(new Totem[]{totems[5], totems[7]}, Arrays.asList(moneyGreen, blur, fadeOut)));
        // bl-bing 2
        addTiming(30.216, 30.378, new AddonsContainerAllTotems(new Totem[]{totems[4], totems[6]}, Arrays.asList(moneyGreen, blur, fadeOut)));
        addTiming(30.378, 30.706, new AddonsContainerAllTotems(new Totem[]{totems[5], totems[7]}, Arrays.asList(moneyGreen, blur, fadeOut)));

        // we just wanna make the
        addTiming(30.706, 36.196, new AddonsContainerAllTotems(totems, Arrays.asList(rainbow)));
        addTiming(30.706, 31.383, new AddonsContainerAllTotems(totems, Arrays.asList(fadeIn)));

        // worllllld dance
        addTiming(31.383, 33.116, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // forget about the
        // priceeeee tag
        addTiming(34.126, 35.870, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));
        addTiming(35.870, 36.196, new AddonsContainerAllTotems(totems, Arrays.asList(fadeOut)));

        // start of new part
        Callable<AddonEffect> purple = () -> new AddonSetConstColor(HSBColor.PURPLE);
        Callable<AddonEffect> pink = () -> new AddonSetConstColor(HSBColor.PINK);
        Callable<AddonEffect> pinkAndPurple = () -> new AddonAlternateSmooth(HSBColor.PINK.hue, HSBColor.PURPLE.hue, 3);

        // we need to take it back in
        addTiming(36.196, 40.828, new AddonsContainerAllTotems(totems, Arrays.asList(purple)));
        addTiming(36.196, 38.089, new AddonsContainerAllTotems(totems, Arrays.asList(fadeIn)));
        // time
        //addTiming(39.600, 40.828, new AddonsContainerAllTotems(totems, Arrays.asList(fadeOutToHalf)));
        // beat
        addTiming(40.314 - 0.2, 40.314 + 0.2, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // when music made us all
        addTiming(40.828, 43.389, new AddonsContainerAllTotems(totems, Arrays.asList(purple)));
        // unite
        //addTiming(42.003, 43.058, new AddonsContainerAllTotems(totems, Arrays.asList(fadeOutToHalf)));
        // beat
        addTiming(43.058 - 0.2, 43.058 + 0.2, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // and it wasn't low
        addTiming(43.389, 46.327, new AddonsContainerAllTotems(totems, Arrays.asList(purple)));
        // blows
        addTiming(44.422, 44.422 + 0.2, new AddonsContainerAllTotems(totemsLeft, Arrays.asList(clear)));
        addTiming(44.422 + 0.2, 46.327, new AddonsContainerAllTotems(totemsLeft, Arrays.asList(black)));
        // and video
        // hoes
        addTiming(45.796, 45.796 + 0.2, new AddonsContainerAllTotems(totemsRight, Arrays.asList(clear)));
        addTiming(45.796 + 0.2, 46.327, new AddonsContainerAllTotems(totemsRight, Arrays.asList(black)));

        // am i the only one
        addTiming(46.327, 49.203 - 0.4, new AddonsContainerAllTotems(totems, Arrays.asList(purple)));
        addTiming(46.327, 48.170 - 0.2, new AddonsContainerAllTotems(totems, Arrays.asList(fadeIn)));
        addTiming(48.170, 49.203 - 0.4, new AddonsContainerAllTotems(totems, Arrays.asList(confetti, fadeOut)));


        // why is everybody so obsessed
        addTiming(49.203, 51.955, new AddonsContainerAllTotems(totems, Arrays.asList(pink)));
        // beat
        addTiming(51.287 - 0.2, 51.287 + 0.2, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // money can't buy us happiness
        addTiming(51.955, 54.329, new AddonsContainerAllTotems(totems, Arrays.asList(pink)));
        // beat
        addTiming(54.015 - 0.2, 54.015 + 0.2, new AddonsContainerAllTotems(totems, Arrays.asList(glitterUp)));

        // can we all slow
        addTiming(54.329, 57.051, new AddonsContainerAllTotems(totems, Arrays.asList(pink)));
        // down
        addTiming(55.391, 55.391 + 0.2, new AddonsContainerAllTotems(totemsLeft, Arrays.asList(clear)));
        addTiming(55.391 + 0.2, 57.051, new AddonsContainerAllTotems(totemsLeft, Arrays.asList(black)));
        // and enjoy right
        // now
        addTiming(56.761, 56.761 + 0.2, new AddonsContainerAllTotems(totemsRight, Arrays.asList(clear)));
        addTiming(56.761 + 0.2, 57.051, new AddonsContainerAllTotems(totemsRight, Arrays.asList(black)));

        // guarantee we'll be feeling alright
        addTiming(57.051, 60.204 - 0.4, new AddonsContainerAllTotems(totems, Arrays.asList(pink)));
        addTiming( 57.051, 58.555 - 0.2, new AddonsContainerAllTotems(totems, Arrays.asList(fadeIn)));
        addTiming(58.555, 60.204 - 0.4, new AddonsContainerAllTotems(totems, Arrays.asList(confetti, fadeOut)));

        Callable<AddonEffect> glowBlue = () -> new AddonGlowStain(HSBColor.BLUE.hue, 1.0);
        Callable<AddonEffect> blue = () -> new AddonSetConstColor(HSBColor.BLUE);
        addTiming(60.204, 61.5, new AddonsContainerTotemsCircle(totemsRight, Arrays.asList(glowBlue)));
        addTiming(60.204, 62.253, new AddonsContainerAllTotems(totemsLeft, Arrays.asList(blue, fadeIn)));

        addTiming(62.880, 64.080, new AddonsContainerTotemsCircle(totemsLeft, Arrays.asList(glowBlue)));
        addTiming(62.880, 64.987, new AddonsContainerAllTotems(totemsRight, Arrays.asList(blue, fadeIn)));

        // can you feel it
        // yeah
        addTiming(66.357, 67.007, new AddonsContainerAllTotems(totems, Arrays.asList(rainbow, spikeUp)));
        // we're playing with love tonight
        addTiming(67.007, 68.969, new AddonsContainerAllTotems(totems, Arrays.asList(rainbow)));
        addTiming(67.007, 68.000, new AddonsContainerTotemsCircle(totems, Arrays.asList(fadeIn)));
        addTiming(68.000, 68.969, new AddonsContainerTotemsCircle(totems, Arrays.asList(fadeOut)));

        // its not about the
        addTiming(68.969, 71.613, new AddonsContainerAllTotems(totems, Arrays.asList(moneyGreen, confetti)));

        // money 1
        addTiming(69.776, 70.229, new AddonsContainerAllTotems(totems036, Arrays.asList(spikeClear)));
        addTiming(70.229, 71.613, new AddonsContainerAllTotems(totems036, Arrays.asList(black)));

        // money 2
        addTiming(70.229, 70.821, new AddonsContainerAllTotems(totems147, Arrays.asList(spikeClear)));
        addTiming(70.821, 71.613, new AddonsContainerAllTotems(totems147, Arrays.asList(black)));

        // money 3
        addTiming(70.821, 71.613, new AddonsContainerAllTotems(totems25, Arrays.asList(spikeClear)));

    }

    private void addNote(double noteTime, int totemIndex, boolean isLongNote) {

        Totem singleTot[] = new Totem[] {totems[totemIndex]};

        Callable<AddonEffect> noteColor = () -> new AddonSetConstColor(noteToColor[totemIndex]);
        Callable<AddonEffect> fadeOut = () -> new AddonFadeOut(0.0);

        double noteEndTime = noteTime + 0.315;
        if(isLongNote) {
            noteEndTime = noteEndTime + 0.315;
        }
        addTiming(noteTime, noteEndTime, new AddonsContainerAllTotems(singleTot, Arrays.asList(noteColor, fadeOut)));
    }

    @Override
    protected String getAudioFileName() {
        return "money.wav";
    }

    static final HSBColor noteToColor[] = {HSBColor.BLACK,
            new HSBColor(0.0 - 3 * 0.05, 1.0, 1.0),
            new HSBColor(0.0 - 2 * 0.05, 1.0, 1.0),
            new HSBColor(0.0 - 1 * 0.05, 1.0, 1.0),
            new HSBColor(0.0 + 0 * 0.05, 1.0, 1.0),
            new HSBColor(0.0 + 1 * 0.05, 1.0, 1.0),
            new HSBColor(0.0 + 2 * 0.05, 1.0, 1.0),
            HSBColor.BLACK};


}





