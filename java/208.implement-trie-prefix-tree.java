/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {

    List<int[]> trie;

    public Trie() {
        trie = new ArrayList();
        trie.add(new int[27]);
    }
    
    public void insert(String word) {
        int[] trieNode = trie.get(0);
        int index;
        int trieNodeIndex;
        for(int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            trieNodeIndex = trieNode[index];
            if(trieNodeIndex == 0) {
                trieNodeIndex = trieNode[index] = this.trie.size();
                this.trie.add(new int[27]);
            }

            trieNode = this.trie.get(trieNodeIndex);
        }

        trieNode[26] = -1;
    }
    
    public boolean search(String word) {
        int[] trieNode = trie.get(0);
        int index;
        int trieNodeIndex;
        for(int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            trieNodeIndex = trieNode[index];
            if(trieNodeIndex == 0) {
                return false;
            }

            trieNode = this.trie.get(trieNodeIndex);
        }

        return trieNode[26] == -1;
    }
    
    public boolean startsWith(String prefix) {
        int[] trieNode = trie.get(0);
        int index;
        int trieNodeIndex;
        for(int i = 0; i < prefix.length(); i++) {
            index = prefix.charAt(i) - 'a';
            trieNodeIndex = trieNode[index];
            if(trieNodeIndex == 0) {
                return false;
            }

            trieNode = this.trie.get(trieNodeIndex);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

