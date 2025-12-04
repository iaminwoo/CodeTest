import java.util.*;

class Solution {
    private class Song {
        final int idx;
        final String genre;
        final int play;
        
        private Song(int i, String g, int p) {
            idx = i;
            genre = g;
            play = p;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        final int songCount = genres.length;
        
        List<Song> songs = new ArrayList<>();
        Map<String, Integer> genreTotal = new HashMap<>();
        
        for(int i = 0 ; i < songCount ; i++) {
            songs.add(new Song(i, genres[i], plays[i]));
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreSorted = new ArrayList(genreTotal.keySet());
        Collections.sort(genreSorted, (g1, g2) ->
                        genreTotal.get(g2) - genreTotal.get(g1));
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : genreSorted) {
            List<Song> genreSong = new ArrayList<>();
            
            for(Song s : songs) {
                if(genre.equals(s.genre)) genreSong.add(s);
            }
            
            Collections.sort(genreSong, (s1, s2) -> s2.play - s1.play);
            
            for(int i = 0 ; i < Math.min(2, genreSong.size()) ; i++) {
                result.add(genreSong.get(i).idx);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}