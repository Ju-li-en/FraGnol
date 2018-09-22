package fr.ciavaldini.android.apprendreespagnal;

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;

    private String MotEspagnol;
    private String MotFrancais;
    private int imageId = NO_IMAGE_PROVIDED;
    private int audioId;


    public Word(String espagnol, String francais, int audio) {
        this(espagnol,francais,audio, NO_IMAGE_PROVIDED);
    }

    public Word(String espagnol, String francais,int audio, int image) {
        this.MotEspagnol = espagnol;
        this.MotFrancais = francais;
        this.imageId = image;
        this.audioId = audio;
    }

    @Override
    public String toString() {
        return "Word{" +
                "MotEspagnol='" + MotEspagnol + '\'' +
                ", MotFrancais='" + MotFrancais + '\'' +
                ", imageId=" + imageId +
                ", audioId=" + audioId +
                '}';
    }

    public int getAudioId() {
        return audioId;
    }

    public int getImage() {
        return imageId;
    }

    public void setImage(int imageId) {
        this.imageId = imageId;
    }

    public boolean hasImage() {
        return imageId != NO_IMAGE_PROVIDED;
    }

    public String getMotEspagnol() {
        return MotEspagnol;
    }

    public void setMotEspagnol(String motEspagnol) {
        this.MotEspagnol = motEspagnol;
    }

    public String getMotFrancais() {
        return MotFrancais;
    }

    public void setMotFrancais(String motFrancais) {
        this.MotFrancais = motFrancais;
    }
}
