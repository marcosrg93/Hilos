package com.rubinogarcia.ctohilos.ctohilos;

/**
 * Created by marco on 21/08/2015.
 */
public class AnchorToDmc {

    private long id;
    private  String anchor, dmc;


    //1 Constructor predeterminado
    public AnchorToDmc() {
        this(0,"", "");

    }

    //2 Constructor completo
    public AnchorToDmc( long id, String anchor, String dmc) {
        this.id = id;
        this.anchor = anchor;
        this.dmc = dmc;
    }

    //3 Constructor completo
    public AnchorToDmc(String anchor, String dmc) {
        this.id = 0;
        this.anchor = anchor;
        this.dmc = dmc;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getDmc() {
        return dmc;
    }

    public void setDmc(String dmc) {
        this.dmc = dmc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnchorToDmc that = (AnchorToDmc) o;

        if (anchor != null ? !anchor.equals(that.anchor) : that.anchor != null) return false;
        return !(dmc != null ? !dmc.equals(that.dmc) : that.dmc != null);

    }

    @Override
    public int hashCode() {
        int result = anchor != null ? anchor.hashCode() : 0;
        result = 31 * result + (dmc != null ? dmc.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "AnchorToDmc{" +
                "anchor='" + anchor + '\'' +
                ", dmc='" + dmc + '\'' +
                '}';
    }
}