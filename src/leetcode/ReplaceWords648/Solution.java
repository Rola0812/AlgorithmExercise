package leetcode.ReplaceWords648;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static String replaceWords(List<String> dict,String sentence){

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<dict.size();i++){
            Trie.insert(dict.get(i));
        }
        for(int j = 0;j<words.length;j++){
            if(Trie.hasPrefix(words[j])!=-1){
                words[j] = words[j].substring(0,Trie.hasPrefix(words[j])+1);
            }
        }
        for(int i = 0;i<words.length-1;i++){
            sb.append(words[i]+" ");
        }
        sb.append(words[words.length-1]);
        return sb.toString();

    }

    public static void main(String[] args) {
        List<String> dict = new LinkedList<String>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");

        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

        System.out.println(Solution.replaceWords(dict,sentence));
    }

}

class Trie{
    static TrieNode root = new TrieNode(' ');

    public static void insert(String word){
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.childs[c-'a'] == null){
                node.childs[c-'a']  = new TrieNode(c);
            }
            node = node.childs[c-'a'];
        }
        node.isword = true;
    }

    public static int hasPrefix(String word){
        TrieNode node = root;
        int prefixNum = 0;
        for(int i = 0;i<word.length()&&!node.isword;i++){
            char c = word.charAt(i);
            if(node.childs[c-'a'] == null){
                return -1;
            }
            node = node.childs[c-'a'];
            prefixNum = i;
        }
        return prefixNum;
    }

}

class TrieNode{
    char val;
    boolean isword;
    TrieNode[] childs = new TrieNode[26];

    public TrieNode(){

    }
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
