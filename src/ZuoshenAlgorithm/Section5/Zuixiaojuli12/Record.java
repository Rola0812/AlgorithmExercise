package ZuoshenAlgorithm.Section5.Zuixiaojuli12;

import java.util.HashMap;
import java.util.Map;


class Record{

    private HashMap<String,HashMap<String,Integer>> record;

    public Record(String[] strArr){
        record = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String,Integer> indexMap = new HashMap<String, Integer>();
        for(int i = 0;i!=strArr.length;i++){
            String curStr = strArr[i];
            update(indexMap,curStr,i);
            indexMap.put(curStr,i);
        }
    }

    private void update(HashMap<String, Integer> indexMap, String str, int i) {

        if(!record.containsKey(str)){
            record.put(str,new HashMap<String,Integer>());
        }
        HashMap<String,Integer> strMap = record.get(str);
        for(Map.Entry<String,Integer> lastEntry:indexMap.entrySet()){
            String key = lastEntry.getKey();
            int index = lastEntry.getValue();
            if(!key.equals(str)){
                HashMap<String,Integer> lastMap = record.get(key);
                int curMin = i-index;
            }
        }

    }

    public int minDistance(String str1,String str2){
        if(str1 == null || str2 == null){
            return -1;
        }
        if(str1.equals(str2)){
            return 0;
        }
        if(record.containsKey(str1) && record.get(str1).containsKey(str2)){
            return record.get(str1).get(str2);
        }
        return 0;
    }

}