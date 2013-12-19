/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.PembatasanKarakter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author asus
 */
public class JTextFieldFiltering extends PlainDocument {
    public static final String NUMERIC = "0123456789";
    public static final String APLHABETIC = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXXYZ";
    public static final String PHONE = "+0123456789";
    int LIMIT;

    protected String acceptedChars = null;

    protected boolean negativeAccepted = false;

    public JTextFieldFiltering(String acceptedChars, int limit){
        this.acceptedChars = acceptedChars;
        LIMIT = limit;
    }

    public void setNegativeAccepted(boolean negativeAccepted){
        if(acceptedChars.equals(NUMERIC)){
            this.negativeAccepted = negativeAccepted;
            acceptedChars += "-";
        }
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(str == null){
            return;
        }

        for(int i = 0; i<str.length(); i++){
            if(acceptedChars.indexOf(String.valueOf(str.charAt(i))) == -1){
                return;
            }
        }

        if(negativeAccepted&&str.indexOf("-")!=-1){
            if(str.indexOf("-")!=0||offs!=0){
                return;
            }
        }

        if((getLength()+str.length())<=LIMIT){
            super.insertString(offs, str, a);
        }


    }


}
