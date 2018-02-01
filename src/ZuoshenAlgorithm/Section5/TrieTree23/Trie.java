package ZuoshenAlgorithm.Section5.TrieTree23;

public class Trie {

    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        if(word == null){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i = 0;i<chars.length;i++){
            index = chars[i]-'a';
            if(node.map[index] == null){
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word){
        if(word == null){
            return false;
        }
        TrieNode node = root;
        int index = 0;
        char[] chars = word.toCharArray();
        for(int i = 0;i<word.length();i++){
            index = chars[i]-'a';
            if(node.map[index] == null){
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public void delete(String word){
        if(!search(word)){
            return;
        }
        char[] chars = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            index = chars[i]-'a';
            if(node.map[index].path-- == 1){
                node.map[index] = null;
                return;
            }
            node = node.map[index];
        }
        node.end--;
    }

    public int prefixNumver(String pre){
        if(pre == null){
            return -1;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        for(int i = 0;i<chars.length;i++){
            int index = chars[i]-'a';
            if(node.map[index] == null){
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }
}

class TrieNode{

    public int path;
    public int end;
    public TrieNode[] map;

    public TrieNode(){
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }

}
