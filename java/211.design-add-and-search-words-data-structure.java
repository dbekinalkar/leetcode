/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class WordDictionary {

    List<int[]> trie;

    public WordDictionary() {
        this.trie = new ArrayList();
        trie.add(new int[27]);
    }
    
    public void addWord(String word) {
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
        return search(word, 0, 0);
    }

    private boolean search(String word, int i, int trieIndex) {
        if(i == word.length()) {
            return trie.get(trieIndex)[26] == -1;
        }

        char c = word.charAt(i);

        if(c != '.') {
            int nextIndex = trie.get(trieIndex)[c - 'a'];
            return nextIndex == 0 ? false : search(word, i + 1, nextIndex);
        }

        int[] trieNode = trie.get(trieIndex);

        for(int j = 0; j < 26; j++) {
            if(trieNode[j] == 0) continue;

            if(search(word, i + 1, trieNode[j])) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

