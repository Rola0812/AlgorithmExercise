package leetcode.AddandSearchWord211;


class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
public class WordDictionary {

    TrieNode root;

    public WordDictionary(){
        root = new TrieNode();
        root.val = ' ';
    }

    public void addWord(String word){
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode(c);
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word){

        boolean res = search(root,word);
        return res;
    }

    public boolean search(TrieNode node,String word){

        TrieNode trieNode = node;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(int j = 0;j<trieNode.children.length;j++){
                    if(trieNode.children[j] != null){
                        word = word.substring(i+1);
                        return search(trieNode.children[j],word);
                    }
                }
            }else {
                if(trieNode.children[c-'a'] == null){
                    return false;
                }
                trieNode = trieNode.children[c-'a'];
            }
        }
        return trieNode.isWord;
    }



    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("addword");

//        System.out.println(dictionary.search("pad"));
//        System.out.println(dictionary.search("bad"));
//        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("a."));
    }
}
