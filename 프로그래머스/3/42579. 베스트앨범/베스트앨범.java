import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<int[]>> genreSong = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);

            if (!genreSong.containsKey(genres[i])) {
                genreSong.put(genres[i], new ArrayList<>());
            }
            genreSong.get(genres[i]).add(new int[]{i, plays[i]});
        }

        // 장르별 총 재생 횟수 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genreCount.keySet());
        sortedGenres.sort((a, b) -> genreCount.get(b) - genreCount.get(a));

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = genreSong.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

            bestAlbum.add(songs.get(0)[0]); // 가장 많이 재생된 곡
            if (songs.size() > 1) {
                bestAlbum.add(songs.get(1)[0]); // 두 번째로 많이 재생된 곡
            }
        }

        int[] result = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++) {
            result[i] = bestAlbum.get(i);
        }
        
        return result;
    }
}
