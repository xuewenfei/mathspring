package edu.umass.ckc.wo.event.tutorhut;

import ckc.servlet.servbase.ActionEvent;
import ckc.servlet.servbase.ServletParams;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 11/11/15
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetQuickAuthProblemEvent extends TutorHutEvent {
    int probId;


    public GetQuickAuthProblemEvent(ServletParams p) throws Exception {
        super(p);
        probId = p.getInt("probId");
    }

    public int getProbId() {
        return probId;
    }
}
