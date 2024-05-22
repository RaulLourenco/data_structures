// Jukebox
//     attributes:
//         - color
//         - quantity of songs
//         - brand
//         - CDs 
//     methods:
//         - play/pause music
//         - next music
//         - change CD
//         - up/down volume

//my implementation of the Jukebox design question
public class Jukebox {
    private String color;
    private int qttSongs;
    private String brand;
    private List<CD> cds;
    private CD currentCD;
    private int indexCd;
    private int indexSong = 0;
    private int volume = 0;

    public Jukebox(int color, int qttSongs, String brand...) {...}

    public void playMusic(int iCD, int iSong) {
        indexCd = iCD;
        indexSong = iSong;
        currentCD = cds.get(indexCd);
        qttSongs = currentCD.getQttSongs();
        
        currentCD.playMusic(true, indexSong);
    }

    public void pauseMusic() {
        currentCD.playMusic(false);
    }
    
    public void nextMusic() {
        indexSong++;
        currentCD.playMusic(true, indexSong);
    }

    public CD changeCD(int index) {
        indexCd = index;
        currentCD = cds.get(indexCd);
        return currentCD;
    }

    public void volume(boolean upVol) {
        if(upVol) {
            volume++;
        } else {
            if(volume != 0) {
                volume--;
            }
        }
    }

    public String getBrand() {
        return brand;
    }
    public int getQttSongs() {
        return qttSongs;
    }
    public int getColor() {
        return color;
    }
}

public class CD {
    private List<String> songs;
    private String currentTrack;
    private String nextTrack;
    private boolean play;

    public void playMusic(boolean play, int indexSong) {
        if(play) {
            this.play = true;
            currentTrack = songs.get(indexSong);
            if(indexSong + 1 < songs.size()) {
                nextTrack = songs.get(indexSong + 1);
            }
        } else {
            this.play = false;
        }
    }
    
    public int getQttSongs() {
        return songs.size();
    }
}