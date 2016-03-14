package fr.rouen.mastergil.tptest.TDD;


import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    //See http://warwickbowling.50webs.com/calculator.html


    public int score(String feuilleDeScore) {
        final List<Frame> frames = extractFrameFromString(feuilleDeScore);
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            score += frame.getS1int();
            score += frame.getS2int();
            if (frame.isSpare() || frame.isStrike()) {
                if (i == frames.size() - 1) {
                    score += frame.getS3int();
                } else {
                    Frame nextFrame = frames.get(i + 1);
                    score += nextFrame.getScore(nextFrame.getS1());
                    if (frame.isStrike()) {
                        if (nextFrame.isStrike()) {
                            Frame nextNextFrame = frames.get(i + 2);
                            score += nextNextFrame.getScore(nextNextFrame.getS1());
                        }

                        if (nextFrame.isSpare()) {
                            score += 10 - nextFrame.getScore(nextFrame.getS1());
                        } else {
                            score += nextFrame.getS2int();
                        }
                    }
                }
            }
        }
        return score;
    }


    List<Frame> extractFrameFromString(String feuilleDeScore) {
        final List<Frame> frames = new ArrayList<Frame>();
        final String[] split = feuilleDeScore.split(";");
        for (int i = 0; i < split.length; i++) {
            frames.add(new Frame(split[i]));
        }
        return frames;
    }



}