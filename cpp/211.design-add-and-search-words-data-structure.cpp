/*
 * @lc app=leetcode id=211 lang=cpp
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
struct Vertex {
    int next[26] = {};
    bool output = false;
};

class WordDictionary {
public:
    WordDictionary() : trie_(1) {
        
    }
    
    void addWord(string word) {
        int v = 0;

        for(char ch : word) {
            int c = ch - 'a';
            if(!trie_[v].next[c]) {
                trie_[v].next[c] = trie_.size();
                trie_.push_back({});
            }

            v = trie_[v].next[c];
        }

        trie_[v].output = true;
    }
    
    bool search(string word) {
        return search(word, 0, 0);
    }

    bool search(string word, int i, int v) {
        if(i == word.size()) {
            return trie_[v].output;
        }
        char ch = word[i];

        if(ch != '.') {
            int c = ch - 'a';
            if(!trie_[v].next[c]) {
                return false;
            }

            return search(word, i + 1, trie_[v].next[c]);
        }

        for(int c = 0; c < 26; c++) {
            if(!trie_[v].next[c]) {
                continue;
            }

            if(search(word, i + 1, trie_[v].next[c])) {
                return true;
            }
        }

        return false;
    }
    
    vector<Vertex> trie_;
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
// @lc code=end

