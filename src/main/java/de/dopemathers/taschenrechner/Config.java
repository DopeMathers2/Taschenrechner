package de.dopemathers.taschenrechner;

import java.util.Locale;

public class Config
{

    public Locale language;
    public String design;

    public Config(Locale language, String design)
    {
        this.design = design;
        this.language = language;
    }

    public Locale getLanguage()
    {
        return language;
    }

    public String getDesign()
    {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "design: " + design + " language: " + language;
    }


}
