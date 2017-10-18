import java.util.concurrent.Callable;

public class PenPineappleApplePen extends Song {

    public PenPineappleApplePen(Network network, WavAudioSource audio, Simulator simulator, String soundsPath) {
        super(network, audio, simulator, soundsPath);


    }
    // beat 0.88
    // 0.3 * 8
    // 7.34 * 8
    // 14.38
    // 21.27


    @Override
    protected void configure() {

        int pixelsPerSide = this.totems[0].GetPixelsNumber() / 2;

        ContinuousConstColorEffect blue = new ContinuousConstColorEffect(HSBColor.BLUE);
        ContinuousConstColorEffect red = new ContinuousConstColorEffect(HSBColor.RED);
        ContinuousConstColorEffect yellow = new ContinuousConstColorEffect(HSBColor.YELLOW);

        ContinuousSpikeEffect spikeBlue = new ContinuousSpikeEffect(blue);
        spikeBlue.configure(0.0, 2.0, 1.0);
        ContinuousSpikeEffect spikeRed = new ContinuousSpikeEffect(red);
        spikeRed.configure(1.0, -1.0, 1.0);
        ContinuousSpikeEffect spikeYellow = new ContinuousSpikeEffect(yellow);
        spikeYellow.configure(1.0, -1.0, 1.0);

        AddonAlternateColorsFromArray alternateBlueRed = new AddonAlternateColorsFromArray(new HSBColor[]{HSBColor.BLUE, HSBColor.RED}, 3, 10);
        AddonAlternateColorsFromArray alternateBlueYellow = new AddonAlternateColorsFromArray(new HSBColor[]{HSBColor.BLUE, HSBColor.YELLOW}, 3, 10);


        // pen apple
        timingsAddons.add(new AddonTiming(new AddonsContainerHalfTotems(totems, new AddonEffect[]{new AddonSetConstColor(HSBColor.BLUE), new AddonFadeInEffect()}, true), 0.3, 2.066));
        timingsAddons.add(new AddonTiming(new AddonsContainerHalfTotems(totems, new AddonEffect[]{new AddonSetConstColor(HSBColor.RED), new AddonFadeInEffect()}, false), 2.066, 3.822));

        timingsAmir.add(new AnimationTimingAmir(new AllTotemsAnimation(this.totems, spikeBlue.getAsDiscrete(pixelsPerSide), true, false), 4.675, 5.146));
        timingsAmir.add(new AnimationTimingAmir(new AllTotemsAnimation(this.totems, spikeRed.getAsDiscrete(pixelsPerSide), false, true), 4.675, 5.146));

        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{alternateBlueRed}), 5.558, 6.920));

        // pen pineapple
        timingsAddons.add(new AddonTiming(new AddonsContainerHalfTotems(totems, new AddonEffect[]{new AddonSetConstColor(HSBColor.BLUE), new AddonFadeInEffect()}, true), 7.373, 9.117));
        timingsAddons.add(new AddonTiming(new AddonsContainerHalfTotems(totems, new AddonEffect[]{new AddonSetConstColor(HSBColor.YELLOW), new AddonFadeInEffect()}, false), 9.117, 10.886));

        timingsAmir.add(new AnimationTimingAmir(new AllTotemsAnimation(this.totems, spikeBlue.getAsDiscrete(pixelsPerSide), true, false), 11.769, 12.214));
        timingsAmir.add(new AnimationTimingAmir(new AllTotemsAnimation(this.totems, spikeYellow.getAsDiscrete(pixelsPerSide), false, true), 11.769, 12.214));

        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{alternateBlueYellow}), 12.600, 13.971));

        // apple pen
        double penAnimationEnd = 15.689 + 0.3;
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{alternateBlueRed}), 14.412, penAnimationEnd));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonClearS2SEffect()}), 15.689, penAnimationEnd));

        // pineapple pen
        double pineappleAnimationEnd = 17.500 + 0.3;
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{alternateBlueYellow}), 16.143, pineappleAnimationEnd));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonClearS2SEffect()}), 17.500, pineappleAnimationEnd));

        // Ahhhh
        AddonEffect randColor = new AddonRandomColorFromList(new HSBColor[]{HSBColor.RED, HSBColor.BLUE, HSBColor.YELLOW});
        AddonRandomOnPixels randOn = new AddonRandomOnPixels(0.5);
        AddonsContainerAllTotems ahhhEffects = new AddonsContainerAllTotems(totems, new AddonEffect[]{randColor, randOn});
        timingsAddons.add(new AddonTiming(ahhhEffects, 18.820, 21.475));

        AddonCyclicMove move = new AddonCyclicMove();
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{move}), 19.715, 21.475));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.BLUE.hue, 0.25)}), 19.715, 19.944));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.YELLOW.hue, 0.25)}), 19.944, 20.623));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.RED.hue, 0.25)}), 20.623, 21.089));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.BLUE.hue, 0.25)}), 21.089, 21.475));

        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.RED.hue, 1.0)}), 21.455, 21.914));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.YELLOW.hue, 1.0)}), 22.355, 22.796));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.BLUE.hue, 1.0)}), 23.237, 23.679));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.RED.hue, 1.0)}), 24.143, 24.561));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.YELLOW.hue, 1.0)}), 25.002, 25.443));
        timingsAddons.add(new AddonTiming(new AddonsContainerAllTotems(totems, new AddonEffect[]{new AddonGlowStain(HSBColor.BLUE.hue, 1.0)}), 25.884, 26.331));
    }

    @Override
    protected String getAudioFileName() {
        return "pen.wav";
    }


    private Animation firstAnimation(boolean forward) {
        Totem totem = totems[0];
        Animation animation = new Animation();
        ContinuousWhiteEffect cwe = new ContinuousWhiteEffect();
        ContinuousRainbowEffect cre = new ContinuousRainbowEffect(cwe);
        ContinuousConstLocationOffsetEffect rainbowWithOffset = new ContinuousConstLocationOffsetEffect(cre);
        rainbowWithOffset.configure(0.5);
        ContinuousCyclicMoveEffect cme1 = new ContinuousCyclicMoveEffect(cre);
        cme1.configure(1, forward);
        ContinuousCyclicMoveEffect cme2 = new ContinuousCyclicMoveEffect(rainbowWithOffset);
        cme2.configure(1, forward);
        ContinuousToDiscrete ctd1 = new ContinuousToDiscrete(110, cme1);
        ContinuousToDiscrete ctd2 = new ContinuousToDiscrete(110, cme2);
        DiscreteAlternateEffect dsoe = new DiscreteAlternateEffect(110, ctd1, ctd2);
        dsoe.configure(4, 5);
        animation.addMapper(new EffectToObjectMapper(dsoe, totem.GetAllPixels(), totem.leftIndexes));
        animation.addMapper(new EffectToObjectMapper(dsoe, totem.GetAllPixels(), totem.leftIndexes));
        return animation;
    }
}
