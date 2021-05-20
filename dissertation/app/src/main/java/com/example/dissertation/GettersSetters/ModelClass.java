package com.example.dissertation.GettersSetters;

import android.graphics.Bitmap;

public class ModelClass {


    public ModelClass() { }
    private ModelClass(String strings, String Description, String image) { this.strings = strings;this.Description = Description; this.Image = image;}

    private String strings;

    private String question;
    //private Bitmap question_image;
    private String question_image;
    private String answer_option_1;
    private String answer_option_2;
    private String answer_option_3;
    private String answer_option_4;
    private int answerNr;
    private String hint;

    private String Description;
    private String Image;

    public ModelClass(String strings){ this.strings = strings; }
    public String getStrings() { return strings; }
    public void setStrings(String strings) { this.strings = strings; }

    public ModelClass(String question, String question_image, String answer_option_1, String answer_option_2, String answer_option_3, String answer_option_4, int answerNr, String hint) {
        this.question = question;
        this.question_image = question_image;
        this.answer_option_1 = answer_option_1;
        this.answer_option_2 = answer_option_2;
        this.answer_option_3 = answer_option_3;
        this.answer_option_4 = answer_option_4;
        this.answerNr = answerNr;
        this.hint = hint;
    }
    public ModelClass(String question, String question_image, String answer_option_1, String answer_option_2, String answer_option_3, String answer_option_4, int answerNr) {
        this.question = question;
        this.question_image = question_image;
        this.answer_option_1 = answer_option_1;
        this.answer_option_2 = answer_option_2;
        this.answer_option_3 = answer_option_3;
        this.answer_option_4 = answer_option_4;
        this.answerNr = answerNr;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion_image() {
        return question_image;
    }
    public void setQuestion_image(String question_image) {
        this.question_image = question_image;
    }
    public String getAnswer_option_1() {
        return answer_option_1;
    }
    public void setAnswer_option_1(String answer_option_1) {
        this.answer_option_1 = answer_option_1;
    }
    public String getAnswer_option_2() { return answer_option_2; }
    public void setAnswer_option_2(String answer_option_2) {
        this.answer_option_2 = answer_option_2;
    }
    public String getAnswer_option_3() {
        return answer_option_3;
    }
    public void setAnswer_option_3(String answer_option_3) {
        this.answer_option_3 = answer_option_3;
    }
    public String getAnswer_option_4() {
        return answer_option_4;
    }
    public void setAnswer_option_4(String answer_option_4) {
        this.answer_option_4 = answer_option_4;
    }
    public int getAnswerNr() {
        return answerNr;
    }
    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
    public String getHint() { return hint; }
    public void setHint(String hint) { this.hint = hint; }

    public ModelClass(String description, String image) { this.Description = description;this.Image = image; }
    public static ModelClass Description(String description){ return new ModelClass(null,description,null); } //new


    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }
    public String getImage() { return Image; } //new
    public void setImage(String image) { Image = image; } //new

}
