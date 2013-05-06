/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.msg;

import java.util.Locale;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos
 */
public class controleIntern {

    private Locale currentLocale = new Locale("pt", "BR");

    public void englishLocale() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = Locale.US;
        viewRoot.setLocale(currentLocale);
    }

    public void portugueseLocale() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = new Locale("pt", "BR");
        viewRoot.setLocale(currentLocale);
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }
}
