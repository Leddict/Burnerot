public class SweatLodge {

    public static void run() {

        final Network network = new Network();
        network.configure();


        Wing leftWing = new Wing();
        Wing rightWing = new Wing();
        ChickenHead head = new ChickenHead();

        TimeChangingSections timedHueAnimation = new TimeChangingSections(head, leftWing, rightWing);
        Rainbow rainbow = new Rainbow(head, leftWing, rightWing);
        Confetti confetti = new Confetti(head, leftWing, rightWing);


        // yellow
        DiscreteConstColorEffect constYellow = new DiscreteConstColorEffect(240);
        constYellow.configure(HSBColor.YELLOW);

        // red
        DiscreteConstColorEffect constRed = new DiscreteConstColorEffect(240);
        constRed.configure(HSBColor.RED);

        // alternate
//        DiscreteAlternateEffect alternateRedYellow = new DiscreteAlternateEffect(240, constRed, constYellow);
//        DiscreteSpikeEffect spike = new DiscreteSpikeEffect(240, continuousToDiscreteWing);
//        spike.configure(0, 1.3, 0.3);

//int legGroupSize = 5;
//       int counter = 0;
       while (true) {

           double timePercent = (System.currentTimeMillis() % 5000) / 5000.0;

           //timedHueAnimation.apply(timePercent);
           //rainbow.apply(timePercent);
           confetti.apply(timePercent);


           //Send to leds (beaglebone)
           System.gc();
           network.addSegment("test", leftWing.GetRGBColors(0, leftWing.GetPixelsNumber()), 0, 0);
           network.addSegment("test", head.GetRGBColors(0, head.GetPixelsNumber()), 1, 0);
           network.addSegment("test", rightWing.GetRGBColors(0, rightWing.GetPixelsNumber()), 2, 0);

           network.send();

           try {
                //delay 1,000 = 1sec
                Thread.sleep(30);        //devide 1000 in the number and you will get how many time the loop would work in a second    -   frame rate
            }
            catch (java.lang.InterruptedException interrupt) {
               System.out.println(interrupt.getMessage());
                break;
            }

       }
//---END ---//
////---SHOTING STAR filling up CHANGING COLOR - ONLY ONE WAY stay full---- START ---//
//        double bowCounter = 0.0;
//        double width = 0.0  ; //Decide on the width. if == colorsRGB.length then each the spectrum is spaces perfect.
//        width =  (width>0)? width:colorsRGB.length;
//
//
//        int counter = 0;
//        while (true) {
//            if(counter>colorsRGB.length) {
//                counter = 0;}
//
//            for (int i = 0; i <colorsRGB.length; i++) {
//                if (i==counter){
//                    for(int j=0; j<3;j++){
//
//                        colors[i].hue = (bowCounter+i)%width/width;
//                        colors[i].brightness = 1.0;
//                        colors[i].saturation = 1.0;
////System.out.println("yey  "+"i "+i+"bowCounter "+bowCounter+"counter "+counter);
//
//                    }
//                }else {
////                    colors[k].hue = 0.0;
////                    colors[k].brightness = 0.0;
////                    colors[k].saturation = 1.0;
////System.out.println("i = "+i) ;
////System.out.println(":(    "+"i "+i+"bowCounter "+bowCounter+"counter "+counter);
//                }
//
//
//            }
//            counter++;
//
//            try {
//                //delay 1,000 = 1sec
//                Thread.sleep(30);        //devide 1000 in the number and you will get how many time the loop would work in a second    -   frame rate
//            }
//            catch (java.lang.InterruptedException interrupt) {
//                break;
//            }
//
//            bowCounter++;
//
//
//            /****SEND TO LED START***/
//            for(int i=0; i<colors.length; i++) {
//                colorsRGB[i] = colors[i].toRGBColor();
//            }
//            //System.out.println("ssss");
//
//            //Send to leds (beaglebone)
//            System.gc();
//            network.addSegment("test", colorsRGB, 0, 0);
//
//            network.send();
//            /***END****/
//
//        }
////---END ---//

//



//        //!!!!!NOT WORKING RIGHT!!!!-- SHOOTING STAR TREE (3) IN A LINE - 1 WAY---- START ---//
//        double bowCounter = 0.0;
//        double width = 0.0  ; //Decide on the width. if == colorsRGB.length then each the spectrum is spaces perfect.
//        int ledSize = colorsRGB.length;
//        width =  (width>0.0)? width:ledSize;
//
//        int boom = 189;
//        int counter = 0;
//        while (true) {
//            if(counter>ledSize) {
//                counter = 0;
//            }
//
//            for (int i = 0; i <ledSize; i++) {
//                if (i==boom){
//                    for (int k=0;k < ledSize ;k++){
//                        colors[k].hue = 1.0;
//                        colors[k].brightness = 1.0;
//                        colors[k].saturation = 1.0;
//System.out.println("ledSize "+ledSize + " i "+i+" boom "+boom+" k "+k);
//
//                    }
//                    break;
//                }else {
//                    if (i == counter && i >= 3) {
//                        for (int j = i; j > i - 3; j--) {
//System.out.println("3 stars J "+j );
//
//                            colors[j].hue = (bowCounter + i) % width / width;
//                            colors[j].brightness = 1.0;
//                            colors[j].saturation = 1.0;
////ledSize"yey  "+"i "+i+"bowCounter "+bowCounter+"counter "+counter);
//
//                        }
//                    } else if (i == counter && i < 3) {
//                        colors[i].hue = (bowCounter + i) % width / width;
//                        colors[i].brightness = 1.0;
//                        colors[i].saturation = 1.0;
//System.out.println("1 star  "+i );
//                    } else {
//                        colors[i].hue = 0.0;
//                        colors[i].brightness = 0.0;
//                        colors[i].saturation = 1.0;
//
//System.out.println("off led"+i);
//                    }
//                }
//
//            }
//            counter++;
//
//            try {
//                //delay 1,000 = 1sec
//                Thread.sleep(500);        //devide 1000 in the number and you will get how many time the loop would work in a second    -   frame rate
//            }
//            catch (java.lang.InterruptedException interrupt) {
//                break;
//            }
//
//            bowCounter++;
//
//
//            /****SEND TO LED START***/
//            for(int i=0; i<colors.length; i++) {
//                colorsRGB[i] = colors[i].toRGBColor();
//            }
//            //System.out.println("ssss");
//
//            //Send to leds (beaglebone)
//            System.gc();
//            network.addSegment("test", colorsRGB, 0, 0);
//
//            network.send();
//            /***END****/
//
//        }



//---END ---//

//            try {
//                //delay 1,000 = 1sec
//                Thread.sleep(30);        //devide 1000 in the number and you will get how many time the loop would work in a second    -   frame rate
//            }
//            catch (java.lang.InterruptedException interrupt) {
//                break;
//            }


//END
//for the change between frames
//        int loopCounter = 0;
//        int intercounter = 0;
//        while(true) { //Keep in moving all the time  With the delay , together are frame rate
//
//
//            // Set colors[i] for Leds -> i is the led number.  ;
//            for(int i=0; i<colorsRGB.length; i++) {
//                //colors[i].hue = ((loopCounter+i) % 256) / 256.0; //0 = red 0.333 =green   0.666 = 7
//                //int is a full number
//                //double is 0.0 for example the same like int but with after the dot
//                //colors[i].hue = ((loopCounter) % 256) / 256.0; //0 = red 0.333 =green   0.666 = 7    //0
//                if (((intercounter+i)%5)==0){
//                    //colors[i].hue =0.55;
//                    colors[i].brightness = 0.15;
//                    colors[i].hue = ((intercounter) % 100) / 100.0;
//
//                } else{
//                    colors[i].hue =0.167 ; //0 = red 0.333 =green   0.666 = 7    //0
//                    colors[i].brightness = 0.0;//black = 0
//                }
//
//                colors[i].saturation = 1.0; //white = 0
//
//        System.out.println("i = "+i+" "+"colorIt = "+intercounter) ;
//            }
//
//            for(int i=0; i<colors.length; i++) {
//                colorsRGB[i] = colors[i].toRGBColor();
//            }
//            //System.out.println("ssss");
//
//            //Send to leds (beaglebone)
//            System.gc();
//            network.addSegment("test", colorsRGB, 0, 0);
//
//            network.send();
//
//
//            try {
//                //delay 1,000 = 1sec
//                Thread.sleep(30);        //devide 1000 in the number and you will get how many time the loop would work in a second    -   frame rate
//            }
//            catch (java.lang.InterruptedException interrupt) {
//                break;
//            }
//
//            loopCounter++;
//            intercounter++;
//        }
    }
}


