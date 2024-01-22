package springBootDataJPA;

public class Tries {

    class Node{
        Node[] link;
        boolean endFlag;
        public Node(){
            link=new Node[26];
            endFlag=false;
        }

        public boolean containsKey(char ch) {
            return (link[ch-'a']!=null);
        }

        public void put(char ch) {
            link[ch-'a']=new Node();
        }

        public Node getLink(char ch) {
            return link[ch-'a'];
        }

        public boolean isEnd() {
            return endFlag;
        }

        public void setEnd() {
            endFlag=true;
        }
    }

    /**
     * Input
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * Output
     * [null, null, true, false, true, null, true]
     *
     * Explanation
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // return True
     * trie.search("app");     // return False
     * trie.startsWith("app"); // return True
     * trie.insert("app");
     * trie.search("app");     // return True
     */
    public class Trie {

        private  Node root;

        public Trie() {
            root=new Node();
        }

        public void insert(String word) {
            Node rootNode=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!rootNode.containsKey(ch)){
                    rootNode.put(ch);
                }
                rootNode=rootNode.getLink(ch);
            }
            rootNode.setEnd();
        }

        public boolean search(String word) {
            Node rootNode=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!rootNode.containsKey(ch)){
                    return false;
                }
                rootNode=rootNode.getLink(ch);
            }
            return rootNode.isEnd();
        }

        public boolean startsWith(String prefix) {
            Node rootNode=root;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                if(!rootNode.containsKey(ch)){
                    return false;
                }
                rootNode=rootNode.getLink(ch);
            }
            return true;
        }
    }
}
