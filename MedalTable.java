import java.util.*;

public class MedalTable {
    public String[] generate(String[] results) {
        Map<String, Country> medalTable = new HashMap<>();
        for (String result : results) {
            String[] medaler = result.split(" ");
            for (String s : medaler) {
                medalTable.putIfAbsent(s, new Country(s));
            }
            medalTable.get(medaler[0]).addGold();
            medalTable.get(medaler[1]).addSilver();
            medalTable.get(medaler[2]).addBronze();
        }
        Comparator<Country> byGolds = Comparator.comparing(Country::getGolds).reversed();
        Comparator<Country> bySilvers = Comparator.comparing(Country::getSilvers).reversed();
        Comparator<Country> byBronzes = Comparator.comparing(Country::getBronzes).reversed();
        Comparator<Country> byNames = Comparator.comparing(Country::getName);
        Comparator<Country> comper = byGolds.thenComparing(bySilvers).thenComparing(byBronzes).thenComparing(byNames);
        ArrayList<Country> sorting = new ArrayList<>(medalTable.values());
        Collections.sort(sorting, comper);
        String[] sorted = new String[medalTable.values().size()];
        for(int i=0; i < medalTable.values().size(); i++){
            Country current = sorting.get(i);
            sorted[i] = current.getName() + " " + current.getGolds() + " " + current.getSilvers() + " " + current.getBronzes();
        }
        return sorted;
    }

    public class Country{
        private String name;
        private int golds, silvers, bronzes;

        public Country(String name){
            this.name = name;
            golds = 0;
            silvers = 0;
            bronzes = 0;
        }

        public String getName(){
            return name;
        }
        public int getGolds(){
            return golds;
        }
        public int getSilvers(){
            return silvers;
        }
        public int getBronzes(){
            return bronzes;
        }
        public void addGold(){
            golds++;
        }
        public void addSilver(){
            silvers++;
        }
        public void addBronze(){
            bronzes++;
        }
    }
}
