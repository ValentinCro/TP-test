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
                Frame nextFrame = frames.get(i + 1);
                score += nextFrame.getScore(nextFrame.getS1());
                score += nextFrame.getScore(nextFrame.getS2());
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