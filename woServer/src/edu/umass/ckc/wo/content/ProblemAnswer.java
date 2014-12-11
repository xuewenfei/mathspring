package edu.umass.ckc.wo.content;

import edu.umass.ckc.wo.cache.ProblemMgr;
import net.sf.json.JSONObject;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: marshall
 * Date: 12/5/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProblemAnswer {

    private String val;
    private String letter;
    private String hint;
    private boolean distractor;
    private int probId;

    public ProblemAnswer(String val, String letter, String hint, boolean distractor, int probId) {
        this.val = val;
        this.letter = letter;
        this.hint = hint;
        this.distractor = distractor;
        this.probId = probId;
    }


    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isDistractor() {
        return distractor;
    }

    public void setDistractor(boolean distractor) {
        this.distractor = distractor;
    }

    public int getProbId() {
        return probId;
    }

    public void setProbId(int probId) {
        this.probId = probId;
    }

    public JSONObject getJSON(JSONObject jo) {
        Problem p = null;
        try {
            p = ProblemMgr.getProblem(getProbId());
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (p != null && p.isQuickAuth() && p.isMultiChoice()) {
            jo.element(letter, val);

        }

        return jo;
    }
}