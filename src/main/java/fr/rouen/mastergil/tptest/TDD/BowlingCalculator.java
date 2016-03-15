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
            if (i < frames.size() - 1) {
                if (frames.get(i).isSpare()) {
                    score += frames.get(i + 1).getScore(frames.get(i + 1).getS1());
                } else if (frames.get(i).isStrike()) {
                    score += frames.get(i + 1).getS1int() + frames.get(i + 1).getS2int();
                }
            }
            score += frame.getS1int() + frame.getS2int();
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