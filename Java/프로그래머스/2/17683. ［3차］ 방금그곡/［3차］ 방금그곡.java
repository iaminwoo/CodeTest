import java.util.*;

class Solution {
    private class Song {
        String name;
        int length;
        String[] notes;
        
        private Song(String n, int l, String[] ns) {
            this.name = n;
            this.length = l;
            this.notes = ns;
        }
    }
    
    private int getMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    private String[] getNotes(String song) {
        int l = song.length();
        int sharpCount = 0;
        for (int i = 0 ; i < l ; i++) {
            if (song.charAt(i) == '#') sharpCount++;
        }
        
        String[] originalNotes = new String[l - sharpCount];
        
        int sharp = 0;
        for (int i = 0 ; i < originalNotes.length ; i++) {
            String s = "" + song.charAt(i + sharp);
            if (i + sharp < song.length() - 1 && song.charAt(i + sharp + 1) == '#') {
                s = s + song.charAt(i + sharp + 1);
                sharp++;
            }
            originalNotes[i] = s;
        }
        
        return originalNotes;
    }
    
    private String[] getPlayed(int start, int end, String song) {
        String[] originalNotes = getNotes(song);
        String[] result = new String[end - start];
        
        for (int i = 0 ; i < end - start ; i++) {
            result[i] = originalNotes[i % originalNotes.length];
        }
        
        return result;
    }
    
    private boolean checkSong(String[] heard, String[] notes) {
        boolean match = false;
        for (int i = 0 ; i < notes.length ; i++) {
            for (int j = 0 ; j < heard.length ; j++) {
                if (i + j >= notes.length) break;
                if (!heard[j].equals(notes[i + j])) break;
                
                if (j == heard.length - 1) match = true;
            }
            if (match) break;
        }
        return match;
    }
    
    public String solution(String m, String[] musicinfos) {
        String[] heard = getNotes(m);
        
        List<Song> list = new ArrayList<>();
        for (String mi : musicinfos) {
            String[] parts = mi.split(",");
            int start = getMinute(parts[0]);
            int end = getMinute(parts[1]);
            
            String[] notes = getPlayed(start, end, parts[3]);
            String name = parts[2];
            
            Song song = new Song(name, end - start, notes);
            
            list.add(song);
        }
        
        List<Song> result = new ArrayList<>();
        int max = 0;
        for (Song song : list) {
            if (heard.length > song.length) continue;
            
            String[] notes = song.notes;
            
            if (checkSong(heard, notes)) {
                result.add(song);
                max = Math.max(max, song.length);
            }
        }
        
        List<Song> answer = new ArrayList<>();
        for (Song song : result) {
            if (song.length >= max) answer.add(song);
        }
        
        if (answer.isEmpty()) return "(None)";
        
        return answer.get(0).name;
    }
}